-- 使用数据库
use store_3ae_mall;


-- 商品SPU
CREATE TABLE tb_goods (
`goods_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
`category` bigint NOT NULL COMMENT '商品类目',
`brand_id` bigint NOT NULL COMMENT '商品品牌',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`props` varchar(120) NOT NULL COMMENT '商品属性',
`business_id` bigint NOT NULL COMMENT '运营属性',
`number` bigint NOT NULL COMMENT '商品数量, SKU总和',
`unit` varchar(3) NOT NULL COMMENT '商品单位',
`price` decimal NOT NULL COMMENT '商品价格',
`img_url` varchar(120) NOT NULL COMMENT '商品图片',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_id(goods_id),
key idx_category(category),
key idx_brand_id(brand_id),
key idx_price(price),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品表(SPU)';

-- 初始化数据
insert into tb_goods(category, brand_id, name, props, business_id, number, unit, price, img_url)
values
	(1010101, 1000, 'iphone6 plus', '屏幕尺寸：720*576', 1000, 100, '部', 4000, './assests/img/iphone.png;');


-- 商品品牌
CREATE TABLE tb_goods_brand (
`brand_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品品牌ID',
`name` varchar(120) NOT NULL COMMENT '品牌名称',
`brand` varchar(120) NOT NULL COMMENT '品牌标识',
`img_url` varchar(120) NOT NULL COMMENT '品牌图片',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_brand_id(brand_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='品牌表';

-- 初始化数据
insert into tb_goods_brand(name, brand, img_url)
values
	('苹果', 'apple', './assets/brand/apple.png');


-- 商品图片
CREATE TABLE tb_goods_image (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`category` bigint NOT NULL COMMENT '商品类别',
`name` varchar(120) NOT NULL COMMENT '图片名称',
`number_info` int NOT NULL COMMENT '图片数量',
`number_detail` int NOT NULL COMMENT '详情图片数量',
`suffix_type` varchar(10) NOT NULL COMMENT '图片类型',
`urls_info` varchar(120) NOT NULL COMMENT '商品图片地址',
`urls_detail` varchar(120) NOT NULL COMMENT '商品详情图片地址',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_id(goods_id),
key idx_category(category),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 初始化数据
insert into tb_goods_image(goods_id, category, name, number_info, number_detail, suffix_type, urls_info, urls_detail)
values
	(1000, 1010101, 'iphone6 plus', 1, 1, 'png', './assests/img/iphone.png;', './assests/img/iphone.png;');


-- 商品类目
CREATE TABLE tb_goods_category (
`category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
`name` varchar(120) NOT NULL COMMENT '类型名称',
`category` bigint NOT NULL COMMENT '分类',
`grade_type` bigint NOT NULL COMMENT '分类等级',
`series_type` bigint NOT NULL COMMENT '系列',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_category_id(category_id),
key idx_category(category),
key idx_grade_type(grade_type),
key idx_series_type(series_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- 初始化数据
insert into tb_goods_category(name, category, grade_type, series_type)
values
	('手机', 1010101, 1010100, 1010000),
	('电子', 1010102, 1010100, 1010000),
	('数码', 1010103, 1010100, 1010000),
	('相机', 1010104, 1010100, 1010000);


-- 商品列表SKU
CREATE TABLE tb_goods_list (
`goods_sku_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'skuID',
`goods_id` bigint NOT NULL COMMENT '商品ID',
`category` bigint NOT NULL COMMENT '分类',
`name` varchar(64) NOT NULL COMMENT '商品名称',
`color` varchar(64) NOT NULL COMMENT '商品颜色',
`model` varchar(64) NOT NULL COMMENT '商品型号',
`format` varchar(64) NOT NULL COMMENT '商品规格',
`param` varchar(64) NOT NULL COMMENT '商品参数',
`props` varchar(64) NOT NULL COMMENT '商品属性',
`weight` varchar(64) NOT NULL COMMENT '商品重量',
`img_url` varchar(120) NOT NULL COMMENT '商品图片',
`market` decimal NOT NULL COMMENT '商品市场价',
`mall` decimal NOT NULL COMMENT '商品商城价',
`number` int NOT NULL COMMENT '商品库存',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_sku_id(goods_sku_id),
key idx_goods_id(goods_id),
key idx_category(category),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品列表SKU';

-- 初始化数据
insert into tb_goods_list(goods_id, category, name, color, model, format, param, props, weight, img_url, market, mall, number)
values
	(1000, 1010101, 'iphone6 plus', '土豪金', 'plus', '无', '无', '无', '净重：100g', './assests/img/iphone.png;', 5000, 3000, 1000);


-- 商品详情
CREATE TABLE tb_goods_detail (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`category` bigint NOT NULL COMMENT '分类',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`detail` text(300) NOT NULL COMMENT '商品详情',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_id(goods_id),
key idx_category(category),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品详情表';

-- 初始化数据
insert into tb_goods_detail(goods_id, category, name, detail)
values
	(1000, 1010101, 'iphone6 plus', '暂无');


-- 商品评价
CREATE TABLE tb_goods_evaluate (
`evaluate_id` bigint NOT NULL AUTO_INCREMENT COMMENT '评价ID',
`goods_id` bigint NOT NULL COMMENT '商品ID',
`category` bigint NOT NULL COMMENT '分类',
`name` varchar(120) NOT NULL COMMENT '评价名称',
`evaluate_rank` int NOT NULL COMMENT '评价等级',
`user_id` bigint NOT NULL COMMENT '评价用户',
`content` text(300) NOT NULL COMMENT '评价内容',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_evaluate_id(evaluate_id),
key idx_goods_id(goods_id),
key idx_category(category),
key idx_evaluate_rank(evaluate_rank),
key idx_user_id(user_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户评价表';

-- 初始化数据
insert into tb_goods_evaluate(goods_id, category, name, evaluate_rank, user_id, content)
values
	(1000, 1010101, '默认评价', 10, 1000, "五星好评!"),
	(1000, 1010101, '默认评价', 9, 1001, "好评!");

 

-- 批量删除表
Select CONCAT( 'drop table ', table_name, ';' ) 
	FROM information_schema.tables 
	Where table_name LIKE 'tb_goods_%';