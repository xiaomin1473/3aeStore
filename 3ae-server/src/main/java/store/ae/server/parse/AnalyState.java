package store.ae.server.parse;

import store.ae.server.common.Constants;
import store.ae.server.common.ErrorCode;
import store.ae.server.parse.state.State;

public class AnalyState extends BaseParse {

	
	public int run() {
		try {
			// 命令上传/确认 查询/应答
			if (command != Constants.Command.CMD_2 && command != Constants.Command.CMD_5) {
				logger.error("不支持操作,消防设施运行状态,命令错误{},丢弃", command);
				return ErrorCode.PKG.COMMANDNOTSUPPORT;
			}
			if (obj.length != 6) {
				return ErrorCode.PKG.OBJINVALID;
			}
			// 状态解析类
			// 状态解析类
			State state = null;
			if (devType == Constants.DevType.TYPE_1) {
				// 图像型火灾探测器运行状态解析
				state = new State();
			}
			if (state == null) {
				logger.error("没有解析类");
			}
			
			state.setParams(devIp, devType, obj);
			state.run();
			
			if (command == Constants.Command.CMD_2) {
				// 上传命令需要回复确认
				sendVoid(devIp, pkgSN, Constants.Command.CMD_3, 3, devType, null);
				logger.info("{}状态上传:{}", devIp, state.getRes());
			} else {
				// 信息对象
				//setResponse(state.getRes());
				logger.info("{}状态查询:{}", devIp, state.getRes());
			}
			
			
			return ErrorCode.PKG.SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ErrorCode.PKG.IGNORE;
		}
	}
}
