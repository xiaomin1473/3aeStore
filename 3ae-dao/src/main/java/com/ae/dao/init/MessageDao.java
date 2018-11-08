package com.ae.dao.init;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ae.dao.common.Access;
import com.ae.pojo.Message;

public class MessageDao {
	public List<Message> queryMessageList(String command, String description) throws SQLException {
		Access dbAccess = new Access();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();

		
		try {
			System.out.println("this is try");
			sqlSession = dbAccess.getSqlSession();
			
			messageList = sqlSession.selectList("Message.queryMessageList");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("this is catch");
		} finally {
			System.out.println("this is finally");
			if(sqlSession != null) {
				System.out.println("this is finally close");
				sqlSession.close();
			} else {
				System.out.println("sqlSession is null");
			}
			
		}
		
		return messageList;
	}
	
	public static void main(String[] args) throws SQLException {
		MessageDao initDBae = new MessageDao();

		initDBae.queryMessageList("", "");
	}
}
