myPWD=$(pwd)
mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.bak
cp $myPWD/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo
yum install -y $myPWD/pgdg-centos10-10-2.noarch.rpm
yum install -y postgresql10-server

/usr/pgsql-10/bin/postgresql-10-setup initdb

cp $myPWD/postgresql.conf /var/lib/pgsql/10/data
cp $myPWD/pg_hba.conf /var/lib/pgsql/10/data

systemctl enable postgresql-10.service
systemctl restart postgresql-10.service

cd /var/lib/pgsql/10
sudo -u postgres createuser -s -d -l -r root
sudo -u postgres createdb root
