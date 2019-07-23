package store.ae.server.parse.state;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import store.ae.server.common.Constants;

public class BaseState {
	/**
	 * 实例化日志对象.
	 */
	protected static final Logger logger = LoggerFactory.getLogger(BaseState.class);

	/**
	 * 通信IP.
	 */
	protected String devIp;

	/**
	 * 设备类型.
	 */
	protected int devType;

	/**
	 * 信息对象.
	 */
	protected byte[] obj;

	/**
	 * 返回解析信息
	 */
	protected StringBuffer res = new StringBuffer();

	/**
	 * 状态名称
	 */
	public static Map<String, String> stateName = new HashMap<String, String>();
	
	
	/**
	 * 状态值对应的中文
	 */
	public static Map<String, String[]> stateZH = new HashMap<String, String[]>();

	static {
		// 通道
		stateName.put(Constants.DevParam.Param1.CHANNEL, "通道:");
		// 测量时间
		stateName.put(Constants.DevParam.Param1.EVENTTIME, "测量时间:");
		// 实时尖峰
		stateName.put(Constants.DevParam.Param1.REALDEVIATIONT, "实时尖峰(°C):");
		// 实时高温
		stateName.put(Constants.DevParam.Param1.REALMAXT, "实时高温(°C):");
		// 实时温升
		stateName.put(Constants.DevParam.Param1.REALRATET, "实时温升(°C):");
		// 自动复位时间
		stateName.put(Constants.DevParam.Param1.RESETTIME, "复位时间(秒):");

		// 0:不激活 1:已激活
		stateZH.put(Constants.DevParam.Param1.ACTIVE, new String[] { "不激活", "已激活" });
		// 通道 CH1(光纤1) CH2(光纤2) CH3(光纤3) CH4(光纤4)
		stateZH.put(Constants.DevParam.Param1.CHANNEL,
				new String[] { "错误值", "CH1(光纤1)", "CH2(光纤2)", "CH3(光纤3)", "CH4(光纤4)" });
		// 柱/雾状标志 0:柱状 1:雾状
		stateZH.put(Constants.DevParam.Param2.COLFOG, new String[] { "柱状", "雾状" });
		// 模式 1:纯手动模式 2:自动模式 3:手动模式
		stateZH.put(Constants.DevParam.Param2.MODEL, new String[] { "错误值", "纯手动模式", "自动模式", "手动模式" });
		// 状态 0:断 1:通
		stateZH.put(Constants.DevParam.Param2.ONOFF, new String[] { "断", "通" });
		// 复位类型 1:自动复位 2:手动复位
		stateZH.put(Constants.DevParam.Param1.RESET, new String[] { "错误值", "自动复位", "手动复位" });
		// 阀状态 0:阀关 1:阀开
		stateZH.put(Constants.DevParam.Param2.VALVE, new String[] { "阀关", "阀开" });
		// 水流指示器标志 0:无水 1:有水
		stateZH.put(Constants.DevParam.Param2.WATER, new String[] { "无水", "有水" });
	}
	
	
	/**
	 * 获取解析信息
	 * 
	 * @return 解析信息
	 */
	public String getRes() {
		if (res.length() == 0) {
			return "正常;";
		}
		return res.toString();
	}
	
	/**
	 * 设置参数.
	 * 
	 * @param devIp
	 *            设备IP
	 * @param devType
	 *            设备类型
	 * @param obj
	 *            信息对象
	 */
	public void setParams(String devIp, int devType, byte[] obj) {
		this.devIp = devIp;
		this.devType = devType;
		this.obj = obj;
	}
}
