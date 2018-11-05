package com.ae.dao.init;

import org.apache.ibatis.annotations.Param;

public interface MessageDao {

	/**
     * 获得当前数据库的名字
     * @return
     */
	String getCurDataBaseName();
	
	
	/**
     * 从指定数据库中，查询是否存在某张表
     * @param dataBaseName
     * @param tableName
     * @return
     */
	String isTargetTableExistInDB(@Param("dataBaseName") String dataBaseName, 
            @Param("tableName") String tableName);
	
	
	/**
     * 根据传入的表明，创建新的表
     * @param newTableName
     */
	public String createNewTable(@Param("newTableName") String newTableName);
}
