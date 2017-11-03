from __future__ import print_function

import os
import subprocess

import pandas as pd
import numpy as np
from sklearn import cluster, datasets, metrics
import matplotlib.pyplot as plt


def get_iris_data():
    """Get the iris data, from local csv or pandas repo."""
    if os.path.exists("iris.csv"):
        print("-- iris.csv found locally")
        #df = pd.read_csv("iris.csv", index_col=0)
        df = pd.read_csv("SEMCOM_TE50.csv",encoding='ansi')
    else:
        print("-- trying to download from github")
        fn = "https://raw.githubusercontent.com/pydata/pandas/" + \
             "master/pandas/tests/data/iris.csv"
        try:
            df = pd.read_csv(fn)
        except:
            exit("-- Unable to download iris.csv")

        with open("iris.csv", 'w') as f:
            print("-- writing to local iris.csv file")
            df.to_csv(f)

    return df

df = get_iris_data()    
#print(df.head())
#print("* df.tail()", df.tail(), sep="\n", end="\n\n")

#print("* iris types:", df["Name"].unique(), sep="\n")

def encode_target(df, target_column):
    """Add column to df with integers for the target.

    Args
    ----
    df -- pandas DataFrame.
    target_column -- column to map to int, producing
                     new Target column.

    Returns
    -------
    df_mod -- modified DataFrame.
    targets -- list of target names.
    """
    df_mod = df.copy()
    targets = df_mod[target_column].unique()
    map_to_int = {name: n for n, name in enumerate(targets)}
    df_mod["Target"] = df_mod[target_column].replace(map_to_int)

    return (df_mod, targets)
    
df2, targets = encode_target(df, "res")
#print("* df2.head()", df2[["Target", "Name"]].head(),sep="\n", end="\n\n")
#print("* df2.tail()", df2[["Target", "Name"]].tail(),sep="\n", end="\n\n")
#print("* targets", targets, sep="\n", end="\n\n")

#:4只取前五個變數的資料
features = list(df2.columns[:4])
print("* features:", features, sep="\n")

y = df2["Target"]
X = df2[features]
dt = cluster.KMeans(n_clusters=2).fit(X)

#印出分群結果
cluster_labels = dt.labels_
print("分群結果")
print(cluster_labels )
print("----------")

#印出原答案
print("原始答案")
iris_y = y
print(iris_y)

# 印出績效
silhouette_avg = metrics.silhouette_score(X, cluster_labels)
print("檢驗成功率")
print(silhouette_avg)

# View the results
# Set the size of the plot
plt.figure()

# Create a colormap
colormap = np.array(['red', 'lime', 'black'])
X1 = pd.DataFrame(X)
y1 = pd.DataFrame(y)
# Plot the Original Classifications
plt.subplot(1, 2, 1)
plt.scatter(X1.p2, X1.p3, c=colormap[y1.Target], s=5)
plt.title('Real Classification')

# Plot the Models Classifications
plt.subplot(1, 2, 2)
plt.scatter(X1.p2, X1.p3, c=colormap[dt.labels_], s=5)
plt.title('K Mean Classification')

# 迴圈
#silhouette_avgs = []
#ks = range(2, 11)
#for k in ks:
#    kmeans_fit = cluster.KMeans(n_clusters = k).fit(X)
#    cluster_labels = kmeans_fit.labels_
#    silhouette_avg = metrics.silhouette_score(X, cluster_labels)
#    silhouette_avgs.append(silhouette_avg)

# 作圖並印出 k = 2 到 10 的績效
#plt.subplot(1, 2, 3)
#plt.bar(ks, silhouette_avgs)
plt.show()
#print(silhouette_avgs)



