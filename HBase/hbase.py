import sqlite3
import csv

with open('匯率.csv',encoding='Big5') as f:

	reader=csv.DictReader(f,fieldnames=["id","cash","time","30","60","90","180","360"])

	with open('匯率.txt','w') as f2:
	
		for row in list(reader)[1:20]:
			f2.write('put \"hw\",'+'\"'+row["id"]+'\",\"time\",'+'\"'+row["time"]+'\"'+'\n')
			f2.write('put \"hw\",'+'\"'+row["id"]+'\",\"30\",'+'\"'+row["30"]+'\"'+'\n')
			f2.write('put \"hw\",'+'\"'+row["id"]+'\",\"90\",'+'\"'+row["60"]+'\"'+'\n')
			f2.write('put \"hw\",'+'\"'+row["id"]+'\",\"90\",'+'\"'+row["90"]+'\"'+'\n')
			f2.write('put \"hw\",'+'\"'+row["id"]+'\",\"180\",'+'\"'+row["180"]+'\"'+'\n')
			f2.write('put \"hw\",'+'\"'+row["id"]+'\",\"360\",'+'\"'+row["360"]+'\"'+'\n')
			f2.write('put \"hw\",'+'\"'+row["id"]+'\",\"cash\",'+'\"'+row["cash"]+'\"'+'\n')


