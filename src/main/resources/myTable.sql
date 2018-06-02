create database satisfy default character set utf8;

use satisfy

drop table if exists role_permission;
drop table if exists permission;
drop table if exists role;
drop table if exists user;
drop table if exists answer;
drop table if exists paper_question;
drop table if exists question;
drop table if exists paper;

create table user
(
   id int not null auto_increment,
   username varchar(20),
   password varchar(20),
   createBy int,
   createTime date,
   primary key (id)
);

create table role
(
   id int not null auto_increment,
   name varchar(20),
   primary key (id)
);

create table permission
(
   id int not null auto_increment,
   name varchar(20),
   primary key (id)
);

create table role_permission
(
   role_id int not null,
   permission_id int not null,
   primary key (role_id, permission_id)
);

create table answer
(
   id int not null auto_increment,
   content varchar(200),
   rightAnswer varchar(2)
   question_id int,
   primary key (id)
);

create table question
(
   id int not null auto_increment,
   title varchar(200),
   questionType varchar(8),
   createBy int,
   createTime date,
   isDeleted varchar(2),
   primary key (id)
);

create table paper
(
   id int not null auto_increment,
   name varchar(20),
   number varchar(8),
   createBy int,
   createTime date,
   isDeleted varchar(2),
   primary key (id)
);

create table paper_question
(
   question_id int not null,
   paper_id int not null,
   primary key (question_id, paper_id)
);