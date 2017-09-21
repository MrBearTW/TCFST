
delimiter //

use company;//
create PROCEDURE show_empolyee_salaryshow_empolyee_salary()
BEGIN
SELECT * from 員工資料表 where 薪水 > 50000;
SELECT * from 員工資料表 where 性別 = '男';
end//

delimiter ;








call show_empolyee_salaryshow_empolyee_salary();