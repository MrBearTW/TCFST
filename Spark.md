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
### 改設定檔案新增幾行在/.bashrc最下面
進入編輯<br />
>vi ~/.bashrc
```
export JAVA_HOME=/usr/lib/jvm/java-1.8.0
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:$JAVA_HOME/jre/lib:$JAVA_HOME/lib:$JAVA_HOME/lib/tools.jar
```

跑JAVA更新<br />
>yum install -y java-1.8.0-openjdk-devel

SparkContext<br />
Spark的進入點<br />
2.0之後進入點可以<br />

## 進入Spark-shell
進入Scala  
`spark-shell`
進入pyspark  
`pyspark`

## Spark-shell指令
```
:help
:pa
:sh  在spark-shell內執行Linux指令，有回傳值會變成RDD，使用rm和mkdir就好，其他還是退出或另外開一個Termal  
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

# Part2 RDDs操作
RDDs<br />







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
### Accumulators
做EX02-05  
### 廣播變數
<br />
<br />
<br />
<br />