package com.ae.web.api.portal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class jsonTest extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理GET请求…………");
		JSONObject object = new JSONObject();
		Object nullObj = null;
	    try {
	        object.put("name", "王小二");
	        object.put("age", 25.2);
	        object.put("birthday", "1990-01-01");
	        object.put("school", "蓝翔");
	        object.put("major", new String[] {"理发", "挖掘机"});
	        object.put("has_girlfriend", false);
	        object.put("car", nullObj);
	        object.put("house", nullObj);
	        object.put("comment", "这是一个注释");
	
	        System.out.println();
	
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
		
	    response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.getWriter().print(object.toString());
//		out.println();
//		response.setContentType("text/html;charset=UTF-8");
//		out.println("<html><body><i>This is a GET request!</i><br><h1>hello servlet</h1>" +object.toString() + " </body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest requse, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理POST请求…………");
		PrintWriter out = response.getWriter();
		
		JSONObject object = new JSONObject();
		Object nullObj = null;
	    try {
	        object.put("name", "王小二");
	        object.put("age", 25.2);
	        object.put("birthday", "1990-01-01");
	        object.put("school", "蓝翔");
	        object.put("major", new String[] {"理发", "挖掘机"});
	        object.put("has_girlfriend", false);
	        object.put("car", nullObj);
	        object.put("house", nullObj);
	        object.put("comment", "这是一个注释");
	
	        System.out.println();
	
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
		
		
		
		
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "include");
		out.println("json" + object.toString());
//		response.setContentType("text/html;charset=UTF-8");
//		out.println("<html><body><i>This is a POST request!</i><br><h1>hello servlet</h1>" +object.toString() + " </body></html>");

	}
}
