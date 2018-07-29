drop database if exists articledb;
create database articledb;
use articledb;
drop table taikhoan;
CREATE TABLE taikhoan (
  id varchar(24) not null,
  pass varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE taikhoan ALTER id SET DEFAULT NULL;
select * from taikhoan;
insert into taikhoan
values('admin','123');

create table article
(
ID int auto_increment primary key,
title nvarchar(50),
category nvarchar(30),
submitDate date,
content nvarchar(500)  
);

create table student
(
ID int auto_increment primary key,
Fullname nvarchar(50),
Ngaysinh date,
gioitinh nchar(5),
Khoa nvarchar(50)  
);

insert into student(Fullname, ngaysinh,gioitinh,khoa)
values('Nguyễn Văn A','1996-05-25','Nam','Hệ thống thông tin');
insert into student(Fullname, ngaysinh,gioitinh,khoa)
values('Nguyễn Văn B','1995-07-30','Nam','Công nghệ phần mềm');
insert into student(Fullname, ngaysinh,gioitinh,khoa)
values('Nguyễn Văn C','1992-10-17','Nữ','hgghjghjghj');