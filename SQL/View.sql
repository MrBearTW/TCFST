USE company;


--製作
CREATE VIEW HHH
AS
SELECT * FROM 員工資料表
WHERE 薪水>80000;

--調整
ALTER VIEW HHH
AS
新的條件  ;

--刪除
DROP VIEW IF EXIST HHH;