-- 使用数据库
drop database store_3ae_mall;
create database store_3ae_mall;
use store_3ae_mall;


-- 商品SPU
CREATE TABLE tb_goods (
`goods_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
`business_id` bigint NOT NULL COMMENT '运营ID',
`brand_id` bigint NOT NULL COMMENT '商品品牌',
`category_type` bigint NOT NULL COMMENT '商品类型',
`goods_name` varchar(120) NOT NULL COMMENT '商品名称',
`amount` bigint NOT NULL COMMENT '商品数量, SKU总和',
`unit` varchar(8) NOT NULL COMMENT '商品单位',
`price` decimal(8, 2) NOT NULL COMMENT '商品价格',
`volume` bigint NOT NULL COMMENT '商品成交量',
`img_url` varchar(120) NOT NULL COMMENT '商品图片',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_id(goods_id),
key idx_category_type(category_type),
key idx_brand_id(brand_id),
key idx_price(price),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品表(SPU)';

-- 初始化数据
insert into tb_goods(business_id, brand_id, category_type, goods_name, amount, unit, price, volume, img_url)
values
	(1000, 1000, 1010101, "vivo X23全息幻彩版 6GB+128GB 北极晨曦 水滴屏全面屏 游戏手机 移动联通电信全网通4G手机", 1000, '部', 2798, 9527, './assets/img/vivo.jpg;'),
	(1000, 1000, 1010101, "小米MIX2S 全面屏游戏拍照手机 6GB+128GB 黑色 骁龙845处理器 全网通4G 陶瓷手机", 1000, '部', 2699, 4681, './assets/img/xiaomi.jpg;'),
	(1000, 1000, 1010101, "联想Z5s 6GB+64GB 蜜恋橘 骁龙710 后置AI变焦三摄 6.3英寸水滴屏 靓彩渐变玻璃机身 全网通4G手机 双卡双待", 1000, '部', 1598, 3443, './assets/img/lenovo.jpg;'),
	(1000, 1000, 1010101, "Apple iPhone XS Max (A2103) 256GB 金色 全网通（移动4G优先版） 双卡双待", 1000, '部', 4800, 3756, './assets/img/iphonex.jpg;'),
	(1000, 1000, 1010101, "小米MIX2S 全面屏游戏拍照手机 6GB+128GB 黑色 骁龙845处理器 全网通4G 陶瓷手机", 1000, '部', 2699, 4681, './assets/img/xiaomi.jpg;'),
	(1000, 1000, 1010101, "联想Z5s 6GB+64GB 蜜恋橘 骁龙710 后置AI变焦三摄 6.3英寸水滴屏 靓彩渐变玻璃机身 全网通4G手机 双卡双待", 1000, '部', 1598, 3443, './assets/img/lenovo.jpg;'),
	(1000, 1000, 1010101, "Apple iPhone XS Max (A2103) 256GB 金色 全网通（移动4G优先版） 双卡双待", 1000, '部', 4800, 3756, './assets/img/iphonex.jpg;'),
	(1000, 1000, 1010101, "vivo X23全息幻彩版 6GB+128GB 北极晨曦 水滴屏全面屏 游戏手机 移动联通电信全网通4G手机", 1000, '部', 2798, 9527, './assets/img/vivo.jpg;'),
	(1000, 1000, 1010102, "东芝（TOSHIBA）65U6780C 65英寸 人工智能语音曲面4K超高清 2G+16G大内存液晶网络电视机", 1000, '部', 4999, 2527, './assets/img/toshibaTV.jpg;'),
	(1000, 1000, 1010102, "康佳LED55UC3 55英寸国品电视 曲面超薄电视 4K超高清8G内存 HDR人工智能液晶电视机(KONKA)", 1000, '台', 2499, 8386, './assets/img/konkaTV.jpg;'),
	(1000, 1000, 1010102, "三星（SAMSUNG）UA55NU7300JXXZ 55英寸曲面 4K HDR 超高清画质 电影模式 智能液晶电视 窄边框设计 黑色", 1000, '台', 5399, 4216, './assets/img/sumTV.jpg;'),
	(1000, 1000, 1010102, "东芝（TOSHIBA）65U6780C 65英寸 人工智能语音曲面4K超高清 2G+16G大内存液晶网络电视机", 1000, '台', 4999, 2527, './assets/img/toshibaTV.jpg;'),
	(1000, 1000, 1010102, "康佳LED55UC3 55英寸国品电视 曲面超薄电视 4K超高清8G内存 HDR人工智能液晶电视机(KONKA)", 1000, '台', 2499, 8386, './assets/img/konkaTV.jpg;'),
	(1000, 1000, 1010102, "三星（SAMSUNG）UA55NU7300JXXZ 55英寸曲面 4K HDR 超高清画质 电影模式 智能液晶电视 窄边框设计 黑色", 1000, '台', 5399, 4216, './assets/img/sumTV.jpg;'),
	(1000, 1000, 1010102, "东芝（TOSHIBA）65U6780C 65英寸 人工智能语音曲面4K超高清 2G+16G大内存液晶网络电视机", 1000, '台', 4999, 2527, './assets/img/toshibaTV.jpg;'),
	(1000, 1000, 1010102, "康佳LED55UC3 55英寸国品电视 曲面超薄电视 4K超高清8G内存 HDR人工智能液晶电视机(KONKA)", 1000, '台', 2499, 8386, './assets/img/konkaTV.jpg;'),
	(1000, 1000, 1010103, "方太（FOTILE）触控抽油烟机燃气灶具套装 9T欧式升级锁屏京东专供版 智能云魔方 EMD2T+HT8BE (天然气)", 1000, '台', 5690, 8386, './assets/img/fangtai.jpg;'),
	(1000, 1000, 1010103, "西门子（SIEMENS）侧吸抽油烟机 20大吸力触控智能联动 变频自清洁 新款LS68FK960W", 1000, '台', 5799, 7236, './assets/img/simenzi.jpg;');
	
	

-- 商品品牌
CREATE TABLE tb_goods_brand (
`brand_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品品牌ID',
`brand_name` varchar(32) NOT NULL COMMENT '品牌名称',
`brand_tips` varchar(32) NOT NULL COMMENT '品牌标识',
`img_url` varchar(120) NOT NULL COMMENT '品牌图片',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_brand_id(brand_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='品牌表';

-- 初始化数据
insert into tb_goods_brand(brand_name, brand_tips, img_url)
values
	('苹果', 'apple', './assets/brand/apple.png');


-- 商品图片
CREATE TABLE tb_goods_image (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`category_type` bigint NOT NULL COMMENT '商品类别',
`name` varchar(120) NOT NULL COMMENT '图片名称',
`number_info` tinyint NOT NULL COMMENT '图片数量',
`number_detail` tinyint NOT NULL COMMENT '详情图片数量',
`suffix_type` varchar(10) NOT NULL COMMENT '图片类型',
`urls_info` varchar(120) NOT NULL COMMENT '商品图片地址',
`urls_detail` varchar(120) NOT NULL COMMENT '商品详情图片地址',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_id(goods_id),
key idx_category_type(category_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 初始化数据
insert into tb_goods_image(goods_id, category_type, name, number_info, number_detail, suffix_type, urls_info, urls_detail)
values
	(1000, 1010101, 'iphone6 plus', 1, 1, 'png', './assets/img/iphone.png;', './assets/img/iphone.png;');


-- 商品类目
CREATE TABLE tb_goods_category (
`category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
`category_name` varchar(32) NOT NULL COMMENT '类型名称',
`category_type` bigint NOT NULL COMMENT '分类',
`grade_type` bigint NOT NULL COMMENT '分类等级',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_category_id(category_id),
key idx_category_type(category_type),
key idx_grade_type(grade_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- 初始化数据
insert into tb_goods_category(category_name, category_type, grade_type)
values
	('京东自营', 1010000, 1000000),
	('电子', 1010100, 1010000),
	('手机', 1010101, 1010100),
	('数码', 1010103, 1010100),
	('相机', 1010104, 1010100);


-- 商品列表SKU
CREATE TABLE tb_goods_list (
`goods_sku_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'skuID',
`goods_id` bigint NOT NULL COMMENT '商品ID',
`category_type` bigint NOT NULL COMMENT '分类',
`name` varchar(64) NOT NULL COMMENT '商品名称',
`color` varchar(64) NOT NULL COMMENT '商品颜色',
`model` varchar(64) NOT NULL COMMENT '商品型号',
`format` varchar(64) NOT NULL COMMENT '商品规格',
`param` varchar(64) NOT NULL COMMENT '商品参数',
`props` varchar(64) NOT NULL COMMENT '商品属性',
`weight` varchar(64) NOT NULL COMMENT '商品重量',
`img_url` varchar(120) NOT NULL COMMENT '商品图片',
`market` decimal(8, 2) NOT NULL COMMENT '商品市场价',
`mall` decimal(8, 2) NOT NULL COMMENT '商品商城价',
`number` int NOT NULL COMMENT '商品库存',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_sku_id(goods_sku_id),
key idx_goods_id(goods_id),
key idx_category_type(category_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品列表SKU';

-- 初始化数据
insert into tb_goods_list(goods_id, category_type, name, color, model, format, param, props, weight, img_url, market, mall, number)
values
	(1000, 1010101, 'iphone6 plus', '土豪金', 'plus', '无', '无', '无', '净重：100g', './assets/img/iphone.png;', 5000, 3000, 1000);


-- 商品详情
CREATE TABLE tb_goods_detail (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`category_type` bigint NOT NULL COMMENT '分类',
`goods_name` varchar(120) NOT NULL COMMENT '商品名称',
`detail` text(300) NOT NULL COMMENT '商品详情',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_id(goods_id),
key idx_category_type(category_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情表';

-- 初始化数据
insert into tb_goods_detail(goods_id, category_type, goods_name, detail)
values
	(1000, 1010101, 'iphone6 plus', '暂无');


-- 商品评价
CREATE TABLE tb_goods_evaluate (
`goods_id` bigint NOT NULL COMMENT '商品ID',
`user_id` bigint NOT NULL COMMENT '评价用户ID',
`user_name` varchar(32) NOT NULL COMMENT '评价用户名称',
`category_type` bigint NOT NULL COMMENT '分类',
`evaluate_name` varchar(120) NOT NULL COMMENT '评价名称',
`evaluate_rank` tinyint NOT NULL COMMENT '评价分0~10共四级: 0~2不满意 3~5一般 6~8满意 9~10喜欢',
`content` text(300) NOT NULL COMMENT '评价内容',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_goods_id(goods_id),
key idx_user_id(user_id),
key idx_category_type(category_type),
key idx_evaluate_rank(evaluate_rank),
key idx_create_time(gmt_create)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户评价表';

-- 初始化数据
insert into tb_goods_evaluate(goods_id, user_id, user_name, category_type, evaluate_name, evaluate_rank, content)
values
	(1000, 1000, 'xiaomin1473', 1010101, '默认评价', 10,  "五星好评!"),
	(1001, 1000, 'xiaomin1473', 1010101, '默认评价', 9, "好评!");

 

-- 批量删除表
Select CONCAT( 'drop table ', table_name, ';' ) 
	FROM information_schema.tables 
	Where table_name LIKE 'tb_goods_%';