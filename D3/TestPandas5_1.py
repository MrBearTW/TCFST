#import pandas as pd
#import mysql.connector
#import sqlalchemy

#engine = sqlalchemy.create_engine('mysql+pyodbc://root:12345678@localhost:3306/company')

# pyodbc  mysql+pyodbc://<username>:<password>@<dsnname>    https://pypi.python.org/pypi/pyodbc/4.0.19

# mysql+pymysql://<username>:<password>@<host>/<dbname>[?<options>]    # 找不到資源  應該是還沒支援到3.6  https://dev.mysql.com/downloads/connector/python/
# mysql+mysqldb://root:12345678@localhost:3306/company    # No module named 'mysql'
# mysql+mysqlconnector://root:12345678@localhost:3306/company    # No module named 'mysql'
# 'mysql+mysqlcymysqldb://root:12345678@localhost:3306/company'    # No module named 'mysql'


# mysql+mysqldbconnector

#cursor = engine.company.find()
#df = pd.read_sql('stocks', engine)

import MySQLdb

db = MySQLdb.connect(host="localhost", user="root",
                     passwd="12345678", db="company")
c = db.cursor()
#max_price = 5
c.execute("""SELECT * FROM stocks""")
#r = c.fetchone()
r2 = c.fetchall()
print(r2)
