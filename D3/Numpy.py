# 自修練習Ch7
import numpy as np

a = np.array([1,2,3])

a+a

def print_array_details(a):
    print('Dimensions:%d,shape:%s,dtype:%s'%(a.ndim,a.shape,a.dtype))

a= np.arry([1,2,3,4,5,6,7,8])
print_array_details(a)

a.reshape([2,4])
a.reshape([2,2,2])
