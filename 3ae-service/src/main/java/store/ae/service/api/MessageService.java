package store.ae.service.api;

import java.sql.SQLException;
import java.util.List;

import store.ae.dao.init.MessageDao;
import store.ae.pojo.Message;

public class MessageService {
	public List<Message> queryMessageList(String command, String description) throws SQLException {
		
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
		
	}
}
