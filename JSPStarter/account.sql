use mydb;

create table userAccount(
	accno int,
	fname varchar(30),
	lname varchar(30),
	balance int
);

insert into userAccount values(1234, 'MD','Junaeid',15000);

select * from userAccount;

