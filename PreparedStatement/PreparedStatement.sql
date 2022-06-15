create database mydb;

use mydb;

create table product(
	id int,
	name varchar(20),
	description varchar(255),
	price int
);

select * from product;

insert into product values(1,'Juice','Nice Product in market',100);



