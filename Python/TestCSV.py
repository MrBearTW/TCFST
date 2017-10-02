import csv
with open('FMTQIK.csv',encoding='Big5')as f:
    for row in csv.reader(f):
        print(row)