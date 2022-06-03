create table t_user(
	`id` int primary key auto_increment,
	`username` varchar(30) not null unique,
	`password` varchar(32) not null,
	`email` varchar(200))ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into t_user(`username`,`password`,`email`) values('admin','admin','11234@qq.com');
