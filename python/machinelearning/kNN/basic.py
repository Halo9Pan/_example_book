'''
Created on Sep 16, 2010
kNN: k Nearest Neighbors

Input:      in_x: vector to compare to existing dataset (1x_n)
            data_set: size m data set of known vectors (Nx_m)
            labels: data set labels (1x_m vector)
            k: number of neighbors to use for comparison (should be an odd number)

Output:     the most popular class label

@author: pbharrin
'''
from os import listdir
from numpy import *
import operator
import util

def create_data_set():
    group = array([[1.0,1.1],[1.0,1.0],[0,0],[0,0.1]])
    labels = ['A','A','B','B']
    return group, labels

def file_matrix(filename):
    love_dictionary={'large_doses':3, 'small_doses':2, 'didnt_like':1}
    fr = open(filename)
    array_lines = fr.readlines()
    lines_number = len(array_lines)            #get the number of lines in the file
    return_mat = zeros((lines_number,3))       #prepare matrix to return
    class_label_vector = []                    #prepare labels return
    index = 0
    for line in array_lines:
        line = line.strip()
        list_from_line = line.split('\t')
        return_mat[index,:] = list_from_line[0:3]
        if(list_from_line[-1].isdigit()):
            class_label_vector.append(int(list_from_line[-1]))
        else:
            class_label_vector.append(love_dictionary.get(list_from_line[-1]))
        index += 1
    return return_mat,class_label_vector

def dating_class_test():
    ho_ratio = 0.50      #hold out 10%
    dating_data_mat,dating_labels = file_matrix('dating_test_set2.txt')       #load data setfrom file
    norm_mat, ranges, min_vals = auto_norm(dating_data_mat)
    m = norm_mat.shape[0]
    num_test_vecs = int(m*ho_ratio)
    error_count = 0.0
    for i in range(num_test_vecs):
        classifier_result = classify(norm_mat[i,:],norm_mat[num_test_vecs:m,:],dating_labels[num_test_vecs:m],3)
        print(("the classifier came back with: %d, the real answer is: %d" %(classifier_result, dating_labels[i])))
        if (classifier_result != dating_labels[i]): error_count += 1.0
    print("the total error rate is: %f" %(error_count/float(num_test_vecs)))
    print(error_count)

def classify_person():
    result_list = ['not at all', 'in small doses', 'in large doses']
    percent_tats = float(input(\
                                  "percentage of time spent playing video games?"))
    ff_miles = float(input("frequent flier miles earned per year?"))
    ice_cream = float(input("liters of ice cream consumed per year?"))
    dating_data_mat, dating_labels = file_matrix('dating_test_set2.txt')
    norm_mat, ranges, min_vals = auto_norm(dating_data_mat)
    in_arr = array([ff_miles, percent_tats, ice_cream, ])
    classifier_result = classify((in_arr - \
                                  min_vals)/ranges, norm_mat, dating_labels, 3)
    print("You will probably like this person: %s" %(result_list[classifier_result - 1]))

def img2vector(filename):
    return_vect = zeros((1,1024))
    fr = open(filename)
    for i in range(32):
        line_str = fr.readline()
        for j in range(32):
            return_vect[0,32*i+j] = int(line_str[j])
    return return_vect

def handwriting_class_test():
    hw_labels = []
    training_file_list = listdir('training_digits')           #load the training set
    m = len(training_file_list)
    training_mat = zeros((m,1024))
    for i in range(m):
        file_name_str = training_file_list[i]
        file_str = file_name_str.split('.')[0]     #take off .txt
        class_num_str = int(file_str.split('_')[0])
        hw_labels.append(class_num_str)
        training_mat[i,:] = img2vector('training_digits/%s' % file_name_str)
    test_file_list = listdir('test_digits')        #iterate through the test set
    error_count = 0.0
    m_test = len(test_file_list)
    for i in range(m_test):
        file_name_str = test_file_list[i]
        file_str = file_name_str.split('.')[0]     #take off .txt
        class_num_str = int(file_str.split('_')[0])
        vector_under_test = img2vector('test_digits/%s' % file_name_str)
        classifier_result = classify(vector_under_test, training_mat, hw_labels, 3)
        print("the classifier came back with: %d, the real answer is: %d" %(classifier_result, class_num_str))
        if (classifier_result != class_num_str): error_count += 1.0
    print("\nthe total number of errors is: %d" %(error_count))
    print("\nthe total error rate is: %f" %(error_count/float(m_test)))
