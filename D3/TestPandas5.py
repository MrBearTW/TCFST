import pandas as pd
import mysql.connector
import sqlalchemy

engine = sqlalchemy.create_engine('mysql+mysql://root:12345678@localhost:3306/company')
# mysql+pymysql://<username>:<password>@<host>/<dbname>[?<options>]
# mysql+mysqldbconnector

#cursor = engine.company.find()
df = pd.read_sql('stocks', engine)
