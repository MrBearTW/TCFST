from flask import Flask
from flask import request
from flask import render_template
import pandas as pd
import numpy as np
from sklearn.externals import joblib 
# stocks = pd.read_csv('data/stocks.csv')
# print(stocks)

age = 1
X = age
print(X)
class1_age = joblib.load('save/class1_age.pkl')
EEE = class1_age.predict([X])

print(EEE)