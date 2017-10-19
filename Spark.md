# SPARK

## 課本規劃
課程會函蓋CH4~9<br />
DAY1上CH2~3<br />
DAY2上4~6<br />

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
10.0.2.15(給需擬主機連外網)
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


<br />
<br />
<br />
<br />