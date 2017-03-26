create database netstore;
use netstore
create table classify(
	id varchar(100) primary key,
	name varchar(100),
	description varchar(100)
);
create table book(
	id varchar(100) primary key,
	name varchar(100),
	author varchar(100),
	price float(5,2),
	path varchar(100),
	filename varchar(100),
	description varchar(100),
	classify_id varchar(100),
	constraint classify_id foreign key(classify_id) references classify(id)

);