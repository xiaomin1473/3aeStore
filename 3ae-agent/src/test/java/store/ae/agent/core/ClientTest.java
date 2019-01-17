package store.ae.agent.core;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testClient() {
		// 远程服务器
		//new Client("3ae.store", 47332);
		
		 new Client("localhost", 47332);
	}
}
