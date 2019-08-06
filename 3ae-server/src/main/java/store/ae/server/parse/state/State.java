package store.ae.server.parse.state;

import store.ae.server.utils.DataUtil;

public class State extends BaseState{
	
	
	public void run() {
		// 运行状态
		int value = (obj[0] & 0xFF) | ((obj[1] & 0xFF) << 8);
		
		int v = DataUtil.getBit(value, 0);
		if (v == 1) {
			res.append("火警;");
		}
		
		v = DataUtil.getBit(value, 8);
	}
}
