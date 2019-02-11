create database if not exists lawufdb;

use lawufdb;

drop table if exists users;

create table users (
id VARCHAR(50),
password VARCHAR(50),
email VARCHAR(50),
primary key (id));

insert into users values('test', 'test', 'test@test.de');
insert into users values('admin', 'admin', 'admin@test.de');
insert into users values('rex', 'rex', 'rex@lawuf.de');
