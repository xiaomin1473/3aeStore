-- 使用数据库
use store_3ae_mall;

CREATE TABLE orders (
`order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
`user_id` bigint NOT NULL COMMENT '用户ID',
`goods_id` bigint NOT NULL COMMENT '商品ID',
`class` bigint NOT NULL COMMENT '分类',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`goods_number` int NOT NULL COMMENT '购买数量',
`unit` varchar(3) NOT NULL COMMENT '单位',
`price` decimal NOT NULL COMMENT '订单价格',
`img_url` varchar(120) NOT NULL COMMENT '商品图片',
`status` tinyint NOT NULL DEFAULT -1 COMMENT '-1无效 0成功 1已付款 2已发货 3已收货 4已评价 5已退货 6已退款',
`user_name` varchar(120) NOT NULL COMMENT '收货联系人姓名',
`user_phone` bigint NOT NULL COMMENT '收货联系人手机号',
`address` varchar(120) NOT NULL COMMENT '收货地址',
`invoice` tinyint NOT NULL DEFAULT -1 COMMENT '发票类型 -1无效 0默认',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (order_id),
key idx_user_id(user_id),
key idx_goods_id(goods_id),
key idx_class(class),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 初始化数据
insert into orders(user_id, goods_id, class, name, goods_number, unit, price, img_url, user_name, user_phone, address)
values
	(1000, 1000, 10111300,'iphone6 plus', 1, '部', 1000, './assests/img/iphone.png;', "赵宇明", 18235010340, "天上人间");
