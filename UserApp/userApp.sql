create database mydb;

use mydb;

create table users(
	firstName varchar(20),
	lastName varchar(20),
	email varchar(30),
	password varchar(20)
);

select * from  users;

insert into users values('Md','Junaeid','jun@mail.com','1234');

update users set password = 4321 where email = 'jun@mail.com';

delete from users where firstName = 'john';

create table product(
	id int,
	name varchar(20),
	description varchar(255),
	price int
);

select * from product;





