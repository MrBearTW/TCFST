#http://scikit-learn.org/stable/modules/generated/sklearn.cluster.KMeans.html#sklearn.cluster.KMeans
from sklearn.cluster import KMeans
import numpy as np
import pandas as pd


X = np.array([[1, 2], [1, 4], [1, 0],[4, 2], [4, 4], [4, 0]])
kmeans = KMeans(n_clusters=2, random_state=0).fit(X)
kmeans.labels_
#print(kmeans.labels_)

kmeans.predict([[0, 0], [4, 4]])
#print(kmeans.predict([[0, 0], [4, 4]]))

kmeans.cluster_centers_
#print(kmeans.cluster_centers_)

df = pd.read_csv('300.csv')
dfK = KMeans(n_clusters=3, random_state=0).fit(df)
dfkl = dfK.labels_
print(dfkl)