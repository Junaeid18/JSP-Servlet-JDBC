use mydb;

create table customUsers(
	fname varchar(30),
	lname varchar(30),
	email varchar(30)
);

insert into customUsers values('md','kamal','kamal@gmail.com');

insert into customUsers values('md','abul','abul@gmail.com');

select * from customUsers where email='kamal@gmail.com';

