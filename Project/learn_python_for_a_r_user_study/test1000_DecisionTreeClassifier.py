from sklearn.datasets import load_iris
from sklearn import tree
from sklearn.cross_validation import train_test_split
import csv
from sklearn import datasets
from sklearn import cluster

# 讀入鳶尾花資料

with open('test1000.csv',encoding='Big5')as f:
    reader=csv.DictReader(f,fieldnames=["ID","p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11","p12","p13","p14","p15","p16","p17","p18","p19","p20","p21"])
    l1 = list(reader)
    #print(l1)

# 建立分類器
clf =  cluster.KMeans(init='k-means++', n_clusters=10, random_state=42)
iris_clf = clf.fit(l1)


# 預測
test_y_predicted = iris_clf.predict(l1)
#print(test_y_predicted)

'''
    for row in list(reader)[1:]:
        print(row["ID"],'\t',row["p1"],'\t',row["p2"])
'''

'''
digits = datasets.load_digits(C://JavaSpace//Project//learn_python_for_a_r_user_study//test1000.csv)
print(digits)
'''



'''
iris = load_iris()
iris_X = iris.data
iris_y = iris.target

# 切分訓練與測試資料
train_X, test_X, train_y, test_y = train_test_split(iris_X, iris_y, test_size = 0.3)

# 建立分類器
clf = tree.DecisionTreeClassifier()
iris_clf = clf.fit(train_X, train_y)

# 預測
test_y_predicted = iris_clf.predict(test_X)
print(test_y_predicted)

# 標準答案
print(test_y)
'''