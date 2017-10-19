
# YARN
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
Hostname:
Taipei Time
設定ROOT密碼：

Creat Custom Layout>>
1.Mount point:/boot    ext4    200MB    fixed size
2.選swap後就會反灰    swap    200MB    fixed size
3.Mount point:/    ext4    Fill to maximum allowable size

>>format>>選Desktop模式

License check
建立使用者帳號密碼
選NTP Server
Kdump選預設

登入

設定網路
改IPv4
Address:192.168.56.101
Netmask:24
Gateway:192.168.56.1(對應到援主機的虛擬網路卡IP位置)

### 切換成root身份
>su root

### 關防火牆
>setup

第二個Firewall configuration  空白鍵調整成關閉

### 改swappiness

改swappiness=1(預設=60)
>sysctl -w vm.swappiness=1

查看
>cat /proc/sys/vm/swappiness
>vim /etc/sysctl.conf

VIM編輯器

'''
K上J下L左H右
O寫入新的一行
I進入編輯模式
dd刪除一整行
ESC後
:wq 存檔離開
:q! 不存檔離開
'''

改成重新開機就會是=1


修改/sys/kernel/mm/redhat_transparent_hugepage/defrag 開機時會讀到的記憶體管理參數(官方建議關閉)

'''
>  覆蓋
>> append
'''

寫入開機的設定檔中
>echo "never > /sys/kernal/mm/redhat_transparent_hugepage/de">> /etc/rc.local


### 修改selinux(一種安全性設定，沒有disable的話，修改設定不會儲存)
> su
> vim /etc/selinux/config

# Day2 2017/10/19
每一台主機加入第二張網卡，選NAT(不是NAT_網路)，就是會看到的10.0.3.X

啟動虛擬主機
調整網路卡，確定兩張網路卡都將Connect automatically打勾

### 刪除eth0 Gateway 和 mask 
先換成root
> su -

改連線設定檔，把Gateway刪掉
> vi /etc/sysconfig/network-scripts/ifcfg-eth0

選到Gateway那一行
dd把那一行刪掉
選到HWADDR(改MAC，之後複製製作成(slave node時才不會衝突)
dd把那一行刪掉，:wq存檔離開

### 重新啟動網卡
>service network restart(要root才能用)

或
> ifdown eth0
> ifup eth0

### 匯出應用裝置
匯出成OVA格式，記一下匯出的位置
### 匯入應用裝置
1.選到那一個OVA檔案，
2.改名字
3.改記憶體4096(slave)
4.打勾->重新初始化所有網路卡的MAC位置
5.選虛擬機放的位置(就是預設)

### 設定伺服器開啟(只有master要做)
>chkconfig httpd on

>chkconfig |grep httpd

>service httpd start

可以用host主機連192.168.56.101看看有沒有連到阿帕契頁面

### 修改slave的網路設定
將eth0改成192.168.56.102/3/4

> su    #改用root權限，輸入密碼

> cd /etc/udev/rules.d

> rm 70-persistent-net.rules    #網路設定檔

> y

### 改主機名稱
分別為master1,slave1/2/3
> vi /etc/sysconfig/network

### 改設定檔,先改master1,再複製到其他三台slave
> vi /etc/hosts

最後面加上
---
192.168.56.101 master1
192.168.56.102 slave1
192.168.56.103 slave2
192.168.56.104 slave3
---

### 複製編輯好的hosts檔案到其他台
> scp /etc/hosts root@192.168.56.102:/etc/hosts

### 重新啟動全部電腦
ping名稱看通不通
> ping master1 / slave1 / slave2 / slave3



## 設定SSH免帳號密碼
老師跳過PPT62~66

### 複製cdh571,cm571
使用WINSCP，把兩個資料夾cdh571,cm571複製到master內的/var/www/html

> yum repolist

> cd /var/www/html/

### 先安裝createrepo
> yum install createrepo

## 在cm571資料夾 建立一個repodata
> createrepo .

cm571資料夾出現repodata

## 安裝Cloudera Manager Server

>cd /etc/yum.repos.d/

檢查資料夾內有CentOS-Media.repo檔案
>ls

### 創造和修改cloudera.repo
在資料夾內複製一個檔案(CentOS-Media.repo)改名叫做(cloudera.repo)

> cp CentOS-Media.repo cloudera.repo

> vim cloudera.repo

下方改成
---
[cloudera-media]
name=cloudera-$releasever - Mediai
baseurl=http://master1/cm571
gpgcheck=1
enabled=1
gpgkey=http://master1/cm571/RPM-GPG-KEY-cloudera
---
### 檢查 cloudera-6 - Mediai  的狀態是  7
> yum repolist

## 安裝cloudera-manager-server-db-2
> yum install cloudera-manager-server-db-2

### 啟動兩個服務
> service cloudera-scm-server-db start

> service cloudera-scm-server start

要看到是OK

#### PPT80頁安裝mysql跳過

### 確認7180port有啟動，狀態是Listen
> lsof -i:7180

本機瀏覽器開啟可以看到登入畫面
http://192.168.56.101:7180/

預設密碼 admin/admin

入後搜尋
192.168.56.10[1-4] SEARCH


More Option
把下面原本有的刪掉
加入
http://192.168.56.101/cdh571
回到上一層

Custom Repository
http://192.168.56.101/cm571/

Custom GPG Key URL: 
http://192.168.56.101/cm571/RPM-GPG-KEY-cloudera