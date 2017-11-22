from flask import Flask
from flask import request
from flask import render_template
import pandas as pd
import numpy as np
from sklearn.externals import joblib 
# stocks = pd.read_csv('data/stocks.csv')
# print(stocks)

'''
age = 1
#X = age
X = np.array ([age])
print(X)
class1_age = joblib.load('save/class1_age.pkl')
EEE = class1_age.predict([X])
print(EEE)
'''

EEE = 3
if EEE == 1 :
    class1 = '分在新進客戶群，推薦服務為 1. Taxes 2. Particular Account 3.Credit Card'
elif EEE == 2 :
    class1 = '分在潛力客戶群，推薦服務為 1. Particular Account 2. Savings 3.Taxes'
else :
    class1 = '分在忠誠客戶群，推薦服務為 1. Particular Account 2. Loans 3. Taxes'
print(class1)

    # X = np.array ([age])
    # #print(X)
    # class1age = joblib.load('save/class1_age.pkl')
    # EEE = class1age.predict([X])
    # #print(EEE)
    # return render_template('class1result.html', EEE = EEE)