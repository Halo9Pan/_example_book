'''
Created on Oct 12, 2010
Decision Tree Source Code for Machine Learning in Action Ch. 3
@author: Peter Harrington
'''
from math import log
import operator

def create_data_set():
    data_set = [[1, 1, 'yes'],
               [1, 1, 'yes'],
               [1, 0, 'no'],
               [0, 1, 'no'],
               [0, 1, 'no']]
    labels = ['no surfacing','flippers']
    #change to discrete values
    return data_set, labels

def calc_shannon_ent(data_set):
    num_entries = len(data_set)
    label_counts = {}
    for feat_vec in data_set: #the the number of unique elements and their occurance
        current_label = feat_vec[-1]
        if current_label not in list(label_counts.keys()): label_counts[current_label] = 0
        label_counts[current_label] += 1
    shannon_ent = 0.0
    for key in label_counts:
        prob = float(label_counts[key])/num_entries
        shannon_ent -= prob * log(prob,2) #log base 2
    return shannon_ent

def split_data_set(data_set, axis, value):
    ret_data_set = []
    for feat_vec in data_set:
        if feat_vec[axis] == value:
            reduced_feat_vec = feat_vec[:axis]     #chop out axis used for splitting
            reduced_feat_vec.extend(feat_vec[axis+1:])
            ret_data_set.append(reduced_feat_vec)
    return ret_data_set

def choose_best_feature_to_split(data_set):
    num_features = len(data_set[0]) - 1      #the last column is used for the labels
    base_entropy = calc_shannon_ent(data_set)
    best_info_gain = 0.0; best_feature = -1
    for i in range(num_features):        #iterate over all the features
        feat_list = [example[i] for example in data_set]#create a list of all the examples of this feature
        unique_vals = set(feat_list)       #get a set of unique values
        new_entropy = 0.0
        for value in unique_vals:
            sub_data_set = split_data_set(data_set, i, value)
            prob = len(sub_data_set)/float(len(data_set))
            new_entropy += prob * calc_shannon_ent(sub_data_set)
        info_gain = base_entropy - new_entropy     #calculate the info gain; ie reduction in entropy
        if (info_gain > best_info_gain):       #compare this to the best gain so far
            best_info_gain = info_gain         #if better than current best, set to best
            best_feature = i
    return best_feature                      #returns an integer

def majority_cnt(class_list):
    class_count={}
    for vote in class_list:
        if vote not in list(class_count.keys()): class_count[vote] = 0
        class_count[vote] += 1
    sorted_class_count = sorted(iter(class_count.items()), key=operator.itemgetter(1), reverse=True)
    return sorted_class_count[0][0]

def create_tree(data_set,labels):
    class_list = [example[-1] for example in data_set]
    if class_list.count(class_list[0]) == len(class_list):
        return class_list[0]#stop splitting when all of the classes are equal
    if len(data_set[0]) == 1: #stop splitting when there are no more features in data_set
        return majority_cnt(class_list)
    best_feat = choose_best_feature_to_split(data_set)
    best_feat_label = labels[best_feat]
    my_tree = {best_feat_label:{}}
    del(labels[best_feat])
    feat_values = [example[best_feat] for example in data_set]
    unique_vals = set(feat_values)
    for value in unique_vals:
        sub_labels = labels[:]       #copy all of labels, so trees don't mess up existing labels
        my_tree[best_feat_label][value] = create_tree(split_data_set(data_set, best_feat, value),sub_labels)
    return my_tree

def classify(input_tree,feat_labels,test_vec):
    first_str = list(input_tree.keys())[0]
    second_dict = input_tree[first_str]
    feat_index = feat_labels.index(first_str)
    key = test_vec[feat_index]
    value_of_feat = second_dict[key]
    if isinstance(value_of_feat, dict):
        class_label = classify(value_of_feat, feat_labels, test_vec)
    else: class_label = value_of_feat
    return class_label

def store_tree(input_tree,filename):
    import pickle
    fw = open(filename,'w')
    pickle.dump(input_tree,fw)
    fw.close()

def grab_tree(filename):
    import pickle
    fr = open(filename)
    return pickle.load(fr)

