package com.ae.couplet.answer;

import java.util.Scanner;


public class Test1 {
	public static void main(String[] args) {  
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        Client bootstrap = new Client(10010, "47.104.66.44");
        
        String infoString = "I'm coming...";
        while (true){
        	infoString = input.nextLine();
        	answerInfo req = new answerInfo();  
            req.setType((byte) 2);
            req.setInfo(infoString);
            bootstrap.sendMessage(req);  
           
        }  
    }
}
