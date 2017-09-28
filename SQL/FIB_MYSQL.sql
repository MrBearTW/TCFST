delimiter //
use company;//

CREATE FUNCTION fib(VAR INT)
RETURNS INT

BEGIN
	DECLARE AN INT ;
		IF VAR=0 THEN
			SET AN=0;
			
		ELSEIF VAR=1 THEN
			SET AN=1;
			
		ELSE
			SET AN=fib(VAR-1)+fib(VAR-2);
				END IF;
			RETURN AN;
		end//
		
delimiter ;

-- 只能用在0和1
select fib(0);
