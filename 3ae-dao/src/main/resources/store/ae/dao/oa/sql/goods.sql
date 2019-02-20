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
	
	

-- 批量删除表
Select CONCAT( 'drop table ', table_name, ';' ) 
	FROM information_schema.tables 
	Where table_name LIKE 'tb_goods_%';