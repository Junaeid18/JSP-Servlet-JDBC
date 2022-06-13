create database jdbc_crud;

use jdbc_crud;

create table account(
	accno int,
	firstname varchar(30),
	lastname varchar(30),
	balance int
);

select * from account;

insert into account(accno,firstname,lastname,balance) values(1001,'Md','Junaeid',5000);

insert into account values(1002,'Ziaul','Haque',50000);


