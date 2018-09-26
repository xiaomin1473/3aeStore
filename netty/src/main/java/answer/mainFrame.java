package answer;


public class mainFrame {
	
	public static void main(String[] args){
//		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("server>");
//		String m;
//		while(true) {
//			try {
//				m = bf.readLine();
//				
//				switch (m) {
//					case "start" : start(); break;
//					case "exit" : return;
//					default : System.out.println("你输入的是"+m);
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//Scanner input = new Scanner(System.in);
		@SuppressWarnings("unused")
		Server server = new Server(10010);
		//String infoString = "";
//        while (true){
//        	infoString = input.nextLine();
//        	answerInfo req = new answerInfo();  
//            req.setType((byte) 2);
//            req.setInfo(infoString);
//            server.sendMessage(req);  
//           
//        }  
	}
}
