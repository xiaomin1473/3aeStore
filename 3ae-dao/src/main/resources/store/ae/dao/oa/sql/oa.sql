drop database if exists `com_njrs_oa`;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `com_njrs_oa`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `com_njrs_oa`;

CREATE TABLE tb_user (
`user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`user_group_id` bigint NOT NULL COMMENT '用户组ID',
`user_name` varchar(32) NOT NULL COMMENT '用户名称',
`user_pwd` varchar(64) NOT NULL COMMENT '用户密码',
`user_mark` varchar(120) NOT NULL COMMENT '用户标识',
`user_permit` bigint NOT NULL COMMENT '用户权限',
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
insert into tb_user(user_group_id, user_name, user_pwd, user_mark, user_permit, login_status)
values
	(1000, 'root', '15ab525b4437e93aa2a618d700845d25', '1000-1000-1000-1000-1000-1000', 0, 0),
	(1001, 'caiwu', '15ab525b4437e93aa2a618d700845d25', '1000-1000-1000-1000-1000-1000', 1040000, 0),
	(1002, 'wenyuan', '15ab525b4437e93aa2a618d700845d25', '1000-1000-1000-1000-1000-1000', 1030000, 0);

CREATE TABLE tb_user_group (
`user_group_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户组ID',
`user_group_name` varchar(120) NOT NULL COMMENT '用户组名称',
`role_group_id` bigint NOT NULL COMMENT '角色ID',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_user_group_id(user_group_id),
key idx_role_group_id(role_group_id),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- 初始化数据
insert into tb_user_group(user_group_name, role_group_id)
values
	('超级用户组', 1000),
	('管理组', 1001),
	('文员组', 1002),
	('财务组', 1003),
	('审核组', 1004);
	
CREATE TABLE tb_user_power (
`user_power_id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
`user_power_name` varchar(120) NOT NULL COMMENT '权限名称',
`user_permit` varchar(120) NOT NULL COMMENT '用户权限',
`level` bigint NOT NULL COMMENT '级别',
`pid` bigint NOT NULL COMMENT '父级ID',
`path` varchar(120) COMMENT '路由',
`img` varchar(120) COMMENT '缩略图',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_user_power_id(user_power_id),
key idx_user_power_name(user_power_name),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 初始化数据
-- mark标识: 超级角色、超级业务、超级模块、备用、备用
insert into tb_user_power(user_power_name, user_permit, level, pid, path, img)
values
	('root', 0, 0, 0 , 'index', ''),
	('账号管理', 1000, 0, 0, 'admin/user', ''),
	('权限管理', 1000, 1, 1000, 'admin/power', ''),
	('运营中心', 1040000, 1, 0, 'operate', ''),
	('研发中心', 1030000, 1, 0, 'development', ''),
	('制造中心', 1020000, 1, 0, 'manufacture', ''),
	('营销中心', 1010000, 1, 0, 'market', ''),
	('数据备份', 1001, 2, 1000, 'database', ''),
	('清单列表', 1001, 2, 1000, 'list', '');


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
	('超级角色', '1000-1000-1000-1000-1000-1000', 1000);

CREATE TABLE tb_user_role_group (
`role_group_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色组ID',
`role_group_name` varchar(120) NOT NULL COMMENT '角色组名称',
`department_type`  bigint NOT NULL COMMENT '部门类别',
`permit_group_id` bigint NOT NULL COMMENT '权限组',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_role_group_id(role_group_id),
key idx_permit_group_id(permit_group_id),
key idx_department_type(department_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='角色组表';

-- 初始化数据
insert into tb_user_role_group(role_group_name, department_type, permit_group_id)
values
	('超级角色组', 1000, 1000);


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


CREATE TABLE tb_user_log (
`user_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`log_user` varchar(32) NOT NULL COMMENT '操作用户',
`log_message` varchar(64) NOT NULL COMMENT '操作内容',
`log_status` tinyint NOT NULL DEFAULT -1 COMMENT '操作状态 默认-1操作异常 0未操作 1已操作 2操作超时',
`log_result` tinyint NOT NULL DEFAULT -1 COMMENT '操作结果 默认-1操作异常 0已取消 1已拒绝 2已完成',
`result_user` varchar(32) NOT NULL COMMENT '反馈用户',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_user_log_id(user_log_id),
key idx_log_user(log_user),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户操作记录表';

-- mark标识：超级用户、超级角色、超级权限、超级时间、超级操作、备用
insert into tb_user_log(log_user, log_message, log_status, log_result, result_user)
values
	('姜叶', '报销出差住宿费用', 0, 0, '总经理');


CREATE TABLE tb_expenses_apply (
`expenses_id` bigint NOT NULL AUTO_INCREMENT COMMENT '序号ID',
`identifier` varchar(32) NOT NULL COMMENT '费用申请编号',
`expenses_gmt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '费用申请时间',
`matter` varchar(64) NOT NULL COMMENT '报支事项',
`amount` decimal(12, 2) NOT NULL COMMENT '金额',
`handler` varchar(32) COMMENT '经办人',
`ascriptor` varchar(32) COMMENT '归属人',
`expenses_type` varchar(32) COMMENT '费用分类',
`department_type` varchar(32) COMMENT '部门类别',
`receive_company` varchar(32) COMMENT '收款单位',
`ascription` varchar(32) COMMENT '归属类别',
`project_num` varchar(32) COMMENT '项目编号',
`project_name` varchar(32) COMMENT '项目名称',
`class_type` varchar(32) COMMENT '分类标识',
`apply_status` tinyint NOT NULL DEFAULT -1 COMMENT '默认-1数据异常 0待提交 1待通过 2未通过 3已完成',
`remark` varchar(240) COMMENT '备注',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_expenses_id(expenses_id),
key idx_department_type(department_type),
key idx_identifier(identifier),
key idx_project_num(project_num),
key idx_expenses_type(expenses_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='费用申请表';

-- 初始化数据
insert into tb_expenses_apply(identifier, expenses_gmt, matter, amount, handler, ascriptor, expenses_type, department_type, receive_company, ascription, project_num, project_name, class_type, apply_status, remark)
values
	('YX19010001', '2019-1-3', '中标服务费', '21300.00', '王国庆', '孙继先', '投标费用', 1010100, '国电物资东北（沈阳）配送有限公司', 'YX-招投标费用', '无', '国电哈尔滨热电有限公司防爆型消防炮的采购', '参加考核', 0, '无');


CREATE TABLE tb_expenses_verify (
`verify_id` bigint NOT NULL AUTO_INCREMENT COMMENT '审核ID',
`identifier` varchar(32) NOT NULL COMMENT '费用申请编号',
`text_one` varchar(240) COMMENT '增加条目1',
`text_two` varchar(240)  COMMENT '增加条目2',
`handler` varchar(32)  COMMENT '审核经办人',
`verify_status` tinyint NOT NULL DEFAULT -1 COMMENT '默认-1数据异常 0待提交 1待付款 2未付款 3已完成',
`remark` varchar(240) COMMENT '备注',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_verify_id(verify_id),
key idx_identifier(identifier),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='费用审核表';

-- 初始化数据
insert into tb_expenses_verify(identifier, text_one, text_two, handler, verify_status, remark)
values
	('YX19010001', '…………', '…………', '姜叶', 0, '无');


CREATE TABLE tb_expenses_payment (
`payment_id` bigint NOT NULL AUTO_INCREMENT COMMENT '支付ID',
`identifier` varchar(32) NOT NULL COMMENT '费用编号',
`payment_type` varchar(8) NOT NULL COMMENT '支付方式',
`payment_bank` varchar(16) NOT NULL COMMENT '银行账户',
`amount` decimal(12, 2) NOT NULL COMMENT '金额',
`voucher` bigint COMMENT '凭证号',
`handler` varchar(32) COMMENT '付款经办人',
`remark` varchar(240) COMMENT '备注',
`payment_gmt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '付款日期',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_payment_id(payment_id),
key idx_identifier(identifier),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='费用支付表'; 


-- 初始化数据
insert into tb_expenses_payment(identifier, payment_type, payment_bank, amount, voucher, handler, payment_gmt, remark)
values
	('YX19010001', '网银', '工行', 21300.00, 325551420, '姜叶', '2019-1-3', '无');

	

CREATE TABLE tb_department (
`department_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门分类ID',
`department_name` varchar(32) NOT NULL COMMENT '类型名称',
`department_type` bigint NOT NULL COMMENT '分类',
`grade_type` bigint NOT NULL COMMENT '分类等级',
`gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY pk_department_id(department_id),
key idx_department_type(department_type),
key idx_grade_type(grade_type),
key idx_create_time(gmt_create)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='部门分类表';


-- 初始化数据(公司-中心-部门-分类)
insert into tb_department(department_name, department_type, grade_type)
values
	('南京睿实消防安全设备有限公司', 1000000, 0),
	('南京睿盛智能科技有限公司', 2000000, 0),
	('营销中心', 1010000, 1000000),
	('销售部', 1010100, 1010000),
	('市场部', 1010200, 1010000),
	('制造中心', 1020000, 1000000),
	('采购部', 1020100, 1040000),
	('生产部', 1020200, 1000000),
	('其他', 1020300, 1000000),
	('研发中心', 1030000, 1000000),
	('研发部', 1030100, 1030000),
	('运营中心', 1040000, 1000000),
	('总经办', 1040100, 1040000),
	('综合管理部', 1040200, 1040000),
	('财务部', 1040300, 1040000),
	('法务部', 1040400, 1040000),
	('商务部', 1040500, 1040000),
	('生管部', 1040600, 1040000);

	