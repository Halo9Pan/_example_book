# from numpy import *
import numpy as num
x = num.array([[3,4],[5,6],[2,2],[8,4]])
print("numpy array: %s\n%s" %(type(x), x))
x_T=x.T
print("transpose numpy array:\n%s" %x_T)
d=num.cov(x_T)
print("transpose numpy array covariance matrix:\n%s" %d)
inv_d=num.linalg.inv(d)
print("transpose numpy array covariance matrix inverse:\n%s" %inv_d)
tp=x[0]-x[1]
print("distance:\n%s - %s = %s" %(x[0], x[1], tp))
dot_tp_inv_d = num.dot(tp,inv_d)
print("dot 'distance' and 'transpose numpy array covariance matrix inverse':\n%s" %dot_tp_inv_d)
dot_tp_inv_d_tp_T = num.dot(dot_tp_inv_d,tp.T)
print("dot 'distance and transpose numpy array covariance matrix inverse' and 'distance inverse':\n%s" %dot_tp_inv_d_tp_T)
mahalanobis_distance = num.sqrt(dot_tp_inv_d_tp_T)
print("mahalanobis distance:\n%s" %mahalanobis_distance)