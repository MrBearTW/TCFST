import sqlite3
import csv


connhw = sqlite3.connect('ddb.HW3')
c = connhw.cursor()

# 建立資料表
#c.execute('''create table HW(日期 Test,成交股數 Integer,成交金額 Integer,成交筆數 Integer,發行量加權股價指數 Integer,漲跌點數 Integer)''')   #建立表格


with open ('FMTQIK.csv',encoding='Big5') as f:
    reader = csv.DictReader(f, fieldnames=["日期","成交股數","成交金額","成交筆數","發行量加權股價指數","漲跌點數"])  #讀檔案
    for row in list(reader)[2:-3]:    # 去頭去尾
        #print(row)
        a='\"'+row["日期"]+'\"'
        #insert = '''INSERT INTO HW VALUES(row ["日期"],row["成交股數"],row["成交金額"],row["成交筆數"],row["發行量加權股價指數"],row["漲跌點數"] )'''
        #insert = '''INSERT INTO HW VALUES(?, ?, ?, ?, ?, ?)'''.format(row ["日期"],row["成交股數"],row["成交金額"],row["成交筆數"],row["發行量加權股價指數"],row["漲跌點數"])
        insert = '''INSERT INTO HW VALUES({}, {}, {}, {}, {}, {})'''.format(a,int(row["成交股數"].replace(',',"")),int(row["成交金額"].replace(',',"")),int(row["成交筆數"].replace(',',"")),float(row["發行量加權股價指數"].replace(',',"")),float(((row["漲跌點數"].replace(',',"")).replace('(','-')).replace(')','')))
        c.execute(insert)

c.execute('''select * from HW ''')
connhw.commit()
connhw.close
print(c.fetchall())
