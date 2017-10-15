import sqlite3
import csv

with open ('FMTQIK.csv',encoding='Big5') as f:
    reader = csv.DictReader(f, fieldnames=["日期","成交股數","成交金額","成交筆數","發行量加權股價指數","漲跌點數"])  #讀檔案
    #print("日期",'\t\t',"成交股數",'\t',"成交金額")    # 列印表頭+表頭排版
    #for row in list(reader)[2:-3]:        # 去頭去尾
    #    print(row["日期"],'\t',row["成交股數"],'\t',row["成交金額"]) # 列印中間的資料
    print(list(reader))



"""
conn = sqlite3.connect('ddb.sqllite3')
c = conn.cursor()

c.execute('''create table MSG(ID Integer,Name Test,MSG Text)''')   #建立
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

