package com.ae.web.api.user;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonParser;


public class login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理GET请求…………");
		JsonParser object = new JsonParser();
		Object nullObj = null;
	    try {
	        object.put("name", "login get");
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
	
	public static String ReadAsChars(HttpServletRequest request) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try{
			br = request.getReader();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if (null != br) {
				try{
					br.close();
				}                
				catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理POST请求…………");
		// PrintWriter out = response.getWriter();
		
		
		String data = ReadAsChars(request);
		// System.out.println(data);
		JSONObject jsonObject = new JSONObject(data);
		
		String name = jsonObject.getString("username");
		String pwd = jsonObject.getString("password");
		
		System.out.println(name);
		System.out.println(pwd);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
//		cookie.setMaxAge(600);
//		response.addCookie(cookie);
		response.getWriter().println("{" + 
				"\"roles\": \"['admin']\"," + 
				"\"token\": \"admin\"," + 
				"\"introduction\": \"I'm root!\"," + 
				"\"avatar\": \"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"," + 
				"\"name\": \"Super Admin\"" + 
				"}");
//		response.setContentType("text/html;charset=UTF-8");
//		out.println("<html><body><i>This is a POST request!</i><br><h1>hello servlet</h1>" +object.toString() + " </body></html>");
	}
}