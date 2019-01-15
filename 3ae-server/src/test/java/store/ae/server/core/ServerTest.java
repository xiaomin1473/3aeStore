package store.ae.server.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServerTest {
	
	@SuppressWarnings("unused")
	@Autowired
	private Server server;

	@Test
	public void testServer() {	
//		if( ParamEnums.PROMOTER != ParamEnums.TERMINATOR) {
//			System.out.println("info: ");
//		}
		new  Server(8888);
		
	}

}
