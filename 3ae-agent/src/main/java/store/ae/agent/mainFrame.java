package store.ae.agent;

import java.util.Scanner;


public class mainFrame {
	public static void main(String[] args) {  
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        Client bootstrap = new Client(10010, "localhost");
        
        String infoString = "I'm coming...";
        while (true){
        	infoString = input.nextLine();
        	Answer req = new Answer();  
            req.setType((byte) 2);
            req.setInfo(infoString);
            bootstrap.sendMessage(req);  
           
        }  
    }
}
