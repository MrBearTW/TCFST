import sqlite3
conn = sqlite3.connect('ddb.sqllite3')
c = conn.cursor()

#c.execute('''create table MSG(ID Integer,Name Test,MSG Text)''')   #建立
#c.execute('''insert into MSG values(1,'APPLE','OH YA')''')         #新增資料
#c.execute('''insert into MSG values(2,'AKEN','YOLO')''')
c.execute('''select * from MSG where name = 'APPLE' ''')            #查詢
conn.commit()
print('ZZZZZZZZZZ',c.fetchall())

#c.execute('''delete from MSG where name = 'APPLE' ''')              #刪除
#conn.commit()
#print('AAAAAAAAAA',c.fetchall())

#c.execute('''select * from MSG ''')
#conn.commit()
#print('BBBBBBBBBB',c.fetchall())

print(c.fetchall())

conn.close()