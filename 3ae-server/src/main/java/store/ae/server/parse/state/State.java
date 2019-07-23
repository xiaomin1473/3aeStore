package store.ae.server.parse.state;

import store.ae.server.utils.DataUtil;

public class State extends BaseState{
	
	
	public void run() {
		// 运行状态
		int value = (obj[0] & 0xFF) | ((obj[1] & 0xFF) << 8);
		
		int v = DataUtil.getBit(value, 0);
		if (v == 1) {
			res.append("火警;");
			// 水平火源坐标
			int x = (obj[2] & 0xFF) | ((obj[3] & 0xFF) << 8);
			// 垂直火源坐标
			int y = (obj[4] & 0xFF) | ((obj[5] & 0xFF) << 8);
		}
		
		v = DataUtil.getBit(value, 8);
	}
}
