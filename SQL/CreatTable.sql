
CREAT TABLE student(
number int(11) not null default '0',
name char(20) not null default '',
grade int(11) not null default '0',

primary key (number)
);



insert into student (number,name,grade) values (2,"TED",87);