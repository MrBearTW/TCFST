create database company;

use company;

create table 員工資料表(
員工編號 int not null,
姓名 char(20) not null,
性別 char(8) not null,
地址 char(80),
薪水 int,
部門編號 int,
primary key(員工編號)
);

create table 部門資料表(
部門編號 int not null,
部門 char(20) not null,
開始管理日期 datetime,
薪水 int ,
管理者 int not null,
primary key(部門編號)
);

create table 部門位址資料表(
部門編號 int not null,
位址 char(80) not null,
primary key(部門編號,位址)
);

create table 計畫資料表(
計畫編號 int not null,
計畫名稱 char(20) not null,
計畫地點 char(80),
部門編號 int not null,
primary key(計畫編號),
foreign key(部門編號)references 部門資料表(部門編號)
);

create table 參與資料表(
員工編號 int not null, 
計畫編號 int not null,
參與時數 int ,
primary key (員工編號,計畫編號),
foreign key(員工編號) references 員工資料表(員工編號),
foreign key(計畫編號) references 計畫資料表(計畫編號)
);

create table 親屬資料表(
員工編號 int not null, 
姓名 char(20) not null,
性別 char(8) not null,
地址 char(80),
primary key (員工編號,姓名),
foreign key(員工編號) references 員工資料表(員工編號)
 ); 



use company;
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (6,'吳吉雄','男','台北市通化街168號',38000,1);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (7,'陳炫銘','男','台北市南京東路二段22號9F',58000,2);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (8,'賴泰益','男','新北市新台五路二段33號',58000,3);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (9,'林峰任','男','台北市忠孝東路三段55號6F',38000,5);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (10,'陳宜靜','女','台北市安和路二段二段192號5F',58000,3);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (11,'宋淑姬','女','台北市襄陽路336號',138000,4);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (12,'廖崇旭','男','台北市敦化南路二段122號12F',58000,4);


insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (13,'陳郁雯','女','台北市漢口街段98號5F',98000,3);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (14,'劉冠吾','男','台北市忠孝東路四段29號16F',98000,5);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (15,'周德璋','男','新竹市中央路25號9F',128000,3);
insert into 員工資料表 (員工編號,姓名,性別,地址,薪水,部門編號) values (16,'徐靖峰','女','台北市信義路四段365號8F',98000,4);


insert into 部門資料表 (部門編號,部門,管理者,開始管理日期) values (1,'客戶支援部',15,'1996/1/1');
insert into 部門資料表 (部門編號,部門,管理者,開始管理日期) values (2,'媒體製作部',16,'1995/3/5');
insert into 部門資料表 (部門編號,部門,管理者,開始管理日期) values (3,'財務部',13,'1998/3/5');
insert into 部門資料表 (部門編號,部門,管理者,開始管理日期) values (4,'業務部',11,'2001/8/9');
insert into 部門資料表 (部門編號,部門,管理者,開始管理日期) values (5,'管理部',14,'1998/8/9');

insert into 親屬資料表 (員工編號,姓名,性別,地址) values (6,'吳瑪麗','女','台北市復興南路一段66號');
insert into 親屬資料表 (員工編號,姓名,性別,地址) values (6,'吳鴻基','男','台北市南海路一段98號');
insert into 親屬資料表 (員工編號,姓名,性別,地址) values (12,'廖近','男','台北市敦化南路二段122號12F');
insert into 親屬資料表 (員工編號,姓名,性別,地址) values (12,'廖娟娟','女','台北市敦化南路二段122號12F');
insert into 親屬資料表 (員工編號,姓名,性別,地址) values (12,'廖賓彬','男','台北市敦化南路二段122號12F');




insert into 計畫資料表 (計畫編號,計畫名稱,計畫地點,部門編號) values (1,'3D記憶體計畫','台北市南港路2段99號',1);
insert into 計畫資料表 (計畫編號,計畫名稱,計畫地點,部門編號) values (2,'12吋晶圓計畫','台北市南港路2段99號',1);
insert into 計畫資料表 (計畫編號,計畫名稱,計畫地點,部門編號) values (3,'3DFinfet計畫','新竹市中央路63號',1);
insert into 計畫資料表 (計畫編號,計畫名稱,計畫地點,部門編號) values (4,'匯率避險','台北市南港路2段99號',3);
insert into 計畫資料表 (計畫編號,計畫名稱,計畫地點,部門編號) values (5,'全球市場擴大','台北市忠孝東路一段38號',4);




insert into 參與資料表 (員工編號,計畫編號,參與時數) values (6,1,25);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (6,2,250);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (8,3,250);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (9,5,250);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (10,4,250);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (11,5,350);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (12,5,250);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (13,4,350);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (15,1,25);
insert into 參與資料表 (員工編號,計畫編號,參與時數) values (15,2,350);


ALTER TABLE 員工資料表 ADD CONSTRAINT depart_no FOREIGN KEY (部門編號) REFERENCES 部門資料表(部門編號) 
;

ALTER TABLE 部門資料表 ADD CONSTRAINT manager FOREIGN KEY (管理者) REFERENCES 員工資料表(員工編號)
;

ALTER TABLE 部門位址資料表 ADD CONSTRAINT depart_loc FOREIGN KEY (部門編號) REFERENCES 部門資料表(部門編號)
;


/*


create  view HS
-- with encryption
as
select * from 員工資料表
where 薪水>80000
;

select 員工資料表.姓名 from 員工資料表
union
select 親屬資料表.姓名 from 親屬資料表
;

select 員工資料表.員工編號,員工資料表.姓名,部門資料表.部門
from 員工資料表 LEFT join 部門資料表
on 員工資料表.員工編號 = 部門資料表.管理者
;

./