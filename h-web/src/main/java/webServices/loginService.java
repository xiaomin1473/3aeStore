package webServices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import blog.userService.login;

public class loginService extends login{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void logger() throws FileNotFoundException {
		
		System.setOut(new PrintStream(new File("./logs/outLog.txt")));
	    System.out.println("System.out.println******************");
	  }
}