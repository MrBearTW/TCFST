from flask import Flask
from flask import request
from flask import render_template
import pandas as pd
import numpy as np
from sklearn.externals import joblib 

app = Flask(__name__)

@app.route('/')
def hello_word():
    return render_template('cc.html')    # 首頁

@app.route('/act', methods=['POST'])
def test():
    AAA = request.form['AAA']
    BBB = request.form['BBB']
    CCC = request.form['CCC']
    DDD = AAA + '-' + BBB + '-' + CCC
    return render_template('act.html', DDD = DDD)

@app.route('/ccresult', methods=['POST'])
def cc():
    age = request.form['age']
    income = request.form['income']
    seniority = request.form['seniority']
    X = np.array ([age,income,seniority])

    clf3 = joblib.load('save/clf2.pkl')
    EEE = clf3.predict([X])
    return render_template('ccend.html', EEE = EEE)

if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0', port=8000)