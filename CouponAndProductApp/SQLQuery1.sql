use mydb;

create table products(
	id int identity(1,1) primary key,
	name varchar(30),
	desciption varchar(100),
	price decimal(6,3)
);

create table coupon(
	id int identity(1,1) primary key,
	code varchar(10),
	exp_date varchar(10),
	discount decimal(6,3)
);

select * from products;

select * from coupon;



