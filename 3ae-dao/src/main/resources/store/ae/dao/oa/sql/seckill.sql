-- 秒杀存储过程
-- 
DELIMITER $$  -- ; 转换为$$
-- 定义存储过程
-- 参数：in 输入参数; out 输出参数
-- row_count() 返回上一条修改类型sql(delete,insert,update)的影响行数
-- row_count() 0：未修改参数; >0：修改的行数; <0：修改错误/未执行修改sql
CREATE PROCEDURE `store_3ae_mall`.`execute_seckill`
	(in v_seckill_id bigint, in v_phone bigint,
		in v_kill_time timestamp, out r_result int)
	BEGIN
		DECLARE insert_count int DEFAULT 0;
		START TRANSACTION;
		insert ignore into feast_seckill_success
			(seckill_id, user_phone, gmt_create)
			values (v_seckill_id, v_phone, v_kill_time);
		select row_count() into insert_count;
		IF(insert_count = 0) THEN
			ROLLBACK;
			SET r_result = -1;
		ELSEIF(insert_count < 0) THEN
			ROLLBACK;
			SET r_result = -2;
		ELSE
			UPDATE feast_seckill
			set number = number - 1
			where seckill_id = v_seckill_id
				and end_time > v_kill_time
				and start_time < v_kill_time
				and number > 0;
			select row_count() into insert_count;
			IF(insert_count = 0 ) THEN
				ROLLBACK;
				set r_result = 0;
			ELSEIF (insert_count < 0) THEN
				ROLLBACK;
				set r_result = -2;
			ELSE
				COMMIT;
				set r_result = 1;
			END IF;
		END IF;
	END;
$$
-- 存储过程定义结束
drop procedure execute_seckill;

DELIMITER ;  -- $$ 转换为;
set @r_result=-3;
select @r_result; -- 查询变量

-- 执行存储过程
call execute_seckill(1002, 13131443455, now(), @r_result);

-- 获取结果
select @r_result;




-- 存储过程
-- 1.存储过程优化，事务行级锁持有时间
-- 2.不要过度依赖存储过程
-- 3.简单的逻辑，可以应用存储过程
-- 4.QPS一个秒杀单6000/QPS


