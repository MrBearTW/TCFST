# SPARK

## 課本規劃
課程會函蓋CH4~9<br />
DAY1上CH2~3<br />
DAY2上CH4~6<br />

## 安裝CentOS
### VM設定
```
記憶體8G
硬碟40G
共用剪貼簿：雙向
CPU雙核
掛載虛擬光碟
網卡1.NAT可以對外連線
網卡2.『僅限主機』介面卡
```
啟動<br />
## 安裝前設定CentOS
都選英文<br />
調時間<br />
Softeare sellection點進去選GNOME Desktop(完整模式)<br />
Installation Destination點進去確認硬碟容量<br />
開始安裝<br />
設定root和使用者帳號密碼<br />
reboot<br />

## 安裝完設定CentOS
LICENSE ACCEPTED<br />
開啟兩張網卡  網路卡1.    網路卡2.確定是DHCP  設定HOSTNAME(設定完按APPLY)<br />
檢查IP<br />
`ifconfig`
```
192.168.56.101(內網虛擬主機和WIN Host主機連線用)
10.0.2.15(給虛擬主機連外網)
```
可能用的到的指令  
看一下Gateway`route -n`   
強迫設一個Gateway`sudo ;route add default gw 192.168.171.1`  
  
## 跑JAVA更新  
`yum install -y java-1.8.0-openjdk-devel`

### 改設定檔案新增幾行在/.bashrc最下面
進入編輯`vi ~/.bashrc`  
```
export JAVA_HOME=/usr/lib/jvm/java-1.8.0
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:$JAVA_HOME/jre/lib:$JAVA_HOME/lib:$JAVA_HOME/lib/tools.jar
```
改完之後重新整理一次`source ~/.bashrc`    

## 安裝SPARK
`su`  
方法1  
`cd Downloads/`  
`ll`確定一下有spark-2.2.0-bin-hadoop2.7.tgz這個檔案  
移到檔案在的資料夾解壓縮過去目的地`tar zxvf spark-2.2.0-bin-hadoop2.7.tgz -O /usr/local` 
  
方法2  
移到目的地`cd /usr/local`  
從解壓縮檔案在的位置解壓縮回來`tar zxvf /home/user1/Downloads/spark-2.2.0-bin-hadoop2.7.tgz`  
  
`exit`  
進入編輯`vi ~/.bashrc`
再新增在最下面  
```
export SPARK_HOME=/usr/local/spark-2.2.0-bin-hadoop2.7
export PATH=$PATH:$SPARK_HOME/bin
```
改完之後系統重新讀參數`source ~/.bashrc`
  
SparkContext  
Spark的進入點  
2.0之後進入點可以  
  
## 進入Spark-shell
進入Scala  
`spark-shell`
進入pyspark  
`pyspark`
開啟Shell後可以看到WEB介面```localhost:4040```

## Spark-shell指令
```
:help
:pa
:sh  在spark-shell內執行Linux指令，有回傳值會變成RDD，使用rm和mkdir就好，其只指令還是退出再執行或另外開一個Termal  
:q
```

## Scala初探
https://www.slideshare.net/vitojeng/scala-introduction-58687872<br />
val可重新定義<br />
```
'''
    ：中間可插入
'''
S""：會帶入後面的參數
raw：太生了
```
### 試跑幾段Scala code
```
val textFile = sc.textFile("/usr/local/spark-2.2.0-bin-hadoop2.7/README.md")
val counts = textFile.flatMap(line => line.split(" "))
.map(word => (word, 1))
.reduceByKey(_ + _)
counts.saveAsTextFile("wordcount")
```
跑為後會在目錄下出現一個wordcount，內有兩個檔案  
可以在Shell內下指令刪掉資料夾`:sh rm -rf wordcount`  
### 用 :pa 方式載入寫好的scala檔案執行
`:pa 要執行的檔案位置和名稱`  
crtl+D結束  

# Part2 RDDs操作
Resilient Distributed Datasets (RDDs)彈性分散式數據集  
immutable(不變的) and distributed(分散式的)  
Lazy evaluation  
# Basic RDDs
## Transformations
• map  
• flatMap  
• filter  
• distinct  
• union  
## Actions
• collect  
• count  
• foreach  
• first  
• take  
• saveAsTextFile  
  
## Transformation實作
• map  
每個人都加一分  
`val input = sc.parallelize(Array(1,2,3,3,6))`  
`val newRDD = input.map(x=>x+1)`  
`newRDD foreach println`   
• flatMap  
範例1 README.md 讀近來後，每一行再依空白來分 wrod  
`sc.parallelize(Array("2#3","4#5","3#4"))`  
`input.flatMap(x=>x.split("#"))`  
`newRDD foreach println`  
  
範例2 用" "計算字數  
`val input = sc.textFile("/usr/local/spark-2.2.0-bin-hadoop2.7/README.md")`  
`val wordCounts = input.flatMap(line => line.split(" ")).map( x=>(x,1)).reduceByKey((a, b) => a + b)`  
`wordCounts.collect()`  
• filter  
找出>2的  
`val input = sc.parallelize(Array(1,2,3,3,6))`  
`val newRDD = input.filter(x=> x>2)`  
`newRDD foreach println`  
• union  
做聯集  
範例1
`val rdd1 = sc.parallelize(Array(1,2,3))`  
`val rdd2 = sc.parallelize(Array(2,4))`  
`val newRDD = rdd1.union(rdd2)`  
`newRDD foreach println`  
範例2
`val input = sc.textFile("/usr/local/spark-2.2.0-bin-hadoop2.7/README.md")`  
`val rdd1 = input.filter(line => line.contains("spark"))`  
`val rdd2 = input.filter(line => line.contains("Python"))`  
`rdd1.count()` 13  
`rdd2.count()` 12    
`newRDD.count()` 16  
• distinct  
找出不同的值
`val input = sc.parallelize(Array(1,2,3,3,6))`  
`val newRDD = input.distinct()`  
`newRDD foreach println`  
• reduce  
聚集，透過一個方法降低資料量
`val input = sc.parallelize(Array(1,2,3,4))`  
`val newRDD = input.reduce( (x,y) => x+y )`  
`newRDD`  10
  
## Action 真的有動
給一組資料`val input = sc.parallelize(Array(1,2,3,3,6))`  
• collect  
回傳所有的值  
`input.collect()`  
• count  
回傳有多少個值  
`input.count()`  
• foreach  
對所有元素執行給的function  
`input.foreach(x=> println(x))`  
• first  
回傳第一個值  
`input.first()`  
• take  
回傳前3個值
`input.take(3)`  
• saveAsTextFile  
輸出成一個檔案  
`input.saveAsTextFile("output")`  
  
# Key-Value Pair RDDs
## Transformations
• reduceByKey  
• groupByKey  
• mapValues  
• flatMapValues  
• join  
## Actions
• countByKey  
• collectAsMap  
• lookup(key)  
  
## Transformations實作
• reduceByKey  
``  
``  
``  
``  
``  
• groupByKey  
依照Key合併
`val input = sc.parallelize(Seq(("A",1),("B",2),("C",3),("C",4)))`  
`val newRDD = input.groupByKey()`  
`newRDD foreach println`  
• mapValues  
`val input = sc.parallelize(Seq(("A",1),("B",1),("C",1),("C",1)))`  
`val newRDD = input.mapValues(x => x + 1)`  
`newRDD foreach println`  
• flatMapValues  
``  
``  
``  
``  
• join  
``  
``  
``  
``  
## Actions
• countByKey  
``  
``  
``  
``  
• collectAsMap  
``  
``  
``  
``  
• lookup(key)  
``  
``  
``  
``  



# Day2 2017/10/19
### 把網路連線自動打開
兩張網卡網路設定  
connect automatically打勾  

## 準備上課資料
用WinSCP把tarining資料夾複製到/home/user  

## RDDs講解
分為  
* Transformation 
* Action
### Transformation 
lazzy  
map映射函數  
join  
### TUPLE
tuple最多到22個 
### Action
實際行動  

## 操做test-01.scala
在test01資料夾中  
看這個檔案的頭五行  
`head -n 5 t1.log head -n 5 t1.log`  
計算t1.log有幾行  
`wc -l t1.log`  
在tarining資料夾內，進到sparkshell  
執行test-01.scala  
`:pa test-01/test-01.scala`

## 匿名函數
_ 佔位符號placeholder  
結合一個case classcode更容易(PPT30.31)  
做Ex02-01b.scala  

### 換資料夾權限
`chown -R user:user training/`
user前面是username後面是usergroup  
chmod 改  

## 暫存RDD給未來使用
PPT.32  
spark2.X後會有自動cache()  
可用localhost:4040看Spark網頁  
Ex02-03加入路徑  


# Day2 下午
## 安裝 IntelliJ
確認有 init.sh三個檔案  

`bash init.sh`  
檢察有建立成功  
`ll -a ~`  

解壓縮intellij安裝Tar檔案到當下目錄  
`tar zxvf TarBalls/ideaIC-2017.2.5.tar.gz`  
補充：zcvf壓縮  

啟動安裝  
`bash idea-IC-172.4343.14/bin/idea.sh`  
下一步下一步下一步到安裝Scala的時候要install  

## IntelliJ啟動
決定project名稱  
選配合spark版本  
確認有安裝過JDK  

### 跑一個HelloWorld.scala


### 丟到spark執行
#### 改build.sbt
新增在build.sbt下面  
```
libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-core" % "2.2.0" % "provided",
"org.apache.spark" %% "spark-sql" % "2.2.0" % "provided"
)
```
#### 改整個HelloWorld.scala檔案變成
用C:\Users\tcfst\Desktop\Spark\training\test-03\src\main\scala\整個蓋過去  
改class名為HelloWorld  
```
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object HelloWorld {
  def main(args: Array[String]) {
    val logFile = "/usr/local/spark-2.2.0-bin-hadoop2.7/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }
}

```
#### 確認sparkhome有建好  
`echo $SPARK_HOME`  
  
#### 丟到spark執行
`spark-submit --class HelloWorld --master local[*] ./target/scala-2.11/helloworld_2.11-0.1.jar`  
  
## 製造jar檔方法二
用root執行以下  
`su`  
`(輸入密碼)`  
`curl https://bintray.com/sbt/rpm/rpm > bintray-sbt-rpm.repo`  
`mv bintray-sbt-rpm.repo /etc/yum.repos.d/`  
`yum install sbt`  
跳回user  
檢查一下有沒有安裝好  
`sbt -version`  
`cat build.sbt`  
把intellJ製造的那一個檔案  
`rm target/scala-2.11/helloworld_2.11-0.1.jar`  
製造jar檔案  
`sbt compile package`

## 回到part3 ppt33頁

### SPARK RDDs partition
最好是一顆CPU對應一顆DISK  
### Shared Variables
做EX02-04  
### Accumulators累加器
錯誤也會被記錄下來，可能會判讀錯誤  
做EX02-05  
### 廣播變數
做EX02-07


  
# Day3 2017/10/27

### 看一下flights.csv這個檔案
`cd training/test-02/`  
` head -n 5 flights.csv | tail -n +2`  
### 執行test-02.scala
到tanining資料夾執行  
進`spark-shell`  
`:pa test-02/test-02.scala`  
退出shell  
移動到`cd /training/test-02/output/`  
看輸出結果`cat part-00000`  
  
# SPARK SQL
## DataFrame
DataFrame是Dataset的一個子集合  
  
### 安裝Postgresql
`su`  
格式問題  
`vi init-db.sh`  
複製一份  
  
`vi init-db2.sh`  
貼上，就會改成LINUX格式  
執行`bash init-db2.sh`  
進入PostgreSQL`psql`  
退出`\q`  

## ????
  
執行`flights.select("dOfW" + 1).distinct().show()`會出現錯誤  
這樣才可以`flights.select($"dOfW" + 1).distinct().show()`  
任何一個欄位有加$的話，全部都要加$  
  
#### 字串相加conacted
`flights.select( concat($"carrier",$"tailNum").alias("UniCarrier")).distinct().show()`  
  
要加一個-在中間的話要用 lit("-")  
`flights.select( concat($"carrier", lit("-"), $"tailNum").alias("UniCarrier") ).distinct().show()`  

#### 做過濾
不等於有兩個 ==  
等於有三個 ===  
`flights.filter($"dOfW" < 2).distinct().show()`  
`flights.filter($"dOfW" > 2).distinct().show()`  
`flights.filter($"dOfW" !== 2).distinct().show()`  
`flights.filter($"dOfW" === 2).distinct().show()`  

### group
`flights.groupBy("dOfM" , "dOfW").count().show()`  
  
### agg  aggregations
可以一次算很多個平均數，不用分開算再join在一起  
`flights.groupBy("dOfM").agg(avg($"DepDelayMins").alias("DepDelay"),avg("CRSElapsedTime").alias("CrsDelay")).show()`  
  
## 做SQL-02
  
## User defined functions (UDF)
  
## 改成DataFram 寫法
將 test-02 改成 DateFrame => test-04  
  
## 直接寫SQL 語法
將 test-04 改成 SQL => test-05  
  
## PPART4 PT36
DataFram像是一個Table  
Datasets會強制給型態轉型
強型態：執行之前必須指定型態

## 安裝JDBC
先確定Postgresql有安裝好  
留一個Spark-Shell就好  
進入shell with JDBC`spark-shell --driver-class-path db/postgresql-42.1.1.jar`  
  
因為退出過shell
`:pa Example/SQL-04.scala`  
`:pa Example/SQL-08a.scala`  
`:pa Example/SQL-07.scala`  
------------------------------------------
`cd /var/lib/pgsql/10/data`
`vi pg_hba.conf`

正確版的應該長這樣`vi /home/user/training/db/pg_hba.conf`

`cp /home/user/training/db/pg_hba.conf .`
------------------------------------------

## 增加資料
用mode  
.mode(“append”)  
  

## Overwrite
小心使用  
資料砍掉，整個drop  
大公司應該是不可能下這個指令








## MLLib

用IntelliJ開啟OPEN  
找到那一個檔案  
在IntelliJ的sbt-shell內`package`製作jar檔案  
  
在Termal執行做出來的jar檔案`bash t1.sh 1`  
  
### 減少SPARK回復的資訊
先看一下saprk權限`ll /usr/local`  
切換成root`su`  
改變權限`chown -R user:user spark-2.2.0-bin-hadoop2.7`  
確認spark-2.2.0-bin-hadoop2.7的權限變成user:user  
### 修改log4j.properties檔案  
變到資料夾`cd /usr/local/spark-2.2.0-bin-hadoop2.7/conf/`  
複製一份`cp log4j.properties.template log4j.properties` 
修改`vi log4j.properties`  
把`log4j.properties`內沒有被註解的一行```INFO```改成```ERROR```  
之後出現的資訊就會減少。  

<br />
<br />
