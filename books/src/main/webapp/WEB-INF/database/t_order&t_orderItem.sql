create table t_order
(
    `order_id` varchar(50) primary key,
    ##订单号
               `create_time` datetime not null,
    ##订单时间
               `total_money` decimal(11,2) not null,
    ##总金额
               `status` int not null default 0,
    ##物流状态：0-未发货、1-等待用户签收、2-用户已签收
        `user_id` int not null,
    ##用户编号
        foreign key (`user_id`) references t_user(`id`)
);

create table t_order_item
(
    `id`   int primary key auto_increment,
    `name` varchar(30) not null,
    ##商品名
           `price` decimal(11,2),
    ##商品单价
           `total_money` decimal(11,2),
    ##商品总金额
           `count` int not null,
    ##商品数量
           `order_id` varchar(50) not null,
    ##订单号
        foreign key (`order_id`) references t_order(`order_id`)
);
