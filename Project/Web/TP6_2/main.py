from flask import Flask
from flask import request
from flask import render_template
import MySQLdb # pip3 install mysqlclient

app = Flask(__name__)


@app.route('/')
def hello_word():
    return render_template('mysqlinput.html')

# @app.route('/mysqlinput', methods=['POST'])
# def test():
#     AAA = request.form['AAA']
#     BBB = request.form['BBB']
#     CCC = request.form['CCC']
#     DDD = AAA + '-' + BBB + '-' + CCC
#     return render_template('act.html', DDD = DDD)

@app.route('/act', methods=['POST'])
def test():
    AAA = request.form['AAA']
    BBB = request.form['BBB']
    CCC = request.form['CCC']
    DDD = AAA + '-' + BBB + '-' + CCC
    return render_template('act.html', DDD = DDD)

@app.route('/mysqlinput', methods=['GET'])
def mysqlinput():
    db = MySQLdb.connect( # 連接資料庫
            host = '127.0.0.1',
            port = 3306,
            user = 'root',
            passwd = '123456',
            db = 'bank',
            charset = "utf8"
        )
    id1 = 1375586
    sql = "SELECT * FROM train_ver2 WHERE ncodpers =" + str(id1) 
    # sno = " + str(sno)
    query = db.cursor()
    query.execute(sql)
    result = query.fetchall()
    offices = list()
    for row in result:
        #print(row[2])
        #offices.append(row[2])
        #print(row[4])
        offices.append(row[4])
    return render_template('mysqlTest.html', offices = offices)

if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0', port=8000)