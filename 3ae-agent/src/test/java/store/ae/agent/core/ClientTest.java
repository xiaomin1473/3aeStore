package store.ae.agent.core;

import org.junit.Test;

class ClientTest {

	@Test
	void testClient() {
		Client bootstrap = new Client("localhost",8888);
		
		while (true) {
			bootstrap.sendMessage("hello");
		}
		
	}
}
