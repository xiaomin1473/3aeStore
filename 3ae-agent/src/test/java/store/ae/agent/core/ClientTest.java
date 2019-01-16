package store.ae.agent.core;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testClient() {
		new Client("localhost", 47332);
	}
}
