-- 使用数据库
use store_3ae_mall;

CREATE TABLE goods (
`goods_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
`goods_type_id` bigint NOT NULL COMMENT '商品类型ID',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`price` decimal NOT NULL COMMENT '商品价格',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (goods_id),
key idx_goods_type_id(goods_type_id),
key idx_price(price),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 初始化数据
insert into goods(goods_type_id, name, number, price)
values
	(1000, 'iphone6 plus', 100, 4000);
	
CREATE TABLE goods_image (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`name` varchar(120) NOT NULL COMMENT '图片名称',
`number_info` int NOT NULL COMMENT '图片数量',
`number_detail` int NOT NULL COMMENT '详情图片数量',
`suffix_type` varchar(10) NOT NULL COMMENT '图片类型',
`urls_info` varchar(120) NOT NULL COMMENT '商品图片地址',
`urls_detail` varchar(120) NOT NULL COMMENT '商品详情图片地址',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (goods_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 初始化数据
insert into goods_image(goods_id, name, number_info, number_detail, suffix_type, urls_info, urls_detail)
values
	(1000, 'iphone6 plus', 1, 1, 'png', './assests/img/iphone.png;', './assests/img/iphone.png;');
	
CREATE TABLE goods_type (
`goods_type_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
`name` varchar(120) NOT NULL COMMENT '类型名称',
`grade` bigint NOT NULL COMMENT '类型级别',
`parent_grade` bigint NOT NULL COMMENT '父类型级别',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (goods_type_id),
key idx_grade(grade),
key idx_parent_grade(parent_grade),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- 初始化数据
insert into goods_type(name, grade, parent_grade)
values
	('手机', 10001100, 10001000),
	('电子', 10001000, 10000000),
	('数码', 10001200, 10001000),
	('相机', 10001300, 10001000);

CREATE TABLE goods_detail (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`detail` text(300) NOT NULL COMMENT '商品详情',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (goods_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品详情表';

-- 初始化数据
insert into goods_detail(goods_id, name, detail)
values
	(1000, 'iphone6 plus', '暂无');
	
CREATE TABLE goods_evaluate (
`evaluate_id` bigint NOT NULL AUTO_INCREMENT COMMENT '评价ID',
`goods_id` bigint NOT NULL COMMENT '商品ID',
`name` varchar(120) NOT NULL COMMENT '评价名称',
`evaluate_rank` int NOT NULL COMMENT '评价等级',
`user_id` bigint NOT NULL COMMENT '评价用户',
`content` text(300) NOT NULL COMMENT '评价内容',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (evaluate_id),
key idx_goods_id(goods_id),
key idx_evaluate_rank(evaluate_rank),
key idx_user_id(user_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户评价表';

-- 初始化数据
insert into goods_evaluate(goods_id, name, evaluate_rank, user_id, content)
values
	(1000, '默认评价', 10, 1000, "五星好评!"),
	(1000, '默认评价', 9, 1001, "好评!");



-- 批量删除表
Select CONCAT( 'drop table ', table_name, ';' ) 
	FROM information_schema.tables 
	Where table_name LIKE 'goods_%';