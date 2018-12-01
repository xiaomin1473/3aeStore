-- 使用数据库
use store_3ae_mall;

CREATE TABLE orders (
`order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
`user_id` bigint NOT NULL COMMENT '用户ID',
`goods_id` bigint NOT NULL COMMENT '商品ID',
`goods_number` int NOT NULL COMMENT '购买数量',
`order_status` int NOT NULL COMMENT '订单状态',
`deliver_id` bigint NOT NULL COMMENT '收货ID',
`invoice` int NOT NULL COMMENT '发票类型',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (order_id),
key idx_user_id(user_id),
key idx_goods_id(goods_id),
key idx_deliver_id(deliver_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 初始化数据
insert into orders(user_id, goods_id, goods_number, order_status, deliver_id, invoice)
values
	(1000, 1000, 1, 4, 1000, 0);

CREATE TABLE user_deliver (
`deliver_id` bigint NOT NULL AUTO_INCREMENT COMMENT '收货ID',
`user_id` bigint NOT NULL COMMENT '用户ID',
`name` varchar(120) NOT NULL COMMENT '收货联系人姓名',
`phone` bigint NOT NULL COMMENT '收货联系人手机号',
`address` varchar(120) NOT NULL COMMENT '收货地址',
`option_name` varchar(120) NOT NULL COMMENT '备选人姓名',
`option_phone` bigint NOT NULL COMMENT '备选人手机号',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (deliver_id),
key idx_user_id(user_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='收货详情表';

-- 初始化数据
insert into user_deliver(deliver_id, user_id, name, phone, address, option_name, option_phone)
values
	(1000, 1000, "赵宇明", 18235010340, "天堂101", "暂无", 0);