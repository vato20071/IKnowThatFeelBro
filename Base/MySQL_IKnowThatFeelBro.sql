drop schema if exists IKnowThatFeelBro;
create database if not exists IKnowThatFeelBro;

use IKnowThatFeelBro;

select * from account;
select * from category;
update account set `status` = 3 where user_name = 'vato20071';
create table if not exists `account`
(
	`ID` int not null auto_increment primary key,
	`user_name` varchar(100) not null,
	`password` varchar(200) not null,
    `nickname` varchar(100) not null,
	`mail` varchar(150) default null,
	`fb` varchar(150) default null,
	`gplus` varchar(150) default null,
	`coeff_value` decimal(3, 2) default 0,
	`coeff_numb` int default 0,
	`status` int default 0, #1-admin, 2-banned, all other - user
	unique (`user_name`)
);

create table if not exists `category`
(
	`ID` int not null auto_increment primary key,
	`name` varchar(150) not null,
	unique (`name`)
);

create table if not exists `friendship`
(
	`ID` int not null auto_increment primary key,
	`user1_ID` int not null,
	`user2_ID` int not null,
	`cat_ID` int not null,
	foreign key (`user1_ID`) references `account`(`ID`) on delete cascade,
	foreign key (`user2_ID`) references `account`(`ID`) on delete cascade,
	foreign key (`cat_ID`) references `category`(`ID`) on delete cascade
);
