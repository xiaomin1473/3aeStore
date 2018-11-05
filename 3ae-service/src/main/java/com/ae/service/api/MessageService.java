package com.ae.service.api;

import java.sql.SQLException;
import java.util.List;

import com.ae.dao.init.MessageDa;
import com.ae.pojo.Message;

public class MessageService {
	public List<Message> queryMessageList(String command, String description) throws SQLException {
		
		MessageDa messageDao = new MessageDa();
		return messageDao.queryMessageList(command, description);
		
	}
}
