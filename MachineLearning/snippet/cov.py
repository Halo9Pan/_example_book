import numpy

x=[100,120,140]
y=[50,60,70]
z=[80,0,160]

s=[x,y]
print("二维数组：\n%s" %s)

a=numpy.cov(s)
print("协方差矩阵：\n%s" %a)

print("\n")

t=[x,y,z]
print("二维数组：\n%s" %t)

b=numpy.cov(t)
print("协方差矩阵：\n%s" %b)

