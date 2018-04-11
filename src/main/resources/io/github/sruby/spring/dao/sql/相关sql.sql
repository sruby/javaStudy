-- 创建用户并授予权限
CREATE USER `simpledb`@`%` IDENTIFIED BY `simpledb`;
GRANT ALL ON *.* TO `simpledb`@`%`;

-- 创建数据库
CREATE DATABASE simpledb；

-- 创建用户表
CREATE TABLE IF NOT EXISTS `t_user`(
   `userid` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `age` int(3),
   `password` VARCHAR(40) ,
   `lastip` VARCHAR(100) ,
   `lastvisit` VARCHAR(100) ,
   PRIMARY KEY ( `userid` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;