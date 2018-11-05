package com.ae.api.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ae.service.api.MessageService;
import com.google.gson.Gson;

/**
 * @author sidtadpole
 *
 */
@SuppressWarnings("serial")
public class message extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理GET请求…………");

		MessageService messageList = new MessageService();
		
		Gson gson = new Gson();
		String json;
		try {
			json = gson.toJson(messageList.queryMessageList("", ""));
			
			resp.setContentType("application/json");
		    resp.setCharacterEncoding("utf-8");
		    
		    resp.getWriter().print(json);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
