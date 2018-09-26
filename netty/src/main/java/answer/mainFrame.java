package answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainFrame {
	@SuppressWarnings("unused")
	private static void start() {
		Server server = new Server(10010);
	}
	
	public static void main(String[] args){
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("server>");
		String m;
		while(true) {
			try {
				m = bf.readLine();
				
				switch (m) {
					case "start" : start(); break;
					case "exit" : return;
					default : System.out.println("你输入的是"+m);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
