create database company
go

use company

create table ���u��ƪ�(
���u�s�� int not null,
�m�W char(20) not null,
�ʧO char(8) not null,
�a�} char(80),
�~�� money,
�����s�� int,
primary key(���u�s��)
)

create table ������ƪ�(
�����s�� int not null,
���� char(20) not null,
�}�l�޲z��� datetime,
�~�� money ,
�޲z�� int not null,
primary key(�����s��)
)

create table ������}��ƪ�(
�����s�� int not null,
��} char(80) not null,
primary key(�����s��,��})
)

create table �p�e��ƪ�(
�p�e�s�� int not null,
�p�e�W�� char(20) not null,
�p�e�a�I char(80),
�����s�� int not null,
primary key(�p�e�s��),
foreign key(�����s��)references ������ƪ�(�����s��)
)

create table �ѻP��ƪ�(
���u�s�� int not null, 
�p�e�s�� int not null,
�ѻP�ɼ� int ,
primary key (���u�s��,�p�e�s��),
foreign key(���u�s��) references ���u��ƪ�(���u�s��),
foreign key(�p�e�s��) references �p�e��ƪ�(�p�e�s��),
 )

create table ���ݸ�ƪ�(
���u�s�� int not null, 
�m�W char(20) not null,
�ʧO char(8) not null,
�a�} char(80),
primary key (���u�s��,�m�W),
foreign key(���u�s��)references ���u��ƪ�(���u�s��)
 ) 





use company
insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (6,'�d�N��','�k','�x�_���q�Ƶ�168��',38000,1);

insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (7,'������','�k','�x�_���n�ʪF���G�q22��9F',58000,2)




insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (8,'����q','�k','�s�_���s�x�����G�q33��',58000,3);

insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (9,'�L�p��','�k','�x�_�������F���T�q55��6F',38000,5)

insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (10,'���y�R','�k','�x�_���w�M���G�q�G�q192��5F',58000,3)


insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (11,'���Q�V','�k','�x�_��������336��',138000,4)

insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (12,'���R��','�k','�x�_�����ƫn���G�q122��12F',58000,4)


insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (13,'������','�k','�x�_���~�f��q98��5F',98000,3)

insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (14,'�B�a�^','�k','�x�_�������F���|�q29��16F',98000,5)

insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (15,'�P�w��','�k','�s�˥�������25��9F',128000,3)


insert into ���u��ƪ� (���u�s��,�m�W,�ʧO,�a�},�~��,�����s��) values (16,'�}�t�p','�k','�x�_���H�q���|�q365��8F',98000,4)


insert into ������ƪ� (�����s��,����,�޲z��,�}�l�޲z���) values (1,'�Ȥ�䴩��',15,'1996/1/1')
insert into ������ƪ� (�����s��,����,�޲z��,�}�l�޲z���) values (2,'�C��s�@��',16,'1995/3/5')
insert into ������ƪ� (�����s��,����,�޲z��,�}�l�޲z���) values (3,'�]�ȳ�',13,'1998/3/5')
insert into ������ƪ� (�����s��,����,�޲z��,�}�l�޲z���) values (4,'�~�ȳ�',11,'2001/8/9')
insert into ������ƪ� (�����s��,����,�޲z��,�}�l�޲z���) values (5,'�޲z��',14,'1998/8/9')

insert into ���ݸ�ƪ� (���u�s��,�m�W,�ʧO,�a�}) values (6,'�d���R','�k','�x�_���_���n���@�q66��')
insert into ���ݸ�ƪ� (���u�s��,�m�W,�ʧO,�a�}) values (6,'�d�E��','�k','�x�_���n�����@�q98��')
insert into ���ݸ�ƪ� (���u�s��,�m�W,�ʧO,�a�}) values (12,'����','�k','�x�_�����ƫn���G�q122��12F')
insert into ���ݸ�ƪ� (���u�s��,�m�W,�ʧO,�a�}) values (12,'���S�S','�k','�x�_�����ƫn���G�q122��12F')
insert into ���ݸ�ƪ� (���u�s��,�m�W,�ʧO,�a�}) values (12,'�����l','�k','�x�_�����ƫn���G�q122��12F')




insert into �p�e��ƪ� (�p�e�s��,�p�e�W��,�p�e�a�I,�����s��) values (1,'3D�O����p�e','�x�_���n���2�q99��',1)

insert into �p�e��ƪ� (�p�e�s��,�p�e�W��,�p�e�a�I,�����s��) values (2,'12�T����p�e','�x�_���n���2�q99��',1)

insert into �p�e��ƪ� (�p�e�s��,�p�e�W��,�p�e�a�I,�����s��) values (3,'3DFinfet�p�e','�s�˥�������63��',1)

insert into �p�e��ƪ� (�p�e�s��,�p�e�W��,�p�e�a�I,�����s��) values (4,'�ײv���I','�x�_���n���2�q99��',3)

insert into �p�e��ƪ� (�p�e�s��,�p�e�W��,�p�e�a�I,�����s��) values (5,'���y�����X�j','�x�_�������F���@�q38��',4)




insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (6,1,25)

insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (6,2,250)
insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (8,3,250)

insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (9,5,250)

insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (10,4,250)

insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (11,5,350)
insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (12,5,250)

insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (13,4,350)
insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (15,1,25)

insert into �ѻP��ƪ� (���u�s��,�p�e�s��,�ѻP�ɼ�) values (15,2,350)



ALTER TABLE ���u��ƪ� ADD CONSTRAINT depart_no
FOREIGN KEY (�����s��)
REFERENCES ������ƪ�(�����s��)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE ������ƪ� ADD CONSTRAINT manager
FOREIGN KEY (�޲z��)
REFERENCES ���u��ƪ�(���u�s��)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE ������}��ƪ� ADD CONSTRAINT depart_loc
FOREIGN KEY (�����s��)
REFERENCES ������ƪ�(�����s��)
ON DELETE NO ACTION
ON UPDATE NO ACTION


create view HS
with encryption
as
select * from ���u��ƪ�
where �~��>80000

USE COMPANY

select ���u��ƪ�.�m�W from ���u��ƪ�
UNION
select ���ݸ�ƪ�.�m�W from ���ݸ�ƪ�


select ���u��ƪ�.���u�s��,���u��ƪ�.�m�W,������ƪ�.����
from ���u��ƪ� LEFT JOIN ������ƪ�
on ���u��ƪ�.���u�s�� = ������ƪ�.�޲z��