'''
Created on Nov 28, 2010
Adaboost is short for Adaptive Boosting
@author: Peter
'''
from numpy import *

def load_simp_data():
    dat_mat = matrix([[ 1. ,  2.1],
        [ 2. ,  1.1],
        [ 1.3,  1. ],
        [ 1. ,  1. ],
        [ 2. ,  1. ]])
    class_labels = [1.0, 1.0, -1.0, -1.0, 1.0]
    return dat_mat,class_labels

def load_data_set(file_name):      #general function to parse tab -delimited floats
    num_feat = len(open(file_name).readline().split('\t')) #get number of fields
    data_mat = []; label_mat = []
    fr = open(file_name)
    for line in fr.readlines():
        line_arr =[]
        cur_line = line.strip().split('\t')
        for i in range(num_feat-1):
            line_arr.append(float(cur_line[i]))
        data_mat.append(line_arr)
        label_mat.append(float(cur_line[-1]))
    return data_mat,label_mat

def stump_classify(data_matrix,dimen,thresh_val,thresh_ineq):#just classify the data
    ret_array = ones((shape(data_matrix)[0],1))
    if thresh_ineq == 'lt':
        ret_array[data_matrix[:,dimen] <= thresh_val] = -1.0
    else:
        ret_array[data_matrix[:,dimen] > thresh_val] = -1.0
    return ret_array


def build_stump(data_arr,class_labels,D):
    data_matrix = mat(data_arr); label_mat = mat(class_labels).T
    m,n = shape(data_matrix)
    num_steps = 10.0; best_stump = {}; best_clas_est = mat(zeros((m,1)))
    min_error = inf #init error sum, to +infinity
    for i in range(n):#loop over all dimensions
        range_min = data_matrix[:,i].min(); range_max = data_matrix[:,i].max();
        step_size = (range_max-range_min)/num_steps
        for j in range(-1,int(num_steps)+1):#loop over all range in current dimension
            for inequal in ['lt', 'gt']: #go over less than and greater than
                thresh_val = (range_min + float(j) * step_size)
                predicted_vals = stump_classify(data_matrix,i,thresh_val,inequal)#call stump classify with i, j, less_than
                err_arr = mat(ones((m,1)))
                err_arr[predicted_vals == label_mat] = 0
                weighted_error = D.T*err_arr  #calc total error multiplied by D
                #print "split: dim %d, thresh %.2f, thresh ineqal: %s, the weighted error is %.3f" % (i, thresh_val, inequal, weighted_error)
                if weighted_error < min_error:
                    min_error = weighted_error
                    best_clas_est = predicted_vals.copy()
                    best_stump['dim'] = i
                    best_stump['thresh'] = thresh_val
                    best_stump['ineq'] = inequal
    return best_stump,min_error,best_clas_est


def ada_boost_train_ds(data_arr,class_labels,num_it=40):
    weak_class_arr = []
    m = shape(data_arr)[0]
    D = mat(ones((m,1))/m)   #init D to all equal
    agg_class_est = mat(zeros((m,1)))
    for i in range(num_it):
        best_stump,error,class_est = build_stump(data_arr,class_labels,D)#build Stump
        #print "D:",D.T
        alpha = float(0.5*log((1.0-error)/max(error,1e-16)))#calc alpha, throw in max(error,eps) to account for error=0
        best_stump['alpha'] = alpha
        weak_class_arr.append(best_stump)                  #store Stump Params in Array
        #print "class_est: ",class_est.T
        expon = multiply(-1*alpha*mat(class_labels).T,class_est) #exponent for D calc, getting messy
        D = multiply(D,exp(expon))                              #Calc New D for next iteration
        D = D/D.sum()
        #calc training error of all classifiers, if this is 0 quit for loop early (use break)
        agg_class_est += alpha*class_est
        #print "agg_class_est: ",agg_class_est.T
        agg_errors = multiply(sign(agg_class_est) != mat(class_labels).T,ones((m,1)))
        error_rate = agg_errors.sum()/m
        print("total error: %s", error_rate)
        if error_rate == 0.0: break
    return weak_class_arr

def ada_classify(dat_to_class,classifier_arr):
    data_matrix = mat(dat_to_class)#do stuff similar to last agg_class_est in ada_boost_train_ds
    m = shape(data_matrix)[0]
    agg_class_est = mat(zeros((m,1)))
    for i in range(len(classifier_arr)):
        class_est = stump_classify(data_matrix, classifier_arr[i]['dim'],\
                                 classifier_arr[i]['thresh'],\
                                 classifier_arr[i]['ineq'])#call stump classify
        agg_class_est += classifier_arr[i]['alpha']*class_est
        print(agg_class_est)
    return sign(agg_class_est)

def plot_roc(pred_strengths, class_labels):
    import matplotlib.pyplot as plt
    cur = (1.0,1.0) #cursor
    y_sum = 0.0 #variable to calculate A_uC
    num_pos_clas = sum(array(class_labels)==1.0)
    y_step = 1/float(num_pos_clas); x_step = 1/float(len(class_labels)-num_pos_clas)
    sorted_indicies = pred_strengths.argsort()#get sorted index, it's reverse
    fig = plt.figure()
    fig.clf()
    ax = plt.subplot(111)
    #loop through all the values, drawing a line segment at each point
    for index in sorted_indicies.tolist()[0]:
        if class_labels[index] == 1.0:
            del_x = 0; del_y = y_step;
        else:
            del_x = x_step; del_y = 0;
            y_sum += cur[1]
        #draw line from cur to (cur[0]-del_x,cur[1]-del_y)
        ax.plot([cur[0],cur[0]-del_x],[cur[1],cur[1]-del_y], c='b')
        cur = (cur[0]-del_x,cur[1]-del_y)
    ax.plot([0,1],[0,1],'b--')
    plt.xlabel('False positive rate'); plt.ylabel('True positive rate')
    plt.title('R_oC curve for Ada_boost horse colic detection system')
    ax.axis([0,1,0,1])
    plt.show()
    print("the Area Under the Curve is: %s", y_sum*x_step)
