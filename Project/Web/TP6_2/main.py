from flask import Flask
from flask import request
from flask import render_template
import MySQLdb # pip3 install mysqlclient

app = Flask(__name__)


@app.route('/')
def hello_word():
    return render_template('test.html')

@app.route('/act', methods=['POST'])
def test():
    AAA = request.form['AAA']
    BBB = request.form['BBB']
    CCC = request.form['CCC']
    DDD = AAA + '-' + BBB + '-' + CCC
    return render_template('act.html', DDD = DDD)

@app.route('/mysqlTest', methods=['GET'])
def mysqlTest():
    db = MySQLdb.connect( # 連接資料庫
            host = '127.0.0.1',
            port = 3306,
            user = 'root',
            passwd = 'qazx1234',
            db = 'lab303web',
            charset = "utf8"
        )
    sno = 1
    sql = "SELECT * FROM members WHERE sno = " + str(sno)
    query = db.cursor()
    query.execute(sql)
    result = query.fetchall()
    offices = list()
    for row in result:
        print(row[2])
        offices.append(row[2])
    return render_template('mysqlTest.html', offices = offices)

if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0', port=5000)