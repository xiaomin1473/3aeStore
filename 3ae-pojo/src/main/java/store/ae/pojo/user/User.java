package store.ae.pojo.user;
/*package com.ae.pojo.user;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    
    @Column(nullable=false,length=20)
    private String user_name;
    
    @Column(nullable=false,length=20)
    private String user_pwd;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date user_create;

    @Temporal(TemporalType.TIMESTAMP)
    private Date user_modified;

    public User(int user_id, String user_name, String user_pwd, Date gmt_create, Date gmt_modified) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_create = gmt_create;
        this.user_modified = gmt_modified;
    }

    public User() {
        super();
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public Date getUser_create() {
		return user_create;
	}

	public void setUser_create(Date user_create) {
		this.user_create = user_create;
	}

	public Date getUser_modified() {
		return user_modified;
	}

	public void setGmt_modified(Date user_modified) {
		this.user_modified = user_modified;
	}

}
*/