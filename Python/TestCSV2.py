import csv
with open ('FMTQIK.csv',encoding='Big5') as f:
    reader = csv.DictReader(f, fieldnames=["日期","成交股數","成交金額","成交筆數","發行量加權股價指數","漲跌點數"])
    print("日期",'\t\t',"成交股數",'\t',"成交金額")
    for row in list(reader)[2:-3]:
        print(row["日期"],'\t',row["成交股數"],'\t',row["成交金額"])