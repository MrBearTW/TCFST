mLab 可以有500mb的免費MongoDB  


|RDBMS|MongoDB|
|:---:|--|
|Table|Collection|
|Record/Row|Document|
|Cloum|Field|
|Primary Key|_id|

ObjectID大致會以時間排序  
  
Collection沒有Foreign Key所以不能做Join  

MongoDB每個Document不能大過16MB   
  
## JSON格式
舊版
```
[
{"_id":XXX,"city:AAA"}
{"_id":XXX,"city:AAA"}...
]
```
  
新版
```
{[
{"_id":XXX,"city:AAA"}
{"_id":XXX,"city:AAA"}...
]}
```