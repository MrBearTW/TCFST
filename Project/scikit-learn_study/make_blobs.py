from sklearn.datasets.samples_generator import make_blobs
X, y = make_blobs(n_samples=10, centers=3, n_features=5,
                  random_state=0)

print(X, y)

#print(X)
#print(X.shape)

#print(y)
#print(y.shape)