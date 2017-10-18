import sqlite3
import csv

db_file = 'stock.db'
csv_file = 'FMTQIK.csv'


with open(csv_file,encoding='Big5') as f:
    reader=csv.DictReader(f,fieldnames=["日期","成交股數","成交金額","成交筆數","發行量加權股價指數","漲跌點數"])
    conn =sqlite3.connect(db_file)
    c=conn.cursor()
    c.execute( '''CREATE TABLE stocks(日期 VARCHAR(20), 成交股數 VARCHAR(20), 成交金額 VARCHAR(20), 成交筆數 VARCHAR(20), 發行量加權股價指數 VARCHAR(20),漲跌點數 VARCHAR(20) )''' )
    for row in list(reader)[2:-3]:
        a='\"'+row["日期"]+'\"'
		
        insert = '''INSERT INTO stocks VALUES({}, {}, {}, {}, {}, {})'''.format(a,int(row["成交股數"].replace(',',"")),int(row["成交金額"].replace(',',"")),int(row["成交筆數"].replace(',',"")),float(row["發行量加權股價指數"].replace(',',"")),float(((row["漲跌點數"].replace(',',"")).replace('(','-')).replace(')','')))
        c.execute(insert)
	
    c.execute('''SELECT * FROM stocks''')
    print(c.fetchall())
	
    conn.commit()
    conn.close()

