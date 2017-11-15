
from sklearn import datasets
from sklearn import svm
import matplotlib.pyplot as plt
from sklearn.preprocessing import StandardScaler
import numpy as np
import pandas as pd
from matplotlib.colors import ListedColormap

df = pd.read_csv("secom_Nomalize.csv", encoding='ansi')

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
    print(map_to_int)
    #df_mod["Target"] = df_mod[target_column].replace(map_to_int)
    df_mod["Target"] = df_mod[target_column]

    return (df_mod, targets)

df2, targets = encode_target(df, "V1")
features = list(df2.columns[1:590])
print("* features:", features, sep="\n")

y = df2["Target"]
X = df2[features]
print(X.shape)
print(y.shape)

#clf = svm.SVC(kernel='rbf', gamma=3, C=10)
clf = svm.SVC((kernel='rbf', C=1e3, gamma=0.1)
clf.fit(X.ix[1:500], y.ix[1:500])
from sklearn.externals import joblib
joblib.dump(clf,"./machine_SVR.pkl")
clf=joblib.load("./machine_SVR.pkl")
#clf.fit(X, y)

temp =  X.ix[502] #an instance
temp = np.array(temp).reshape((1, -1))
predict_y=clf.predict(temp)
predict=clf.predict(X)
print("predict_y",predict_y)

#y代表target原結果,predict為預測的結果,將其合併再組成兩丙的列,匯出做比較

print(type(y))
print(type(predict))


PF2= list(zip(y,predict))

print(np.array(PF2).shape)

df2 = pd.DataFrame (PF2)
df2.to_csv("PF2.csv" , encoding = "utf-8")



#clf.score(X, y)
#plt.scatter(predict,y,s=2)
#plt.plot(predict_y, predict_y, 'ro')
#plt.plot([y.min(), y.max()], [y.min(), y.max()], 'k--', lw=2)
#plt.xlabel('Predicted')
#plt.ylabel('Measured')
# setup marker generator and color map
markers = ('s', 'x', 'o', '^', 'v')
colors = ('red', 'blue', 'lightgreen', 'gray', 'cyan')
cmap = ListedColormap(colors[:len(np.unique(y))])

# plot the decision surface
resolution=0.02

x1_min, x1_max = np.array(X)[:, 0].min() - 1, np.array(X)[:, 0].max() + 1
x2_min, x2_max =np.array(X)[:, 1].min() - 1, np.array(X)[:, 1].max() + 1
xx1, xx2 = np.meshgrid(np.arange(x1_min, x1_max, resolution),
                       np.arange(x2_min, x2_max, resolution))
#Z = clf.predict(np.array([xx1.ravel(), xx2.ravel()]).T)
#Z = Z.reshape(xx1.shape)
#plt.contourf(xx1, xx2, Z, alpha=0.4, cmap=cmap)
plt.xlim(xx1.min(), xx1.max())
plt.ylim(xx2.min(), xx2.max())

for idx, cl in enumerate(np.unique(y)):
    plt.scatter(x=np.array(X)[y == cl, 0], y=np.array(X)[y == cl, 1],
                alpha=0.8, c=cmap(idx),
                marker=markers[idx], label=cl)

plt.show()
scores = clf.score(X, y)
print(scores)

plt.show()
