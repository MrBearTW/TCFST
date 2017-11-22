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

@app.route('/act', methods=['POST'])
def test():
    AAA = request.form['AAA']
    BBB = request.form['BBB']
    CCC = request.form['CCC']
    DDD = AAA + '-' + BBB + '-' + CCC
    return render_template('act.html', DDD = DDD)

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
    return render_template('clusterresult.html', EEE = EEE)

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



@app.route('/class1_age')
def class1_age():
    age = request.form['age']
    income = request.form['income']
    seniority = request.form['seniority']
    #print(age)
    #X = np.array ([age,income,seniority])
    X = age
    print(X)
    class1_age = joblib.load('save/class1_age.pkl')
    EEE = class1_age.predict([X])
    #print(EEE)
    #return render_template('clusterresult.html', EEE = EEE)
    return render_template('class1result.html', EEE = EEE)

@app.route('/class2')
def class2():
    return render_template('class2.html')

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