from sklearn import datasets
from sklearn.svm import SVR
import matplotlib.pyplot as plt
from sklearn.preprocessing import StandardScaler
import numpy as np
import pandas as pd

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
    df_mod["Target"] = df_mod[target_column].replace(map_to_int)

    return (df_mod, targets)

df2, targets = encode_target(df, "V1")
features = list(df2.columns[1:590])
print("* features:", features, sep="\n")

y = df2["Target"]
X = df2[features]
print(X.shape)
print(y.shape)

clf = SVR(kernel='rbf', C=1e3, gamma=0.1)
clf.fit(X.ix[1:500], y.ix[1:500])
from sklearn.externals import joblib
joblib.dump(clf,"./machine_SVR.pkl")
clf=joblib.load("./machine_SVR.pkl")
clf.fit(X, y)

temp =  X.ix[502] #an instance
temp = np.array(temp).reshape((1, -1))
predict_y=clf.predict(temp)
predict=clf.predict(X)
print("predict_y",predict_y)

predictFinal=(np.append(y,predict)).reshape([2,1567])
print(predictFinal )
PF2=predictFinal.transpose()
print(PF2)
df = pd.DataFrame (PF2)
df.to_csv("PF2.csv" , encoding = "utf-8")

clf.score(X, y)
plt.scatter(predict,y,s=2)
plt.plot(predict_y, predict_y, 'ro')
plt.plot([y.min(), y.max()], [y.min(), y.max()], 'k--', lw=2)
plt.xlabel('Predicted')
plt.ylabel('Measured')
plt.show()
