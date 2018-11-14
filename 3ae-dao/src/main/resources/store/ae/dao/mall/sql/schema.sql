-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;

-- 使用数据库
use seckill;

CREATE TABLE feast_seckill (
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`start_time` timestamp NOT NULL COMMENT '秒杀开启时间',
`end_time` timestamp NOT NULL COMMENT '秒是结束时间',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 初始化数据
insert into feast_seckill(name, number, start_time, end_time)
values
	('1000元秒杀iphoneX', 100, '2018-11-11 00:00:00', '2018-11-12 00:00:00'),
	('1500元秒杀iphoneXs', 100, '2018-11-11 00:00:00', '2018-11-12 00:00:00'),
	('2000元秒杀iphoneX Plus', 100, '2018-11-11 00:00:00', '2018-11-12 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关信息
CREATE TABLE feast__seckill_success  (
`seckill_id` bigint NOT NULL COMMENT '秒杀商品ID',
`user_phone` bigint NOT NULL COMMENT '用户手机号',
`state` tinyint NOT NULL DEFAULT -1 COMMENT '-1无效 0成功 1已付款 2已发货 3已收货',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (seckill_id, user_phone), /* 联合主键 */
key idx_create_time(gmt_create)
)ENGINE=InnoDB CHARSET=utf8 COMMENT='秒杀成功明细表';
	
-- 连接数据库控制台
mysql -u root -p

show create table tablename\G

	