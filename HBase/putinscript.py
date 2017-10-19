import csv
with open ('ExchangeRate201707141441.csv') as f:
    reader = csv.DictReader(f, fieldnames=["id","cash","real-time","30day","60day","90day","180day","360day"])  #讀檔案
    #print("id",'\t\t',"cash",'\t',"real-time")    # 列印表頭+表頭排版
    for row in list(reader)[1:]:
        print(row["id"]) # 列印中間的資料