-- 使用数据库
use store_3ae_mall;

CREATE TABLE goods (
`goods_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
`class` bigint NOT NULL COMMENT '商品类别',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`unit` varchar(3) NOT NULL COMMENT '商品单位',
`price` decimal NOT NULL COMMENT '商品价格',
`img_url` varchar(120) NOT NULL COMMENT '商品图片',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (goods_id),
key idx_class(class),
key idx_price(price),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 初始化数据
insert into goods(class, name, number, unit, price, img_url)
values
	(10111100, 'iphone6 plus', 100, '部', 4000, './assests/img/iphone.png;');
	
CREATE TABLE goods_image (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`class` bigint NOT NULL COMMENT '商品类别',
`name` varchar(120) NOT NULL COMMENT '图片名称',
`number_info` int NOT NULL COMMENT '图片数量',
`number_detail` int NOT NULL COMMENT '详情图片数量',
`suffix_type` varchar(10) NOT NULL COMMENT '图片类型',
`urls_info` varchar(120) NOT NULL COMMENT '商品图片地址',
`urls_detail` varchar(120) NOT NULL COMMENT '商品详情图片地址',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (goods_id),
key idx_class(class),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 初始化数据
insert into goods_image(goods_id, class, name, number_info, number_detail, suffix_type, urls_info, urls_detail)
values
	(1000, 10111100, 'iphone6 plus', 1, 1, 'png', './assests/img/iphone.png;', './assests/img/iphone.png;');
	
CREATE TABLE goods_type (
`goods_type_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
`name` varchar(120) NOT NULL COMMENT '类型名称',
`class` bigint NOT NULL COMMENT '分类',
`grade` bigint NOT NULL COMMENT '分类等级',
`series` bigint NOT NULL COMMENT '等级系列',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (goods_type_id),
key idx_class(class),
key idx_grade(grade),
key idx_series(series),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- 初始化数据
insert into goods_type(name, class, grade, series)
values
	('手机', 10111100, 10111000, 10100000),
	('电子', 10111000, 10110000, 10100000),
	('数码', 10111200, 10111000, 10100000),
	('相机', 10111300, 10111000, 10100000);

CREATE TABLE goods_detail (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`class` bigint NOT NULL COMMENT '分类',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`detail` text(300) NOT NULL COMMENT '商品详情',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (goods_id),
key idx_class(class),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品详情表';

-- 初始化数据
insert into goods_detail(goods_id, class, name, detail)
values
	(1000, 10111300, 'iphone6 plus', '暂无');
	
CREATE TABLE goods_evaluate (
`evaluate_id` bigint NOT NULL AUTO_INCREMENT COMMENT '评价ID',
`goods_id` bigint NOT NULL COMMENT '商品ID',
`class` bigint NOT NULL COMMENT '分类',
`name` varchar(120) NOT NULL COMMENT '评价名称',
`evaluate_rank` int NOT NULL COMMENT '评价等级',
`user_id` bigint NOT NULL COMMENT '评价用户',
`content` text(300) NOT NULL COMMENT '评价内容',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (evaluate_id),
key idx_goods_id(goods_id),
key idx_class(class),
key idx_evaluate_rank(evaluate_rank),
key idx_user_id(user_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户评价表';

-- 初始化数据
insert into goods_evaluate(goods_id, class, name, evaluate_rank, user_id, content)
values
	(1000, 10111300, '默认评价', 10, 1000, "五星好评!"),
	(1000, 10111300, '默认评价', 9, 1001, "好评!");



-- 批量删除表
Select CONCAT( 'drop table ', table_name, ';' ) 
	FROM information_schema.tables 
	Where table_name LIKE 'goods_%';