create database QLSV
go
use QLSV
go

create table users(
	username nvarchar(50) primary key,
	password nvarchar(50),
	role nvarchar(50), 
)
create table student(
	MASV nvarchar(50) primary key,
	hoTen nvarchar(50),
	email nvarchar(50), 
	soDT nvarchar(50),
	gioiTinh bit,
	diaChi nvarchar(50),
)
create table grade(
	id int primary key,
	MASV nvarchar(50) foreign key references student(MASV),
	tiengAnh int, 
	tinHoc int,
	gdtc int,
)

insert into users(username, password, role) values (N'thaovp', 'thao123', N'Cán bộ đào tạo')
insert into users(username, password, role) values (N'phatnd', 'phat123', N'Giảng viên')
select * from users

insert into student(MASV, hoTen, email, soDT, gioiTinh, diaChi) values ('P01', N'Nguyễn Văn A', N'a@gmail.com', '0336917313', 0, N'Thường Tín')
insert into student(MASV, hoTen, email, soDT, gioiTinh, diaChi) values ('P02', N'Nguyễn Thị B', N'b@gmail.com', '0949119238', 1, N'Thái Bình')
select * from student
select * from grade

insert into grade(id, MASV, tiengAnh, tinHoc, gdtc) values (1, 'P01', 8, 8, 8)
insert into grade(id, MASV, tiengAnh, tinHoc, gdtc) values (2, 'P02', 9, 9, 9)
select * from grade inner join student on student.MASV = grade.MASV
select * from grade inner join student on student.MASV = grade.MASV where student.MASV = N'P02'
delete g from grade g inner join student s on g.MASV = s.MASV where g.MASV = N'P02'
delete grade where grade.MASV = N'P03'
delete from student where MASV = N'P03'
select * from grade inner join student on student.MASV = grade.MASV where grade.MASV = N'P02'
select * from users where username = N'phatnd' and password = 'phat123'