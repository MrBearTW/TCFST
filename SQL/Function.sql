delimiter //
use id2909570_tcfst;//
--use company;//
CREATE FUNCTION mydate()
RETURNS varchar(72)
begin
DECLARE week,day,minute char(24);
set week = dayname(curdate());
set day = time_format(curtime(),'%H:%i:%S');
SET minute = date_format(curdate(),'%Y/%m/%d');
RETURN concat(week,"",day,"",minute);
end//
delimiter ;




select mydate();