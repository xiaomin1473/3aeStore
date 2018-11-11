package store.ae.dao.init;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import store.ae.dao.common.Access;
import store.ae.pojo.Message;

public class MessageDao {
	public List<Message> queryMessageList(String command, String description) throws SQLException {
		Access dbAccess = new Access();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();


		try {
			sqlSession = dbAccess.getSqlSession();

			messageList = sqlSession.selectList("Message.queryMessageList");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			} else {
				System.out.println("sqlSession is null");
			}
		}

		return messageList;
	}
}