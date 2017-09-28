SELECT 部門編號,count(部門編號) as 人數,avg(薪水) as 平均,STD(薪水) as 標準差,max(薪水) as 最大,min(薪水) as 最小
FROM company.員工資料表
group by 部門編號;

use company;
SELECT *
FROM 員工資料表
WHERE 員工編號 > 7 AND (姓名 LIKE '賴%' OR 姓名 LIKE '林%');

SELECT *
FROM 親屬資料表
LEFT JOIN 員工資料表 ON 員工資料表.員工編號 = 親屬資料表.員工編號;

UPDATE 員工資料表
SET 薪水 = 薪水*1.1
WHERE 員工編號 IN (8,9,10,11,13,15);