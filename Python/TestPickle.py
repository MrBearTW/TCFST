import pickle
s={'Apple','Colin'}
pkd=pickle.dumps(s)

print(pkd)
print(pickle.loads(pkd))