CREATE TABLE tb_user (
`user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`user_group_id` bigint NOT NULL COMMENT '用户组ID',
`user_name` varchar(32) NOT NULL COMMENT '用户名称',
`user_pwd` varchar(64) NOT NULL COMMENT '用户密码',
`user_mark` varchar(120) NOT NULL COMMENT '用户标识',
`login_status` tinyint NOT NULL DEFAULT -1 COMMENT '登录状态 默认-1登录异常 0未登录 1已登录 2登录超时',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_user_id(user_id),
key idx_user_mark(user_mark),
key idx_user_name(user_name),
key idx_user_group_id(user_group_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 初始化数据 pwd = admin
-- mark标识：超级用户、超级角色、超级权限、超级时间、超级操作、备用
insert into tb_user(user_group_id, user_name, user_pwd, user_mark, login_status)
values
	(1000, 'root', '15ab525b4437e93aa2a618d700845d25', '1000-1000-1000-1000-1000-1000', 0);

CREATE TABLE tb_user_info (
`user_id` bigint NOT NULL COMMENT '用户ID',
`user_name` varchar(32) NOT NULL COMMENT '用户名称',
`user_phone` bigint NOT NULL COMMENT '用户手机号',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_user_id(user_id),
key idx_user_name(user_name),
key idx_user_phone(user_phone),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- mark标识：超级用户、超级角色、超级权限、超级时间、超级操作、备用
insert into tb_user_info(user_id, user_name, user_phone)
values
	(1000, '姜叶', '15732331321');

CREATE TABLE tb_user_group (
`user_group_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户组ID',
`user_group_name` varchar(120) NOT NULL COMMENT '用户组名称',
`role_id` bigint NOT NULL COMMENT '角色ID',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_user_group_id(user_group_id),
key idx_role_id(role_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- 初始化数据
insert into tb_user_group(user_group_name, role_id)
values
	('超级用户组', '1000');

CREATE TABLE tb_user_role (
`role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
`role_name` varchar(120) NOT NULL COMMENT '角色名称',
`role_mark` varchar(120) NOT NULL COMMENT '角色标识',
`role_group_id` bigint NOT NULL COMMENT '角色组id',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_role_id(role_id),
key idx_role_group_id(role_group_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 初始化数据
-- mark标识: 超级角色、超级业务、超级模块、备用、备用
insert into tb_user_role(role_name, role_mark, role_group_id)
values
	('超级角色', '1000-1000-1000-1000-1000-1000', '1000');

CREATE TABLE tb_user_role_group (
`role_group_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色组ID',
`role_group_name` varchar(120) NOT NULL COMMENT '角色组名称',
`serve_id`  bigint NOT NULL COMMENT '业务ID',
`permit_id` bigint NOT NULL COMMENT '权限ID',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_role_group_id(role_group_id),
key idx_permit_id(permit_id),
key idx_serve_id(serve_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='角色组表';

-- 初始化数据
insert into tb_user_role_group(role_group_name, serve_id, permit_id)
values
	('超级角色组', '1000', '1000');
	
CREATE TABLE tb_user_serve (
`serve_id` bigint NOT NULL AUTO_INCREMENT COMMENT '业务ID',
`serve_name` varchar(120) NOT NULL COMMENT '角色组名称',
`model` varchar(120) NOT NULL COMMENT '模块',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_serve_id(serve_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='业务部门表';

-- 初始化数据
insert into tb_user_serve(serve_name, model)
values
	('mall', 'goods');

CREATE TABLE tb_user_permit (
`permit_id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
`permit_name` varchar(120) NOT NULL COMMENT '权限名称',
`permit_mark` varchar(120) NOT NULL COMMENT '权限标识',
`permit_group_id` bigint NOT NULL COMMENT '权限组ID',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_permit_id(permit_id),
key idx_permit_group_id(permit_group_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 初始化数据
-- mark标识: 超级权限、超级数据操作、超级模块操作、超级页面操作、备用、备用
insert into tb_user_permit(permit_name, permit_mark, permit_group_id)
values
	('超级权限', '1000-1000-1000-1000-1000-1000', '1000');

CREATE TABLE tb_user_permit_group (
`permit_group_id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
`permit_group_name` varchar(120) NOT NULL COMMENT '权限名称',
`session_id` bigint NOT NULL COMMENT '会话ID',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_permit_group_id(permit_group_id),
key idx_session_id(session_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 初始化数据
insert into tb_user_permit_group(permit_group_name, session_id)
values
	('超级权限', '1000');

CREATE TABLE tb_user_session (
`session_id` bigint NOT NULL AUTO_INCREMENT COMMENT '会话ID',
`session_name` varchar(120) NOT NULL COMMENT '会话名称',
`session_level` bigint NOT NULL COMMENT '会话等级',
`session_time` varchar(120) NOT NULL COMMENT '会话时间',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_session_id(session_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='会话表';

-- 初始化数据
insert into tb_user_session(session_name, session_level, session_time)
values
	('超级会话', '0', '0');



-- 批量删除表
Select CONCAT( 'drop table ', table_name, ';' ) 
	FROM information_schema.tables 
	Where table_name LIKE 'tb_user_%';