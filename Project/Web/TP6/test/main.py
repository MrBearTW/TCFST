from flask import Flask
from flask import request
from flask import render_template
import pandas as pd
import numpy as np
from sklearn.externals import joblib 

app = Flask(__name__)

@app.route('/cluster')
def hello_word():
    return render_template('cluster.html')   

# @app.route('/act', methods=['POST'])
# def test():
#     AAA = request.form['AAA']
#     BBB = request.form['BBB']
#     CCC = request.form['CCC']
#     DDD = AAA + '-' + BBB + '-' + CCC
#     return render_template('act.html', DDD = DDD)

@app.route('/clusterresult', methods=['POST'])
def cc():
    age = request.form['age']
    income = request.form['income']
    seniority = request.form['seniority']
    #print(age)
    X = np.array ([age,income,seniority])
    print(X)
    clf3 = joblib.load('save/class3.pkl')
    EEE = clf3.predict([X])
    #print(EEE)
    if EEE == 1 :
        clu = '分群在新進客戶群，推薦服務為 1. Taxes 2. Particular Account 3.Credit Card'
    elif EEE == 2 :
        clu = '分群在潛力客戶群，推薦服務為 1. Particular Account 2. Savings 3.Taxes'
    else :
        clu = '分群在忠誠客戶群，推薦服務為 1. Particular Account 2. Loans 3. Taxes'
    return render_template('clusterresult.html', EEE = clu)

@app.route('/') # 首頁
def show7():
    #stocks = pd.read_csv('static/data/stocks.csv')
    # url_for("stocks",filename="data/stocks.csv")
    #print(stocks)
    # return render_template('7show.html',stocks = stocks)
    return render_template('7show.html')

@app.route('/class1') # 首頁
def class1():
    return render_template('class1.html')

@app.route('/class1age', methods=['POST'])
def class1age():
    age = request.form['age']
    # income = request.form['income']
    # seniority = request.form['seniority']
    # print(age)
    # #X = np.array ([age,income,seniority])
    # X = np.array ([age])
    # print(X)
    # class1_age = joblib.load('save/class1_age.pkl')
    # EEE = class1_age.predict([X])
    # print(EEE)
    # #return render_template('clusterresult.html', EEE = EEE)
    X = np.array ([age])
    #print(X)
    class1age = joblib.load('save/class1_age.pkl')
    EEE = class1age.predict([X])
    #print(EEE)
    if EEE == 1 :
        class1 = '分在新進客戶群，推薦服務為 1. Taxes 2. Particular Account 3.Credit Card'
    elif EEE == 2 :
        class1 = '分在潛力客戶群，推薦服務為 1. Particular Account 2. Savings 3.Taxes'
    else :
        class1 = '分在忠誠客戶群，推薦服務為 1. Particular Account 2. Loans 3. Taxes'
    return render_template('class1result.html', EEE = class1)

@app.route('/class1income', methods=['POST'])
def class1income():
    income = request.form['income']
    X = np.array ([income])
    class1age = joblib.load('save/class1_income.pkl')
    EEE = class1age.predict([X])
    if EEE == 1 :
        class1 = '分在新進客戶群，推薦服務為 1. Taxes 2. Particular Account 3.Credit Card'
    elif EEE == 2 :
        class1 = '分在潛力客戶群，推薦服務為 1. Particular Account 2. Savings 3.Taxes'
    else :
        class1 = '分在忠誠客戶群，推薦服務為 1. Particular Account 2. Loans 3. Taxes'
    return render_template('class1result.html', EEE = class1)

@app.route('/class1seniority', methods=['POST'])
def class1seniority():
    seniority = request.form['seniority']
    X = np.array ([seniority])
    class1age = joblib.load('save/class1_seniority.pkl')
    EEE = class1age.predict([X])
    if EEE == 1 :
        class1 = '分在新進客戶群，推薦服務為 1. Taxes 2. Particular Account 3.Credit Card'
    elif EEE == 2 :
        class1 = '分在潛力客戶群，推薦服務為 1. Particular Account 2. Savings 3.Taxes'
    else :
        class1 = '分在忠誠客戶群，推薦服務為 1. Particular Account 2. Loans 3. Taxes'
    return render_template('class1result.html', EEE = class1)


@app.route('/class2')
def class2():
    return render_template('class2.html')

@app.route('/class2ageincome', methods=['POST'])
def class2ageincome():
    age = request.form['age']
    income = request.form['income']
    X = np.array ([age,income])
    class1age = joblib.load('save/class2_age_income.pkl')
    EEE = class1age.predict([X])
    if EEE == 1 :
        class1 = '分在新進客戶群，推薦服務為 1. Taxes 2. Particular Account 3.Credit Card'
    elif EEE == 2 :
        class1 = '分在潛力客戶群，推薦服務為 1. Particular Account 2. Savings 3.Taxes'
    else :
        class1 = '分在忠誠客戶群，推薦服務為 1. Particular Account 2. Loans 3. Taxes'
    return render_template('class2result.html', EEE = class1)

@app.route('/class2ageseniority', methods=['POST'])
def class2ageseniority():
    age = request.form['age']
    seniority = request.form['seniority']
    X = np.array ([age,seniority])
    class1age = joblib.load('save/class2_age_seniority.pkl')
    EEE = class1age.predict([X])
    if EEE == 1 :
        class1 = '分在新進客戶群，推薦服務為 1. Taxes 2. Particular Account 3.Credit Card'
    elif EEE == 2 :
        class1 = '分在潛力客戶群，推薦服務為 1. Particular Account 2. Savings 3.Taxes'
    else :
        class1 = '分在忠誠客戶群，推薦服務為 1. Particular Account 2. Loans 3. Taxes'
    return render_template('class2result.html', EEE = class1)

@app.route('/class2incomeseniority', methods=['POST'])
def class2incomeseniority():
    income = request.form['income']
    seniority = request.form['seniority']
    X = np.array ([seniority,income])
    class1age = joblib.load('save/class2_seniority_income.pkl')
    EEE = class1age.predict([X])
    if EEE == 1 :
        class1 = '分在新進客戶群，推薦服務為 1. Taxes 2. Particular Account 3.Credit Card'
    elif EEE == 2 :
        class1 = '分在潛力客戶群，推薦服務為 1. Particular Account 2. Savings 3.Taxes'
    else :
        class1 = '分在忠誠客戶群，推薦服務為 1. Particular Account 2. Loans 3. Taxes'
    return render_template('class2result.html', EEE = class1)


# @app.route('/static/data')
# def show7data():
#     return render_template('stocks.csv')


# @app.route('/act', methods=['POST'])
# def test():
#     AAA = request.form['AAA']
#     BBB = request.form['BBB']
#     CCC = request.form['CCC']
#     DDD = AAA + '-' + BBB + '-' + CCC
#     return render_template('act.html', DDD = DDD)

# @app.route('/ccresult', methods=['POST'])
# def cc():
#     age = request.form['age']
#     income = request.form['income']
#     seniority = request.form['seniority']
#     #print(age)
#     X = np.array ([age,income,seniority])
#     print(X)
#     clf3 = joblib.load('save/clf2.pkl')
#     EEE = clf3.predict([X])
#     #print(EEE)
#     return render_template('ccend.html', EEE = EEE)


if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0', port=8000)