import sqlite3
import csv

with open ('FMTQIK.csv',encoding='Big5') as f:
    reader = csv.DictReader(f, fieldnames=["日期","成交股數","成交金額","成交筆數","發行量加權股價指數","漲跌點數"])  #讀檔案
    #print("日期",'\t\t',"成交股數",'\t',"成交金額")    # 列印表頭+表頭排版
    #


connhw = sqlite3.connect('ddb.HW3')
c = connhw.cursor()

#c.execute('''create table HW(日期 Test,成交股數 Integer,成交金額 Integer,成交筆數 Integer,發行量加權股價指數 Integer,漲跌點數 Integer,老師好難  Test)''')   #建立

#c.execute('''insert into HW values(106/11/30,'38','48','930','383.94','54.00','')''')         #新增測試資料

with open ('FMTQIK.csv',encoding='Big5') as f:
    reader = csv.DictReader(f, fieldnames=["日期","成交股數","成交金額","成交筆數","發行量加權股價指數","漲跌點數","老師好難"])  #讀檔案
    #print("日期",'\t\t',"成交股數",'\t',"成交金額")    # 列印表頭+表頭排版
    to_db = [(i['col1'], i['col2']) for i in dr]

    cur.executemany("INSERT INTO t (col1, col2) VALUES (?, ?);", to_db)


    for row in list(reader)[2:-3]:        # 去頭去尾
        #print(row["日期"],'\t',row["成交股數"],'\t',row["成交金額"],row["成交筆數"],row["發行量加權股價指數"],row["漲跌點數"]) # 列印中間的資料
        """
        ab1 = row["日期"]
        ab2 = row["成交股數"]
        ab3 = row["成交金額"]
        ab4 = row["成交筆數"]
        ab5 = row["發行量加權股價指數"]
        ab6 = row["漲跌點數"]
        ab7 = row["老師好難"]
        """
        dicthw = {
        'ab1' : row["日期"],
        'ab2' : row["成交股數"],
        'ab3' : row["成交金額"],
        'ab4' : row["成交筆數"],
        'ab5' : row["發行量加權股價指數"],
        'ab6' : row["漲跌點數"],
        'ab7' : row["老師好難"]
        }

        

        c.execute('''insert into HW values(row["日期"],row["成交股數"],row["成交金額"],row["成交筆數"],row["發行量加權股價指數"],row["漲跌點數"],row["老師好難"])''')
        #c.execute('''insert into HW values(ab1,ab2,ab3,ab4,ab5,ab6,ab7)''')

c.execute('''select * from HW ''')
connhw.commit()
connhw.close
print(c.fetchall())

"""
c.execute('''insert into MSG values(1,'APPLE','OH YA')''')         #新增資料
c.execute('''insert into MSG values(2,'AKEN','YOLO')''')
c.execute('''select * from MSG where name = 'APPLE' ''')            #查詢
conn.commit()
print('ZZZZZZZZZZ',c.fetchall())

c.execute('''delete from MSG where name = 'APPLE' ''')              #刪除
conn.commit()
print('AAAAAAAAAA',c.fetchall())

c.execute('''select * from MSG ''')
conn.commit()
print('BBBBBBBBBB',c.fetchall())

conn.close()

"""

