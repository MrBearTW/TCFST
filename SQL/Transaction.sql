---一步一步輸入

CREATE DATABASE CRM;

use CRM;

CREATE TABLE customer (a int , b CHAR(20) , INDEX(a) );

start TRANSACTION ;

insert into  customer values (1,'justinWu');

insert into  customer values (2,'johnyWu');

COMMIT;

set autocommit=0;

insert into  customer values (3,'ivy');

ROLLBACK;

select * FROM customer;

-- 檢查 autocommit狀態
show session variables where variable_name = 'autocommit';