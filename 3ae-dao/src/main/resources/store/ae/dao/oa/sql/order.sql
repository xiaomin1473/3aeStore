-- 使用数据库
use store_3ae_mall;

CREATE TABLE tb_order (
`order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
`user_id` bigint NOT NULL COMMENT '用户ID',
`logistics_id` bigint NOT NULL COMMENT '物流ID',
`category_type` bigint NOT NULL COMMENT '商品分类',
`discount_way` tinyint NOT NULL COMMENT '优惠方式 -1无效 0未优惠 1满减 2优惠券 3虚拟代币 4套餐 5秒杀 6节日活动 7组合 8其他',
`discount` decimal(8, 2) NOT NULL DEFAULT 0 COMMENT '优惠金额 默认0',
`payment` decimal(8, 2) NOT NULL DEFAULT 0 COMMENT '支付金额 默认0',
`invoice` tinyint NOT NULL DEFAULT -1 COMMENT '发票类型 默认-1无效 0无发票 1增专 ',
`order_status` tinyint NOT NULL DEFAULT -1 COMMENT '订单状态, 默认-1无效 0未支付 1已付款待发货 2已发货待收货 3已收货待评价  4已评价 5交易成功 6售后中 7交易关闭',
`after_sale_status` tinyint NOT NULL DEFAULT -1 COMMENT '售后状态, 默认-1无效, 0成功 1待审核 2待退货入库 3待退款 4待换货入库 5换货出库 6售后成功',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_order_id(order_id),
key idx_category_type(category_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 初始化数据
insert into tb_order(user_id, logistics_id, category_type, discount_way, discount, payment, invoice, order_status, after_sale_status)
values
	(1000, 1000, 1010101, 0, 0, 0, 0, -1, -1);

CREATE TABLE tb_order_goods (
`order_id` bigint NOT NULL COMMENT '订单ID',
`goods_sku_id` bigint NOT NULL COMMENT '商品ID',
`category_type` bigint NOT NULL COMMENT '分类',
`goods_name` varchar(120) NOT NULL COMMENT '商品名称',
`goods_number` int NOT NULL COMMENT '购买数量',
`unit` varchar(3) NOT NULL COMMENT '单位',
`sku_price` decimal(8, 2) NOT NULL DEFAULT 0 COMMENT '商品金额',
`img_url` varchar(120) NOT NULL COMMENT '商品图片',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_order_id(order_id),
key idx_goods_sku_id(goods_sku_id),
key idx_category_type(category_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 初始化数据
insert into tb_order_goods(order_id, goods_sku_id, category_type, goods_name, goods_number, unit, sku_price, img_url)
values
	(1000, 1000, 1010101,'iphone6 plus', 1, '部', 1000, './assets/img/iphone.png;');


CREATE TABLE tb_order_buyer (
`order_id` bigint NOT NULL COMMENT '订单ID',
`category_type` bigint NOT NULL COMMENT '分类',
`user_name` varchar(32) NOT NULL COMMENT '用户名称',
`buyer_name` varchar(32) NOT NULL COMMENT '收货联系人姓名',
`buyer_phone` bigint NOT NULL COMMENT '收货联系人手机号',
`buyer_address` varchar(120) NOT NULL COMMENT '收货地址',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_order_id(order_id),
key idx_category_type(category_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单用户表';

-- 初始化数据
insert into tb_order_buyer(order_id, category_type, user_name, buyer_name, buyer_phone, buyer_address)
values
	(1000, 1010101, "xiaomin1473", "赵宇明", 18235010340, "天上人间");

CREATE TABLE tb_order_logistics (
`order_id` bigint NOT NULL COMMENT '订单ID',
`category_type` bigint NOT NULL COMMENT '商品分类',
`logistics_status` tinyint NOT NULL DEFAULT -1 COMMENT '物流状态 默认-1无效 0未发货, 1已发货, 2已签收, 3物流关闭',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_order_id(order_id),
key idx_category_type(category_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 初始化数据
insert into tb_order_logistics(order_id, category_type, logistics_status)
values
	(1000, 1010101, -1);
	

-- 批量删除表
Select CONCAT( 'drop table ', table_name, ';' ) 
	FROM information_schema.tables 
	Where table_name LIKE 'tb_order_%';