package com.ae.pojo;

import java.sql.Date;

/**
 * @author sidtadpole
 *
 */
public class Message {
	public String name;
	
	public int id;
	
	public Date gmtCreate;
	
	public Date gmtModified;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
