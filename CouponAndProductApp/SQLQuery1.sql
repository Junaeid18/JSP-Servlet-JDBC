use mydb;

create table products(
	id int identity(1,1) primary key,
	name varchar(30),
	desciption varchar(100),
	price decimal(6,3)
);

insert into products(name,desciption,price) values('PoemBook','A book by Poet JashimUddin',15);

create table coupon(
	id int identity(1,1) primary key,
	code varchar(10),
	exp_date varchar(10),
	discount decimal(6,3)
);

select * from products;

select * from coupon;

insert into coupon(code,exp_date,discount) values('1a3a','20-05-2022',130);

select * from coupon where code='1a3a';



