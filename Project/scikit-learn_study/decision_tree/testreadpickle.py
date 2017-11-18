#from sklearn import tree
#from sklearn.datasets import load_iris
#from sklearn import tree
import pandas as pd
import numpy as np



X = np.array ([1, 1, 1])
#X = X.reshape(-1, 1)
#print(type(X))
#print(X)
'''
# 方法一
import pickle
with open('save/clf1.pickle','rb') as f:
    clf2=pickle.load(f)
    print(clf2.predict([X]))
'''

#方法二
from sklearn.externals import joblib #jbolib模块
clf3 = joblib.load('save/clf2.pkl')
A=clf3.predict([X])
#print(clf3.predict([X]))
print(A)

#S = A.tostring
#print(S)