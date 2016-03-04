'''
kNN: k Nearest Neighbors

Input:      in_x: vector to compare to existing dataset (1x_n)
            data_set: size m data set of known vectors (Nx_m)
            labels: data set labels (1x_m vector)
            k: number of neighbors to use for comparison (should be an odd number)

Output:     the most popular class label

@author: pbharrin
'''
from numpy import *
import operator
from os import listdir

def classify(in_x, data_set, labels, k):
    data_set_size = data_set.shape[0]
    diff_mat = tile(in_x, (data_set_size,1)) - data_set # tile重复数组，后一参数为维度
    sq_diff_mat = diff_mat**2
    sq_distances = sq_diff_mat.sum(axis=1)
    distances = sq_distances**0.5
    sorted_dist_indicies = distances.argsort() # array排序，返回排序后的index
    class_count={}
    for i in range(k):
        vote_ilabel = labels[sorted_dist_indicies[i]]
        class_count[vote_ilabel] = class_count.get(vote_ilabel,0) + 1
    sorted_class_count = sorted(iter(class_count.items()), key=operator.itemgetter(1), reverse=True)
    return sorted_class_count[0][0]

def auto_norm(data_set):
    min_vals = data_set.min(0)
    max_vals = data_set.max(0)
    ranges = max_vals - min_vals
    normdata_set = zeros(shape(data_set))
    m = data_set.shape[0]
    norm_data_set = data_set - tile(min_vals, (m,1))
    norm_data_set = normdata_set/tile(ranges, (m,1))   #element wise divide
    return norm_data_set, ranges, min_vals
