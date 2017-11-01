# Hadoop note

## YARN有四種模式
Batch  
Interactive  
Online  
Streaming  
  
## 用CentOS建立master node
Master node建議8G  
Worker node建議4G  
建立虛擬硬碟>>VMDK格式>>動態配置>>建議48GB>>GPU兩核>>網路一張網卡(『僅限主機』介面卡)  
掛載虛擬光碟(CentOS iso檔案)  
  
啟動虛擬主機>>English>>美式鍵盤>>Basic Storage Devices>>Yes,discard any data
Hostname:master1  
Taipei Time (所有Cluster主機要一致)  
設定ROOT密碼：123456  

### 設定Creat Custom Layout
1.Mount point:/boot    ext4    200MB    fixed size  
2.選swap後就會反灰    swap    200MB    fixed size  
3.Mount point:/    ext4    Fill to maximum allowable size  
  
format>>選Desktop模式  
  
License check  
建立使用者帳號密碼  
選NTP Server  
Kdump選預設  
  
登入  
  
### 設定網路
改IPv4  
```
Address:192.168.56.101  
Netmask:24  
Gateway:192.168.56.1(對應到援主機的虛擬網路卡IP位置)  
```
### 切換成root身份
`su root`
  
### 關防火牆
`setup`  
  
第二個Firewall configuration  用空白鍵調整成關閉  
  
### 改swappiness參數
改swappiness=1(預設=60)  
`sysctl -w vm.swappiness=1`
  
查看確認有改成功  
`cat /proc/sys/vm/swappiness`  
`cat /etc/sysctl.conf`  
改成重新開機就會是=1  
  
 # VIM編輯器指整理  
```
K上J下L左H右  
O寫入新的一行  
I進入編輯模式  
dd刪除一整行  
ESC後  
:wq 存檔離開  
:q! 不存檔離開  
```
其實把vim都改用nano，世界可能更美好。  
  
### 修改defrag為never
修改/sys/kernel/mm/redhat_transparent_hugepage/defrag 開機時會讀到的記憶體管理參數(官方建議關閉)  
寫入開機的設定檔中  
`echo "never > /sys/kernal/mm/redhat_transparent_hugepage/defrag">> /etc/rc.local`
檢查`cat /sys/kernel/mm/redhat_transparent_hugepage/defrag`
會看到```always madvise [never]```

'''
>  覆蓋
>> append  
'''
  
### 修改selinux為disable
一種安全性設定，沒有disable的話，修改設定不會儲存
改使用root權限`su`  
修改`vim /etc/selinux/config`  
檢查確認一下`cat /etc/selinux/config`  
  
# Day2 2017/10/19
主機加入第二張網卡，選NAT(不是NAT_網路)
就是會看到可以連外網的10.0.3.X  
  
啟動虛擬主機  
調整網路卡，確定兩張網路卡都將Connect automatically打勾  
  
### 調整主機網路設定
#### 刪除eth0 Gateway 和 mask 
先換成root`su -`  
    
改連線設定檔，把Gateway刪掉  
`vi /etc/sysconfig/network-scripts/ifcfg-eth0`    
選到Gateway那一行,dd把那一行刪掉  
選到HWADDR(改MAC，之後複製製作成(slave node時才不會衝突)  
dd把那一行刪掉`:wq`存檔離開  
  
### 重新啟動網卡  
`service network restart`(要root才能用)  
或  
`ifdown eth0`  
`ifup eth0`  
重新啟動網路服務

## 匯出再匯入製造出三台slave主機
### 匯出應用裝置
匯出成OVA格式，記一下匯出的位置    
### 匯入應用裝置
1.選到那一個OVA檔案(上面匯出的位置)  
2.改名字  
3.改記憶體4096(slave)  
4.打勾->重新初始化所有網路卡的MAC位置  
5.選虛擬機放的位置(就是預設)  
  
### 設定伺服器開啟(只有master要做)
`chkconfig httpd on`  
`chkconfig |grep httpd`  
`service httpd start`  
理論上host主機(WIN7)  
master1主機(centOS)  
都可連到192.168.56.101看看有沒有連到Apache頁面  

### 修改slave的網路設定
將eth0改成192.168.56.102/3/4  
`su`  #改用root權限，輸入密碼  
`cd /etc/udev/rules.d`  
`rm 70-persistent-net.rules`  #網路設定檔  
`y`  

### 改主機名稱
分別為master1,slave1/2/3  
> vi /etc/sysconfig/network  

### 改設定檔讓欉及電腦都認識彼此
先改master1的，再複製到其他三台slave
`vi /etc/hosts`  
最後面加上  
```
192.168.56.101 master1
192.168.56.102 slave1
192.168.56.103 slave2
192.168.56.104 slave3
```
  
### 複製編輯好的hosts檔案到其他台
`scp /etc/hosts root@192.168.56.102:/etc/hosts`  
要slave密碼
第一次連線會有確認

### 重新啟動全部電腦
ping名稱看個主機間網路通不通
`ping master1`  
`ping slave1`  
`ping slave2`  
`ping slave3`  
互相都要通，總共ping 4*3=12次  
  
## 設定SSH免帳號密碼
老師跳過PPT62~67  
  
### 複製cdh571,cm571進入master1主機
使用WINSCP，用root帳號連線到master主機
把兩個資料夾cdh571,cm571複製到master內的/var/www/html  
不改資料夾名字不改資料夾名字不改資料夾名字  
`cd /var/www/html/`  
  
### 先安裝createrepo
`yum install createrepo`  

## 在cm571資料夾 建立一個repodata  
`createrepo .`  
cm571資料夾出現repodata  
在這個資料夾建立安裝檔的index  
  
## 安裝Cloudera Manager Server
`cd /etc/yum.repos.d/`  
`ls`檢查資料夾內有CentOS-Media.repo檔案  
    
### 創造和修改cloudera.repo
在資料夾內複製一個檔案(CentOS-Media.repo)改名叫做(cloudera.repo)  
`cp CentOS-Media.repo cloudera.repo`  
修改cloudera.repo  
`vim cloudera.repo`    
下方改成  
```
[cloudera-media]
name=cloudera-$releasever - Mediai
baseurl=http://master1/cm571
gpgcheck=1
enabled=1
gpgkey=http://master1/cm571/RPM-GPG-KEY-cloudera
```
### 檢查 cloudera-6 - Media 的狀態是  7
`yum repolist`  
yum全名是Yellowdog Updater Modified，一種網路安裝與升級服務  
  
## 安裝cloudera-manager-server-db-2
`yum install cloudera-manager-server-db-2`  
  
### 啟動兩個服務
`service cloudera-scm-server-db start`  
`service cloudera-scm-server start`  
要看到是OK    

#### 老師跳過
PPT68頁跳過(直接在html資料夾內處理了)
PPT75改名跳過，直接延用cm571,cdh571
PPT80頁安裝mysql跳過
  
### 確認7180port有啟動，狀態是Listen
`lsof -i:7180`    
本機(master1)瀏覽器開啟可以看到登入畫面  
```http://192.168.56.101:7180/```
Cloudera預設帳密 admin/admin  
補充：查看port指令`vi /etc/services`  
  
## 首次登入後設定(可用Win主機)
登入後 
選擇安裝免費的Cloudera Manager版本  
搜尋  
`192.168.56.10[1-4]`  
SEARCH按下去，理想上會搜尋到四台主機  
### Cluster Installation
選Use Parcels(Recommended)後面的 More Option 進入  
把下面原本有的按減號刪掉  
留下一格刪除原本，改成  
```
http://192.168.56.101/cdh571
```
回到上一層  
#### 第一段Select the version of CDH  
選項CDH-5.7.1cdh5.7.1.p0.11  
要勾起來  
  
#### 第二大段
選Custom Repository 加入  
```
http://192.168.56.101/cm571/
```
#### 第三大段
Custom GPG Key URL: 加入
```
http://192.168.56.101/cm571/RPM-GPG-KEY-cloudera
```
### 是否安裝JDK
是  
第二個勾不勾都可  
### SSH設定
打入密碼即可
### 沒有卡住的話
下一步下一步下一步  
有的話...就比較麻煩...
  
### 選擇要安裝的Service
選Custom Services
可以一次挑戰七個  
```
HBase
HDFS    
HIVE  
HUE
IMPALA(好像沒有選這個,但後面有要用到...)
Spark
YARN(取代MapReduce)
Zookepper
```
Zookepper勾三台主機(要奇數台)(slave3不勾)  
補充：基礎HDFS和YAARN和Zookepper一定要先裝。盡量先IMPALA再HUE。  
Add Service時都會提醒要先安裝什麼  
安裝順序參考HIVE>>Impala>>Oozie>>HUE  
    
### 選擇要安裝的RDB
選Use Embedded Database  
右下Test Connection  
都OK就可以下一步
  
# 理論上可以看到Congratulations

## 下一步下一步下一步悲劇的話
例如說曾經安裝到一半中斷關機後再重來的話  
### 四台主機cloudera-scm-agent停掉
先操作master  
`service cloudera-scm-agent stop`
把另外三台slave的服務也關掉  
`ssh root@192.168.56.102`103,104

此時cloudera-manager service應該還活著  
進網頁把每一個node刪掉(把clusterg刪掉？)
重跑一次  
  
### 助教除錯大致流程
還是失敗的話要慢慢找原因  
可能是之前的資料沒有清乾淨  
master主機用root帳號
`cd /dfs/nn`  
`ll`  
有current的話，刪掉`rm -rf current/`  
換到slave1`ssh root@slave1`  
`cd /var/run/cloudera-scm-agent/process/117-hdfs-DATANODE/`
`chown hdfs:hdfs supervisor.conf`可能還有vim進去改  
回到master1主機`cd /var/log/hadoop-hdfs/`  
再回到slave1`ssh root@slave1`  
`cd /var/log/hadoop-hdfs/`  
`vim hadoop-cmf-hdfs-DATANODE-slave1.log.out`  
`cd /dfs/dn/`  
`rm -rf current/`  
`ssh root@slave2`  
`cd /dfs/dn`  
`rm -rf current/`  
`ssh root@slave3`  
`cd /dfs/dn`  
`rm -rf current/`  
`exit`三次回到master1  
`cd /dfs/snn`
`rm -rf current/`  
  
  
# 直接用QUICK START主機來操作
cloudera manager功能介紹 
## 桌面Launch Cloudera Express
啟動，記憶體要大於8G  
或用指令啟動cloudera-manager  
`sudo /home/cloudera/cloudera-manager --force  --express`  
  
## 看跑範例程式後YARN上面的資料 
QUICK START跑`hadoop jar /usr/lib/hadoop-0.20-mapreduce/hadoop-examples.jar pi 10 100`  
自己裝的Cluster的沒有裝Mapreduce應該是沒有這個範例檔可以執行...  
YARN Applications可以看  
Resource Manager可以看
## 跑SPARK範例程  
`HADOOP_USER_NAME=hdfs spark-submit --class org.apache.spark.examples.SparkPi --master yarn --deploy-mode cluster --num-executors 3 --driver-memory 512m --executor-memory 512m /usr/lib/spark/examples/lib/spark-examples-1.6.0-cdh5.7.0-hadoop2.6.0-cdh5.7.0.jar 100`  
可以看SPARK和YARN等相關的資訊  
  
## hue  
有WEB UI可以進入  
可以上傳檔案到HDFS  
可以管理HBase和Hive，操作query  
操作Impala，可以下載範例檔案操作  
## HDFS
有WEB UI可以進入  
一個block是128MB  
### HDFS底下的CM Resource
Configuration  
可以調整給較常用的服務較高的配置  
從Static Service Pools進入  
Configuration內可以設定比例  
restart  
  
# 用指令操作Hadoop
## hadoop指令
看HDFS下有哪一些檔案  
`hadoop fs -ls /`

### 增加使用者
`sudo su`使用Roo帳號  
看目前有哪一些使用者`hadoop fs -ls /user`  
下這一行指令HADOOP_USER_NAME=hdfs就可以變成有權限使用者  
建立test目錄`HADOOP_USER_NAME=hdfs hadoop fs -mkdir /user/test`  
修改目錄權限給帳號test`HADOOP_USER_NAME=hdfs hadoop fs -chown test:supergroup /user/test`  
### 從Linux放檔案到HDFS上  
`su - test`換到test使用者  
製造檔案`echo " hello world">hello.txt`  
放到HTFS`hadoop fs -put hello.txt /user/test/hello.txt`  
檢查檔案是否存在`hadoop fs -ls hello.txt /user/test/hello.txt`  
看檔案內容`hadoop fs -cat hello.txt /user/test/hello.txt`  

# DAY4 2017/11/1
資料量大用HIVE  
資料量小可以用IMPALA  
# Hadoop管理

## 新增一個node
/etc/hosts設定、time zones、Java版本...等  
可以選擇已有的範本或是新建一個範本  
增加datanode與namenode  
## 刪除一個node
需先將Hosts裡的Role Group移除，使用decommission  
### 使用Decommission注意事項???????????????????????????????????
調整node數量?????????????????????????????????????????????????

進要停掉的主機root權限`su`  
確認一下cloudera狀態`service cloudera-scm-agent status`  
`service cloudera-scm-agent stop`  

Host若無法與Cloudera Manager溝通則不能使用  
需個別停止host內的services  
Host需先Recommission才能啟動role instance  
### Role Groups移除後，移除Host分兩種方式
1.Delete  
2.Remove From Cluster  
#### Delete
刪除後在叢集內看不到Host  



## 透過impala操作SQL指令  
https://www.cloudera.com/documentation/enterprise/5-8-x/topics/impala_create_table.html  
## 升級Cloudera Manager
進入Parcels
1.Host下拉選單  
2.右上方 禮物圖案進入  
configuation進入Parcel Settings  
若是企業封閉網路，路徑會是內網新版檔案放置的主機路徑  
### 事前確認事項
Cluster沒有Job在running  
Cluster沒有Error  
進入維護模式(讓警告訊息在升級時不出現)  
### 5.0升級5.2
停止Cluster  
備份namenode資料  
下載CDH5.2.0，不要Restart  
進入HDFS頁面，升級HDFS Metadata  
進入Hive頁面，升級Hive的Metastore  
進入Ooize頁面，啟動Ooize並安裝ShareLib  
進入Sqoop2頁面，升級Sqoop  
#### 部署客戶端設定檔  
讓client user可以使用Services  
  
在HDFS Service下的namenode role  
Finalize Metadata，移除前一版本的metadata  


--------------------------------------------------------------
助教除錯紀錄一下  
login as: user1
user1@192.168.56.101's password:
Access denied
user1@192.168.56.101's password:
Access denied
user1@192.168.56.101's password:
Access denied
user1@192.168.56.101's password:
Last login: Wed Oct 18 14:14:50 2017 from 192.168.56.1
[user1@master1 ~]$ lsof -i:7180
[user1@master1 ~]$ su
Password:
[root@master1 user1]# lsof -i:7180
COMMAND  PID         USER   FD   TYPE DEVICE SIZE/OFF NODE NAME
java    1868 cloudera-scm  236r  IPv4  33374      0t0  TCP master1:7180.56.1:50041 (ESTABLISHED)
java    1868 cloudera-scm  243u  IPv4  33375      0t0  TCP master1:7180.56.1:50042 (ESTABLISHED)
java    1868 cloudera-scm  252u  IPv4  28775      0t0  TCP *:7180 (LIST
java    1868 cloudera-scm  258u  IPv4  33376      0t0  TCP master1:7180.56.1:50043 (ESTABLISHED)
java    1868 cloudera-scm  259u  IPv4  33377      0t0  TCP master1:7180.56.1:50044 (ESTABLISHED)
java    1868 cloudera-scm  260u  IPv4  33378      0t0  TCP master1:7180.56.1:50045 (ESTABLISHED)
java    1868 cloudera-scm  261u  IPv4  33379      0t0  TCP master1:7180.56.1:50046 (ESTABLISHED)
[root@master1 user1]# yum install createrepo
Loaded plugins: fastestmirror, refresh-packagekit, security
Loading mirror speeds from cached hostfile
 * base: ftp.ksu.edu.tw
 * extras: ftp.ksu.edu.tw
 * updates: ftp.ksu.edu.tw
Setting up Install Process
Package createrepo-0.9.9-27.el6_9.noarch already installed and latest version
Nothing to do
[root@master1 user1]# cd /etc/i
idmapd.conf  init/        inittab      ipa/         issue
impala/      init.d/      inputrc      iproute2/    issue.net
[root@master1 user1]# cd /etc/init.d
[root@master1 init.d]# ll
total 392
-rwxr-xr-x. 1 root root  1288 Nov 23  2013 abrt-ccpp
-rwxr-xr-x. 1 root root  1628 Nov 23  2013 abrtd
-rwxr-xr-x. 1 root root  1642 Nov 23  2013 abrt-oops
-rwxr-xr-x. 1 root root  1725 Aug 19  2010 acpid
-rwxr-xr-x. 1 root root  2062 Jan 30  2012 atd
-rwxr-xr-x. 1 root root  3378 Jun 22  2012 auditd
-rwxr-xr-x. 1 root root  4043 Nov 23  2013 autofs
-r-xr-xr-x. 1 root root  1340 Nov 24  2013 blk-availability
-rwxr-xr-x. 1 root root   710 Nov 11  2010 bluetooth
-rwxr-xr-x. 1 root root  2094 Feb 22  2013 certmonger
-rwxr-xr-x  1 root root  8471 May 13  2016 cloudera-scm-agent
-rwxr-xr-x  1 root root  8319 May 13  2016 cloudera-scm-server
-rwxr-xr-x  1 root root  4444 May 13  2016 cloudera-scm-server-db
-rwxr-xr-x. 1 root root 11355 Aug 13  2013 cpuspeed
-rwxr-xr-x. 1 root root  2826 Nov 23  2013 crond
-rwxr-xr-x. 1 root root  3034 Aug 17  2013 cups
-rwxr-xr-x. 1 root root  1702 Feb 22  2013 dnsmasq
-rwxr-xr-x. 1 root root  3245 Jul  9  2013 firstboot
-rw-r--r--. 1 root root 18586 Oct 10  2013 functions
-rwxr-xr-x. 1 root root  1801 Jul 20  2011 haldaemon
-rwxr-xr-x. 1 root root  5866 Oct 10  2013 halt
-rwxr-xr-x  1 root root  2001 Aug 16 03:45 htcacheclean
-rwxr-xr-x  1 root root  3488 Aug 16 03:45 httpd
-rwxr-xr-x. 1 root root 10804 Nov 23  2013 ip6tables
-rwxr-xr-x. 1 root root 10688 Nov 23  2013 iptables
-rwxr-xr-x. 1 root root  1938 Aug 23  2013 irqbalance
-rwxr-xr-x  1 root root  9972 Jan 21  2012 jexec
-rwxr-xr-x. 1 root root 18133 Nov 23  2013 kdump
-rwxr-xr-x. 1 root root   652 Oct 10  2013 killall
-r-xr-xr-x. 1 root root  2134 Nov 24  2013 lvm2-lvmetad
-r-xr-xr-x. 1 root root  2665 Nov 24  2013 lvm2-monitor
-rwxr-xr-x. 1 root root  2571 Oct 11  2013 mdmonitor
-rwxr-xr-x. 1 root root  2200 Sep 14  2012 messagebus
-rwxr-xr-x. 1 root root  2989 Oct 10  2013 netconsole
-rwxr-xr-x. 1 root root  5428 Oct 10  2013 netfs
-rwxr-xr-x. 1 root root  6334 Oct 10  2013 network
-rwxr-xr-x. 1 root root  2205 Nov 23  2013 NetworkManager
-rwxr-xr-x. 1 root root  6364 Nov 22  2013 nfs
-rwxr-xr-x. 1 root root  3526 Nov 22  2013 nfslock
-rwxr-xr-x. 1 root root  1923 Jul 15  2013 ntpd
-rwxr-xr-x. 1 root root  2043 Jul 15  2013 ntpdate
-rwxr-xr-x. 1 root root  2261 Jun 25  2011 oddjobd
-rwxr-xr-x. 1 root root  2023 Apr  3  2012 portreserve
-rwxr-xr-x. 1 root root  3852 Dec  3  2011 postfix
-rwxr-xr-x  1 root root  5600 Oct  6 04:32 postgresql
-rwxr-xr-x. 1 root root  1556 Jul 17  2012 psacct
-rwxr-xr-x. 1 root root  2034 Jun 13  2013 quota_nld
-rwxr-xr-x. 1 root root  1513 Sep 17  2013 rdisc
-rwxr-xr-x. 1 root root  1822 Nov 23  2013 restorecond
-rwxr-xr-x. 1 root root  1808 Dec 18  2011 rngd
-rwxr-xr-x. 1 root root  2073 Feb 22  2013 rpcbind
-rwxr-xr-x. 1 root root  2518 Nov 22  2013 rpcgssd
-rwxr-xr-x. 1 root root  2305 Nov 22  2013 rpcidmapd
-rwxr-xr-x. 1 root root  2464 Nov 22  2013 rpcsvcgssd
-rwxr-xr-x. 1 root root  2011 Aug 15  2013 rsyslog
-rwxr-xr-x. 1 root root  1698 Nov 23  2013 sandbox
-rwxr-xr-x. 1 root root  2056 Nov 20  2012 saslauthd
-rwxr-xr-x. 1 root root   647 Oct 10  2013 single
-rwxr-xr-x. 1 root root  3002 Feb 22  2013 smartd
-rwxr-xr-x. 1 root root  2162 Nov 22  2013 snmpd
-rwxr-xr-x. 1 root root  1738 Nov 22  2013 snmptrapd
-rwxr-xr-x. 1 root root  2472 Nov 23  2013 spice-vdagentd
-rwxr-xr-x. 1 root root  4534 Nov 23  2013 sshd
-rwxr-xr-x. 1 root root  2712 Nov 23  2013 sssd
-rwxr-xr-x. 1 root root  1144 Nov 23  2013 sysstat
-rwxr-xr-x. 1 root root  2294 Nov 23  2013 udev-post
-rwxr-xr-x. 1 root root  1674 Feb 22  2013 wdaemon
-rwxr-xr-x. 1 root root  1608 Nov 23  2013 winbind
-rwxr-xr-x. 1 root root  1866 Feb  4  2013 wpa_supplicant
-rwxr-xr-x. 1 root root  4799 Feb 22  2013 ypbind
[root@master1 init.d]# ls
abrt-ccpp               functions     NetworkManager  rsyslog
abrtd                   haldaemon     nfs             sandbox
abrt-oops               halt          nfslock         saslauthd
acpid                   htcacheclean  ntpd            single
atd                     httpd         ntpdate         smartd
auditd                  ip6tables     oddjobd         snmpd
autofs                  iptables      portreserve     snmptrapd
blk-availability        irqbalance    postfix         spice-vdagentd
bluetooth               jexec         postgresql      sshd
certmonger              kdump         psacct          sssd
cloudera-scm-agent      killall       quota_nld       sysstat
cloudera-scm-server     lvm2-lvmetad  rdisc           udev-post
cloudera-scm-server-db  lvm2-monitor  restorecond     wdaemon
cpuspeed                mdmonitor     rngd            winbind
crond                   messagebus    rpcbind         wpa_supplicant
cups                    netconsole    rpcgssd         ypbind
dnsmasq                 netfs         rpcidmapd
firstboot               network       rpcsvcgssd
[root@master1 init.d]# service cloudera-scm-agent stop
Stopping cloudera-scm-agent:                               [  OK  ]
[root@master1 init.d]# service cloudera-scm-agent stop
cloudera-scm-agent is already stopped
[root@master1 init.d]# cd /dfs/
nn/  snn/
[root@master1 init.d]# cd /dfs/nn
[root@master1 nn]# ll
total 4
drwxr-xr-x 2 hdfs hdfs 4096 Oct 25 10:59 current
[root@master1 nn]# rm -rf current/
[root@master1 nn]# ll
total 0
[root@master1 nn]# rm -rf current/
[root@master1 nn]# ssh root@slave1
The authenticity of host 'slave1 (192.168.56.102)' can't be established.
RSA key fingerprint is f3:9c:1a:11:d6:6f:d1:af:25:e5:71:0e:9e:03:52:d3.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added 'slave1' (RSA) to the list of known hosts.
root@slave1's password:
Last login: Wed Oct 25 13:13:39 2017 from master1
[root@slave1 ~]# cd /var/run/cloudera-scm-agent/
[root@slave1 cloudera-scm-agent]# ll
total 16
drwxr-x--x  6 root         root         4096 Oct 18 16:34 cgroups
-rw-r--r--  1 root         root            5 Oct 25 13:20 cloudera-scm-agent.pid
prw-------  1 root         root            0 Oct 25 13:59 events
drwxr-x--x  2 cloudera-scm cloudera-scm 4096 Oct 25 09:02 flood
drwxr-x--x 29 root         root          580 Oct 25 13:58 process
drwxr-x--x  3 root         root         4096 Oct 25 13:20 supervisor
[root@slave1 cloudera-scm-agent]# cd process/
[root@slave1 process]# ll
total 0
drwxr-x--x 3 hdfs      hdfs      380 Oct 25 13:54 100-hdfs-DATANODE
drwxr-x--x 3 yarn      hadoop    460 Oct 25 13:57 106-yarn-NODEMANAGER
drwxr-x--x 3 hdfs      hdfs      380 Oct 25 13:57 113-hdfs-DATANODE
drwxr-x--x 3 hdfs      hdfs      360 Oct 25 13:59 117-hdfs-DATANODE
drwxr-x--x 3 hdfs      hdfs      380 Oct 25 12:02 16-hdfs-DATANODE
drwxr-x--x 3 hbase     hbase     380 Oct 25 12:01 23-hbase-REGIONSERVER
drwxr-x--x 3 mapred    hadoop    400 Oct 25 12:02 28-mapreduce-TASKTRACKER
drwxr-x--x 3 zookeeper zookeeper 300 Oct 25 11:27 42-zookeeper-init
drwxr-x--x 3 zookeeper zookeeper 300 Oct 25 11:27 45-zookeeper-init
drwxr-x--x 3 zookeeper zookeeper 300 Oct 25 11:53 50-zookeeper-server
drwxr-x--x 3 zookeeper zookeeper 300 Oct 25 12:01 57-zookeeper-server
drwxr-x--x 3 root      root      120 Oct 25 13:34 66-cluster-host-inspector
drwxr-x--x 3 zookeeper zookeeper 300 Oct 25 13:37 69-zookeeper-init
drwxr-x--x 3 zookeeper zookeeper 300 Oct 25 13:37 78-zookeeper-init
drwxr-x--x 3 zookeeper zookeeper 280 Oct 25 13:37 81-zookeeper-server
drwxr-x--x 3 hdfs      hdfs      380 Oct 25 13:47 92-hdfs-DATANODE
drwxr-x--x 3 hdfs      hdfs      380 Oct 25 13:48 97-hdfs-DATANODE
drwxr-xr-x 4 root      root      120 Oct 25 12:02 ccdeploy_hadoop-conf_etchadoopconf.cloudera.hdfs_5649848240809758678
drwxr-xr-x 4 root      root      100 Oct 25 13:58 ccdeploy_hadoop-conf_etchadoopconf.cloudera.hdfs_7398394681881635199
drwxr-xr-x 4 root      root      120 Oct 25 12:02 ccdeploy_hadoop-conf_etchadoopconf.cloudera.mapreduce_-2673408479045417972
drwxr-xr-x 4 root      root      120 Oct 25 12:02 ccdeploy_hadoop-conf_etchadoopconf.cloudera.yarn_-1005083387598475902
drwxr-xr-x 4 root      root      120 Oct 25 13:57 ccdeploy_hadoop-conf_etchadoopconf.cloudera.yarn_-6705076819038408536
drwxr-xr-x 4 root      root      120 Oct 25 13:49 ccdeploy_hbase-conf_etchbaseconf.cloudera.hbase_-3092799128047782022
drwxr-xr-x 4 root      root      120 Oct 25 12:01 ccdeploy_hbase-conf_etchbaseconf.cloudera.hbase_5874922965138968021
drwxr-xr-x 4 root      root      120 Oct 25 13:49 ccdeploy_hive-conf_etchiveconf.cloudera.hive_-4774628730451574688
drwxr-xr-x 4 root      root      120 Oct 25 12:01 ccdeploy_hive-conf_etchiveconf.cloudera.hive_-6548534624731457338
drwxr-xr-x 7 root      root      180 Oct 25 13:49 ccdeploy_spark-conf_etcsparkconf.cloudera.spark_on_yarn_-8068810184727660673
[root@slave1 process]# cd 117-hdfs-DATANODE/
[root@slave1 117-hdfs-DATANODE]# ll
total 48
-rw-r----- 1 hdfs hdfs  372 Oct 25 13:59 cloudera-monitor.properties
-rw-r----- 1 hdfs hdfs  319 Oct 25 13:59 cloudera-stack-monitor.propert
-rw-r----- 1 hdfs hdfs 3254 Oct 25 13:59 core-site.xml
-rw-r----- 1 hdfs hdfs 1511 Oct 25 13:59 event-filter-rules.json
-rw-r----- 1 hdfs hdfs    0 Oct 25 13:59 hadoop-metrics2.properties
-rw-r----- 1 hdfs hdfs   98 Oct 25 13:59 hadoop-policy.xml
-rw------- 1 hdfs hdfs    0 Oct 25 13:58 hdfs.keytab
-rw-r----- 1 hdfs hdfs  214 Oct 25 13:59 hdfs-site-refreshable.xml
-rw-r----- 1 hdfs hdfs 4219 Oct 25 13:59 hdfs-site.xml
-rw-r----- 1 hdfs hdfs    0 Oct 25 13:59 http-auth-signature-secret
-rw-r----- 1 hdfs hdfs 3182 Oct 25 13:59 log4j.properties
drwxr-x--x 2 hdfs hdfs   80 Oct 25 13:58 logs
-rw-r----- 1 hdfs hdfs    0 Oct 25 13:59 redaction-rules.json
-rw-r----- 1 hdfs hdfs  315 Oct 25 13:59 ssl-client.xml
-rw-r----- 1 hdfs hdfs   98 Oct 25 13:59 ssl-server.xml
-rw------- 1 root root 3148 Oct 25 13:58 supervisor.conf
[root@slave1 117-hdfs-DATANODE]# chown hdfs:hdfs supervisor.conf
[root@slave1 117-hdfs-DATANODE]# ll
total 52
-rw-r----- 1 hdfs hdfs  372 Oct 25 13:59 cloudera-monitor.properties
-rw-r----- 1 hdfs hdfs  319 Oct 25 13:59 cloudera-stack-monitor.propert
-rw-r----- 1 hdfs hdfs 3254 Oct 25 13:59 core-site.xml
-rw-r----- 1 hdfs hdfs 1511 Oct 25 13:59 event-filter-rules.json
-rw-r----- 1 hdfs hdfs    0 Oct 25 13:59 hadoop-metrics2.properties
-rw-r----- 1 hdfs hdfs   98 Oct 25 13:59 hadoop-policy.xml
-rw------- 1 hdfs hdfs    0 Oct 25 13:58 hdfs.keytab
-rw-r----- 1 hdfs hdfs  214 Oct 25 13:59 hdfs-site-refreshable.xml
-rw-r----- 1 hdfs hdfs 4219 Oct 25 13:59 hdfs-site.xml
-rw-r----- 1 hdfs hdfs    0 Oct 25 13:59 http-auth-signature-secret
-rw-r----- 1 hdfs hdfs 3182 Oct 25 13:59 log4j.properties
drwxr-x--x 2 hdfs hdfs   80 Oct 25 13:58 logs
-rw-r--r-- 1 root root   13 Oct 25 14:01 process_timestamp
-rw-r----- 1 hdfs hdfs    0 Oct 25 13:59 redaction-rules.json
-rw-r----- 1 hdfs hdfs  315 Oct 25 13:59 ssl-client.xml
-rw-r----- 1 hdfs hdfs   98 Oct 25 13:59 ssl-server.xml
-rw------- 1 hdfs hdfs 3148 Oct 25 13:58 supervisor.conf
[root@slave1 117-hdfs-DATANODE]# vim supervisor.conf
[root@slave1 117-hdfs-DATANODE]# setup
[root@slave1 117-hdfs-DATANODE]# exit
logout
Connection to slave1 closed.
[root@master1 nn]# setup
[root@master1 nn]# cd /var/log/h
hadoop-0.20-mapreduce/ hadoop-mapreduce/      hive/
hadoop-hdfs/           hbase/                 httpd/
[root@master1 nn]# cd /var/log/hadoop-hdfs/
hadoop-cmf-hdfs-NAMENODE-master1.log.out           SecurityAuth-hdfs.au
hadoop-cmf-hdfs-SECONDARYNAMENODE-master1.log.out  stacks/
hdfs-audit.log
[root@master1 nn]# cd /var/log/hadoop-hdfs/
[root@master1 hadoop-hdfs]# ll
total 1756
-rw-r--r-- 1 hdfs hdfs 911206 Oct 25 14:08 hadoop-cmf-hdfs-NAMENODE-mas
-rw-r--r-- 1 hdfs hdfs 268375 Oct 25 14:07 hadoop-cmf-hdfs-SECONDARYNAM
-rw-r--r-- 1 hdfs hdfs 601620 Oct 25 14:08 hdfs-audit.log
-rw-r--r-- 1 hdfs hdfs      0 Oct 18 17:28 SecurityAuth-hdfs.audit
drwxr-xr-x 2 hdfs hdfs   4096 Oct 18 17:28 stacks
[root@master1 hadoop-hdfs]# ssh root@slave1
root@slave1's password:
Last login: Wed Oct 25 14:00:08 2017 from master1
[root@slave1 ~]# cd /var/log/hadoop-hdfs/
[root@slave1 hadoop-hdfs]# ll
total 1180
-rw-r--r-- 1 hdfs hdfs 1198141 Oct 25 14:05 hadoop-cmf-hdfs-DATANODE-sl
-rw-r--r-- 1 hdfs hdfs       0 Oct 18 17:28 hdfs-audit.log
-rw-r--r-- 1 hdfs hdfs       0 Oct 18 17:28 SecurityAuth-hdfs.audit
drwxr-xr-x 2 hdfs hdfs    4096 Oct 18 17:28 stacks
[root@slave1 hadoop-hdfs]# vim hadoop-cmf-hdfs-DATANODE-slave1.log.out

[1]+  Stopped                 vim hadoop-cmf-hdfs-DATANODE-slave1.log.o
[root@slave1 hadoop-hdfs]# cd /dfs/
[root@slave1 dfs]# l
-bash: l: command not found
[root@slave1 dfs]# ll
total 4
drwx------ 3 hdfs hadoop 4096 Oct 25 14:05 dn
[root@slave1 dfs]# cd dn/
[root@slave1 dn]# ll
total 4
drwxr-xr-x 3 hdfs hdfs 4096 Oct 18 17:28 current
[root@slave1 dn]# rm -rf current/
[root@slave1 dn]# ssh root@slave2ll
ssh: Could not resolve hostname slave2ll: Name or service not known
[root@slave1 dn]# ll
total 0
[root@slave1 dn]# ssh root@slave2
The authenticity of host 'slave2 (192.168.56.103)' can't be established
RSA key fingerprint is f3:9c:1a:11:d6:6f:d1:af:25:e5:71:0e:9e:03:52:d3.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added 'slave2,192.168.56.103' (RSA) to the list of
root@slave2's password:
Last login: Wed Oct 25 13:13:39 2017 from master1
[root@slave2 ~]# cd /dfs/dn
[root@slave2 dn]# ll
total 4
drwxr-xr-x 3 hdfs hdfs 4096 Oct 18 17:28 current
[root@slave2 dn]# rm -rf current/
[root@slave2 dn]# ll
total 0
[root@slave2 dn]# ssh root@slave3
The authenticity of host 'slave3 (192.168.56.104)' can't be established
RSA key fingerprint is f3:9c:1a:11:d6:6f:d1:af:25:e5:71:0e:9e:03:52:d3.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added 'slave3,192.168.56.104' (RSA) to the list of
root@slave3's password:
Last login: Wed Oct 25 13:13:39 2017 from master1
[root@slave3 ~]# cd /dfs/dn
[root@slave3 dn]# ll
total 4
drwxr-xr-x 3 hdfs hdfs 4096 Oct 18 17:28 current
[root@slave3 dn]# rm -rf current/
[root@slave3 dn]# exi
-bash: exi: command not found
[root@slave3 dn]# exit
logout
Connection to slave3 closed.
[root@slave2 dn]# exit
logout
Connection to slave2 closed.
[root@slave1 dn]# exit
logout
There are stopped jobs.
[root@slave1 dn]# exit
logout
Vim: Caught deadly signal TERM
Vim: preserving files...
Connection to slave1 closed.
[root@master1 hadoop-hdfs]# cd /dfs/nn
[root@master1 nn]# ll
total 8
drwxr-xr-x 2 hdfs hdfs 4096 Oct 25 14:11 current
-rw-r--r-- 1 hdfs hdfs   13 Oct 25 14:04 in_use.lock
[root@master1 nn]# ll
total 4
drwxr-xr-x 2 hdfs hdfs 4096 Oct 25 14:11 current
[root@master1 nn]# rm -rf current/
[root@master1 nn]# cd ../
[root@master1 dfs]# ll
total 8
drwx------ 2 hdfs hadoop 4096 Oct 25 14:12 nn
drwx------ 3 hdfs hadoop 4096 Oct 25 14:11 snn
[root@master1 dfs]# cd snn
[root@master1 snn]# ll
total 4
drwxr-xr-x 2 hdfs hdfs 4096 Oct 25 10:59 current
[root@master1 snn]# rm -rf current/
[root@master1 snn]# ll
total 0
