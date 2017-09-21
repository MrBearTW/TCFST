use company;
select * from 員工資料表 where 員工編號=8;

select 員工編號 ,姓名, 薪水
from 員工資料表
where 薪水 > 15000;

select *
from 員工資料表
where 姓名 like "陳%" and 薪水 > 10000
order by 員工編號 desc;

select avg(薪水)
from 員工資料表
where 員工編號 > 11 and 員工編號 < 17;

select *
from 員工資料表
inner join 親屬資料表 on 員工資料表.員工編號 = 親屬資料表.員工編號 
where 員工資料表.員工編號 > 0 and 員工資料表.員工編號 < 11;


update 員工資料表
set 部門編號 = 2
where 員工編號 = 3;

delete from 員工資料表
where 員工編號 = 3;

--------------------------------------------------------------------------------

select *
from 員工資料表 as r
inner join 親屬資料表 on 員工資料表.員工編號 = r.員工編號 
where 員工資料表.員工編號 > 0 and 員工資料表.員工編號 < 11;