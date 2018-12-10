-- 使用数据库
use store_3ae_mall;

CREATE TABLE tb_orders (
`order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
`user_id` bigint NOT NULL COMMENT '用户ID',
`goods_sku_id` bigint NOT NULL COMMENT '商品ID',
`payment_id` bigint NOT NULL DEFAULT -1 COMMENT '支付ID 默认-1无效 0未支付',
`classType` bigint NOT NULL COMMENT '分类',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`goods_number` int NOT NULL COMMENT '购买数量',
`unit` varchar(3) NOT NULL COMMENT '单位',
`sku_price` decimal NOT NULL COMMENT '订单价格',
`img_url` varchar(120) NOT NULL COMMENT '商品图片',
`discount_way` tinyint NOT NULL COMMENT '优惠方式 -1无效 0正常 1满减 2优惠券 3虚拟代币 4套餐 5秒杀 6节日活动 7组合 8其他',
`discount` decimal NOT NULL COMMENT '优惠金额',
`user_name` varchar(120) NOT NULL COMMENT '收货联系人姓名',
`user_phone` bigint NOT NULL COMMENT '收货联系人手机号',
`address` varchar(120) NOT NULL COMMENT '收货地址',
`invoice` tinyint NOT NULL DEFAULT -1 COMMENT '发票类型 默认-1无效 0无发票 1增专 ',
`status` tinyint NOT NULL DEFAULT -1 COMMENT '订单状态, 默认-1无效 0成功 1已付款 2已发货 3已收货 4已评价 5交易成功 6售后中 7交易关闭',
`after_sale_status` bigint NOT NULL DEFAULT -1 COMMENT '售后状态, 默认-1无效, 0成功 1待审核 2待退货入库 3待退款 4待换货入库 5换货出库 6售后成功',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_order_id(order_id),
key idx_user_id(user_id),
key idx_payment_id(payment_id),
key idx_goods_sku_id(goods_sku_id),
key idx_classType(classType),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 初始化数据
insert into tb_orders(user_id, goods_sku_id, payment_id, classType, name, goods_number, unit, sku_price, img_url, discount_way, discount, user_name, user_phone, address)
values
	(1000, 1000, 0, 1010101,'iphone6 plus', 1, '部', 1000, './assests/img/iphone.png;', 0, 0, "赵宇明", 18235010340, "天上人间");
