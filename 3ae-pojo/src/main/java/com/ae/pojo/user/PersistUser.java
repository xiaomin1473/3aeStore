package com.ae.pojo.user;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistUser {
	public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h-pojo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Date date = new Date();//获得系统时间.

		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		Timestamp time =Timestamp.valueOf(nowTime);

        User user = new User();
        user.setUser_name("xiaomin");
        user.setUser_pwd("123213");
        user.setUser_create(time);
        user.setGmt_modified(time);

        em.persist(user);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("All job done.");

    }
}
