# HBase 筆記

## NoSQL類型
|類型|實例|
|:---:|--|
|文件儲存|mongoDB|
|圖型儲存(路徑式)|FlockDB|
|KeyValue儲存|HBase Cassandra|
  
## CAP
資料庫的特性選擇<br />
三選二<br />
分散式依定要選3，1和2互斥，只能選一種<br />
1.Consistency(一致性)<br />
2.Availability(可用性)<br />
3.Partition Tolerance(分散式)<br />
  
|一致性|可用性|分散式|類別|實例|
|:---:|--|--|--|--|
|V|V||RDBMS|傳統式資料庫|
|V||V|NoSQL|HBase|
||V|V|NoSQL|Cassandra|

## 操作Hbase方法
* Shell Script(課本279頁)
* Java api
* HareDB(亦思科技)
  
## 裝好VM後
進入HBase<br />
`hbase shell`
  
## 建立命名空間
`create_namespace 'debugo_ns'`<br />
  
查看命名空間<br />
`list_namespace`<br />
  
修改命名空間<br />
``  
刪除命名空間  
``<br />
  

## 建立Table
建立Table: debugo_ns:users  
`create 'user','info'` 建立  
  
插入一筆資料  
`put 'user', 'user1','info:phone', '0912345678'`  
  
新增ColumnFamily(=school)進去(Table=user)  
`alter 'user','school'`  
  
查ColumnFamily  
`describe 'user'`  
  
改Table 保留VERSION數量  
`alter 'user',NAME =>'info',VERSIONS =>6`  
  
查Table  
`describe 'user'`  
  
## 修改Table內容
新增資料進Table=user，Key-value=user1<br />
`put 'user', 'user1','info', 'info1'`<br />
delete<br />
`delete 'user','user1','info:phone_phone1'`<br />
deleteall<br />
`還沒研究`<br />
disable Table<br />
`disable 'user'`<br />
enable Table<br />
`enable 'user'`<br />

## 查詢資料
查Key-value=user1的info<br />
`get 'user','user1','info'`<br />
查Key-value=user1的info<br />
`get 'user','user1','info:phone'`<br />
篩選資料<br />
`scan 'user',FILTER=>"ValueFilter(=,'substring:09')"`<br />
查出每一個版本的資料<br />
`scan 'user',{RAW=>true,VERSIONS=>6}`<br />
get只會查出最新那一個<br />


<br />
<br />
<br />
<br />
<br />
# DAY2
## 開eclipse
建一個javaproject  
跑一個helloworld看看可不可以執行  
把10/26資料夾內複製到新建好的eclipse內  
refresh確認lib和resource看得到資源  
  
用手刻JAVA創建Table  
用手刻加入一行資料  
  
操作HBaseOperator.java  
  
Buclkload tool  上傳大量資料
Coprocessor 客製化
# Day3


## 下午
## 安裝HARE_DB
桌面1102資料夾內解壓縮HareDBClient-1.98.06.03-CDH5.7.zip  
進資料夾，右鍵修改starup.sh屬性成為，打勾可以當作執行檔
點兩下，run on termal  

Host改成quickstart.cloudera
其他照抄講義


Check HDFS Permissions
dfs.permissions
HDFS (Service-Wide)

第一個和最後一個port改成8020

#### 助教除錯
助教改權限`HADOOP_USER_NAME=hdfs hdfs dfs -chmod 777 /`  

就可以有建新增Table  


右鍵coprocessors註冊建立，Table上面的X就會拿掉

### HQL不能用的排除
進Cloudera Manager  
選HDFS  
選Configuration  
搜詢```Permissions```  
找到```Check HDFS Permissions HDFS (Service-Wide)```後面的勾勾拿掉  
重啟Cloudera Manager相關服務  
HQL理論上就不會出現Exception，Query就可以動了。  
  
## Bulkload

## JAVA
  
# 2017/11/09
|RawKey|ID|CF1||CF2|||
|:---:|--|--|--|--|--|--|
|||CF1-Q1|CF1-Q2|CF2-Q1|CF2-Q2|CF2-Q3|
|100000|5566|KH|TW|2000/1/19|29|IT|
|100001|9487|NY|US|2017/11/9||FI|
|100002|1111||UK|1999/9/28|18|UE|

# 經驗談
1EB=1024PB  
1PB=1044TB  
一個Region Server會有很多個Region  
一個CF會對應到一個Region  
通常：會控制一個Region Server在100個Region以下  
通常：一個Key-Value最大不超過10MB  
{(rowkey,cf-qulifer,timestamp),Value}

## KeyDesign
Slating  
Hashing  
Reverse key  
Montonically Increasing單調遞增  

##
|Keys|Sequential|Salted||Promoted Field|Random|
|:---:|--|--|--|--|--|
||*|||||
|||*||||
|||||||
|||||*||
||||||*|
|||||||

