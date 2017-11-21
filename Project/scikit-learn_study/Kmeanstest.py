#http://scikit-learn.org/stable/modules/generated/sklearn.cluster.KMeans.html#sklearn.cluster.KMeans
from sklearn.cluster import KMeans
import numpy as np
import pandas as pd
from sklearn import tree
from sklearn.datasets import load_iris
from sklearn import tree
import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split

'''
X = np.array([[1, 2], [1, 4], [1, 0],[4, 2], [4, 4], [4, 0]])
kmeans = KMeans(n_clusters=2, random_state=0).fit(X)
kmeans.labels_
#print(kmeans.labels_)

kmeans.predict([[0, 0], [4, 4]])
#print(kmeans.predict([[0, 0], [4, 4]]))

kmeans.cluster_centers_
#print(kmeans.cluster_centers_)
'''


'''
df = pd.read_csv('300.csv')
dfK = KMeans(n_clusters=3, random_state=0).fit(df)
dfkl = dfK.labels_
#print(dfkl)
#print(dfK.cluster_centers_)
'''

cc = pd.read_csv('cluster_1110_2_20171113_addC.csv',index_col=0)
X1 = cc.iloc[:,1:2] #+ cc.iloc[:,3:5]
X2 = cc.iloc[:,3:5]
#X =X1 +X2
X = pd.concat([X1, X2], axis=1)
#print(type(X))
#print(X)
X = np.array(X)

ccK = KMeans(n_clusters=3, random_state=0).fit(X)
#cckl = ccK.labels_

#print(cckl)

K = np.array([30, 20000000000, 20000000000])
from sklearn.externals import joblib #jbolib模块

joblib.dump(ccK, 'save/cck.pkl')

ccK2 = joblib.load('save/cck.pkl')
A=ccK2.predict([K])
#print(clf3.predict([X]))
print(A)