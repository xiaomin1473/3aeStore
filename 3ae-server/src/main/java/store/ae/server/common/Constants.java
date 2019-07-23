package store.ae.server.common;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	/**
	 * 私有构造函数.
	 */
	private Constants() {

	}

	/**
	 * 声光报警器串口报文.
	 * 
	 * @author dgh
	 * @date 2018/12/19
	 */
	public class AcoustoOptic {

		/**
		 * 私有构造函数.
		 */
		private AcoustoOptic() {

		}

		/**
		 * 开启.0110001A0001028E19
		 */
		public static final String OPEN = "0110001A000101CE18";

		/**
		 * 关闭.
		 */
		public static final String CLOSE = "0110001A0001000FD8";
	}

	/**
	 * 告警恢复类型常量.
	 * 
	 * @author dgh
	 * @date 2019/6/9
	 */
	public class AlarmRestoreType {
		/**
		 * 私有构造函数.
		 */
		private AlarmRestoreType() {

		}

		/**
		 * 自动恢复.
		 */
		public static final int TYPE_1 = 1;

		/**
		 * 手动恢复.
		 */
		public static final int TYPE_2 = 2;

		/**
		 * 手动复位.
		 */
		public static final int TYPE_3 = 3;
	}

	/**
	 * 告警类型常量.
	 * 
	 * @author dgh
	 * @date 2018/10/23
	 */
	public class AlarmType {

		/**
		 * 私有构造函数.
		 */
		private AlarmType() {

		}

		/**
		 * 通信异常.
		 */
		public static final int TYPE_1 = 1;

		/**
		 * 火警.
		 */
		public static final int TYPE_2 = 2;

		/**
		 * 红外无视频.
		 */
		public static final int TYPE_3 = 3;

		/**
		 * 彩色无视频.
		 */
		public static final int TYPE_4 = 4;

		/**
		 * 串口通信故障.
		 */
		public static final int TYPE_5 = 5;

		/**
		 * CPU利用率超限告警.
		 */
		public static final int TYPE_6 = 6;

		/**
		 * 内存利用率超限告警.
		 */
		public static final int TYPE_7 = 7;

		/**
		 * 硬盘利用率超限告警.
		 */
		public static final int TYPE_8 = 8;

		/**
		 * 水平电机故障.
		 */
		public static final int TYPE_9 = 9;

		/**
		 * 垂直电机故障.
		 */
		public static final int TYPE_10 = 10;

		/**
		 * 地址无效故障.
		 */
		public static final int TYPE_11 = 11;

		/**
		 * 无发射器故障.
		 */
		public static final int TYPE_12 = 12;

		/**
		 * 发射器被遮挡.
		 */
		public static final int TYPE_13 = 13;

		/**
		 * 开阀失败故障.
		 */
		public static final int TYPE_14 = 14;

		/**
		 * 关阀失败故障.
		 */
		public static final int TYPE_15 = 15;

		/**
		 * 自动定位失败.
		 */
		public static final int TYPE_16 = 16;

		/**
		 * 炮体故障.
		 */
		public static final int TYPE_17 = 17;

		/**
		 * 故障.
		 */
		public static final int TYPE_18 = 18;

		/**
		 * 强制定位成功.
		 */
		public static final int TYPE_19 = 19;

		/**
		 * 自动定位成功.
		 */
		public static final int TYPE_20 = 20;

		/**
		 * 启泵成功.
		 */
		public static final int TYPE_21 = 21;

		/**
		 * 开阀成功.
		 */
		public static final int TYPE_22 = 22;

		/**
		 * 停泵成功.
		 */
		public static final int TYPE_23 = 23;

		/**
		 * 关阀成功.
		 */
		public static final int TYPE_24 = 24;

		/**
		 * 水流指示器开.
		 */
		public static final int TYPE_25 = 25;

		/**
		 * 水流指示器关.
		 */
		public static final int TYPE_26 = 26;

		/**
		 * 系统状态异常.
		 */
		public static final int TYPE_27 = 27;

		/**
		 * 光纤1断纤.
		 */
		public static final int TYPE_28 = 28;

		/**
		 * 光纤2断纤.
		 */
		public static final int TYPE_29 = 29;

		/**
		 * 光纤3断纤.
		 */
		public static final int TYPE_30 = 30;

		/**
		 * 光纤4断纤.
		 */
		public static final int TYPE_31 = 31;

		/**
		 * 通道1报警.
		 */
		public static final int TYPE_32 = 32;

		/**
		 * 通道2报警.
		 */
		public static final int TYPE_33 = 33;

		/**
		 * 通道3报警.
		 */
		public static final int TYPE_34 = 34;

		/**
		 * 通道4报警.
		 */
		public static final int TYPE_35 = 35;

		/**
		 * 区域预警报警.
		 */
		public static final int TYPE_36 = 36;

		/**
		 * 区域温升报警.
		 */
		public static final int TYPE_37 = 37;

		/**
		 * 区域尖峰报警.
		 */
		public static final int TYPE_38 = 38;
	}

	/**
	 * 备份目录.
	 * 
	 * @author dgh
	 * @date 2018/9/25
	 */
	public class BackUp {
		/**
		 * 私有构造函数.
		 */
		private BackUp() {

		}

		/**
		 * 告警导出目录.
		 */
		public static final String ALARM_DIR = "/backup/alarm/";

		/**
		 * 告警图片存储目录.
		 */
		public static final String ALARM_IMG_DIR = "/backup/img/alarm/";

		/**
		 * 数据库备份目录.
		 */
		public static final String DB_DIR = "/backup/db/";

		/**
		 * 拓扑背景图目录.
		 */
		public static final String TOPO_BG_DIR = "/assets/img/topo/bg/";
	}

	/**
	 * 命令.
	 * 
	 * @author dgh
	 * @date 2018/9/6
	 */
	public class Command {
		/**
		 * 私有构造函数.
		 */
		private Command() {

		}

		/**
		 * 控制/设置
		 */
		public static final int CMD_1 = 0x01;

		/**
		 * 上传
		 */
		public static final int CMD_2 = 0x02;

		/**
		 * 确认
		 */
		public static final int CMD_3 = 0x03;

		/**
		 * 查询
		 */
		public static final int CMD_4 = 0x04;

		/**
		 * 应答
		 */
		public static final int CMD_5 = 0x05;

		/**
		 * 否认
		 */
		public static final int CMD_6 = 0x06;

		/**
		 * 注册
		 */
		public static final int CMD_7 = 0x07;

		/**
		 * 初始化
		 */
		public static final int CMD_8 = 0x08;
	}

	/**
	 * 数据库操作常量.
	 */
	public class DB {

		/**
		 * 保存指定月数的数据库自动备份文件.
		 */
		public static final String BACKUP_MONTH = "BACKUP_MONTH";

		/**
		 * MYSQL安装目录.
		 */
		// public static final String MYSQL_HOME = "MYSQL_HOME";

		/**
		 * 是否启动自动备份 1启动 0不启动.
		 */
		public static final String MYSQL_AUTO_BACKUP = "MYSQL_AUTO_BACKUP";
	}

	/**
	 * 催款.
	 */
	public class Dept {

		/**
		 * 播放间隔(分钟)
		 */
		public static final String AUDIO_PEROID = "AUDIO_PEROID";

		/**
		 * 播放持续时间(秒)
		 */
		public static final String AUDIO_PLAYTIME = "AUDIO_PLAYTIME";
	}

	/**
	 * 参数1,设备配置的参数英文(系统启动时初始化)
	 */
	public static final List<String> devParamEns1 = new ArrayList<String>();

	/**
	 * 参数2,存到设备参数表的参数英文(系统启动时初始化)
	 */
	public static final List<String> devParamEns2 = new ArrayList<String>();

	/**
	 * 设备参数.
	 */
	public class DevParam {

		/**
		 * 私有构造函数.
		 */
		private DevParam() {
		}

		/**
		 * 参数1,设备配置的参数
		 * 
		 * @author dgh
		 * @date 2019/6/25
		 */
		public class Param1 {

			/**
			 * 私有构造函数.
			 */
			private Param1() {
			}

			/**
			 * 0:不激活 1:激活
			 */
			public static final String ACTIVE = "active";

			/**
			 * 通道
			 */
			public static final String CHANNEL = "channel";

			/**
			 * 测量时间
			 */
			public static final String EVENTTIME = "eventTime";

			/**
			 * 实时高温
			 */
			public static final String REALMAXT = "realMaxT";

			/**
			 * 实时温升
			 */
			public static final String REALRATET = "realRateT";

			/**
			 * 实时尖峰
			 */
			public static final String REALDEVIATIONT = "realDeviationT";

			/**
			 * 复位类型 1:自动复位 2:手动复位
			 */
			public static final String RESET = "reset";

			/**
			 * 自动复位时间(秒)
			 */
			public static final String RESETTIME = "resetTime";
		}

		/**
		 * 参数2,存到设备参数表的参数
		 * 
		 * @author dgh
		 * @date 2019/6/25
		 */
		public class Param2 {

			/**
			 * 私有构造函数.
			 */
			private Param2() {
			}

			/**
			 * 柱/雾状标志 0:柱状 1:雾状
			 */
			public static final String COLFOG = "colfog";

			/**
			 * 流量
			 */
			public static final String FLOW = "flow";

			/**
			 * 模式 1:纯手动模式 2:自动模式 3:手动模式
			 */
			public static final String MODEL = "model";

			/**
			 * 状态 0:断 1:通
			 */
			public static final String ONOFF = "onoff";

			/**
			 * 阀状态 0:阀关 1:阀开
			 */
			public static final String VALVE = "valve";

			/**
			 * 水流指示器标志 0:无水 1:有水
			 */
			public static final String WATER = "water";

			/**
			 * 水压
			 */
			public static final String WATERPRESSURE = "waterPressure";
		}
	}

	/**
	 * 设备类别.
	 * 
	 * @author dgh
	 * @date 2019/5/25
	 */
	public class DevKind {
		/**
		 * 私有构造函数.
		 */
		private DevKind() {

		}

		/**
		 * 服务器
		 */
		public static final int KIND_0 = 0;

		/**
		 * 主设备
		 */
		public static final int KIND_1 = 0x01;

		/**
		 * 开关量子设备
		 */
		public static final int KIND_2 = 0x02;

		/**
		 * CAN主机子设备
		 */
		public static final int KIND_3 = 0x03;

		/**
		 * 末端试水主机子设备
		 */
		public static final int KIND_4 = 0x04;

		/**
		 * 感温光纤区域
		 */
		public static final int KIND_5 = 0x05;
	}

	/**
	 * 设备类型.
	 * 
	 * @author dgh
	 * @date 2019/1/16
	 */
	public class DevType {
		/**
		 * 私有构造函数.
		 */
		private DevType() {

		}

		/**
		 * 图像探测器
		 */
		public static final int TYPE_1 = 0x01;

		/**
		 * 线型光束
		 */
		public static final int TYPE_2 = 0x02;

		/**
		 * 电控炮
		 */
		public static final int TYPE_3 = 0x03;

		/**
		 * 图像炮
		 */
		public static final int TYPE_4 = 0x04;

		/**
		 * 自动小炮
		 */
		public static final int TYPE_5 = 0x05;

		/**
		 * 自动大炮
		 */
		public static final int TYPE_6 = 0x06;

		/**
		 * 开关量模块
		 */
		public static final int TYPE_7 = 0x07;

		/**
		 * 末端试水主机
		 */
		public static final int TYPE_8 = 0x08;

		/**
		 * 末端探测器
		 */
		public static final int TYPE_9 = 0x09;

		/**
		 * CAN主机
		 */
		public static final int TYPE_10 = 0x0A;

		/**
		 * 感温光纤主机
		 */
		public static final int TYPE_11 = 0x0B;

		/**
		 * 启泵
		 */
		public static final int TYPE_101 = 0x65;

		/**
		 * 火警输出
		 */
		public static final int TYPE_102 = 0x66;

		/**
		 * 故障输出
		 */
		public static final int TYPE_103 = 0x67;

		/**
		 * 停泵
		 */
		public static final int TYPE_104 = 0x68;

		/**
		 * CAN主机子电控炮
		 */
		public static final int TYPE_203 = 0xCB;

		/**
		 * CAN主机子图像炮
		 */
		public static final int TYPE_204 = 0xCC;

		/**
		 * CAN主机子自动小炮
		 */
		public static final int TYPE_205 = 0xCD;

		/**
		 * CAN主机子自动大炮
		 */
		public static final int TYPE_206 = 0xCE;

		/**
		 * 末端试水主机末端试水装置
		 */
		public static final int TYPE_301 = 0x12D;

		/**
		 * 感温光纤主机感温光纤区域
		 */
		public static final int TYPE_401 = 0x191;
	}

	/**
	 * 开关量模块接口类型.
	 * 
	 * @author dgh
	 * @date 2019/1/25
	 */
	public class IOType {

		/**
		 * 私有构造函数.
		 */
		private IOType() {

		}

		/**
		 * 输入设备.
		 */
		public static final int TYPE_1 = 1;

		/**
		 * 输出设备
		 */
		public static final int TYPE_2 = 2;
	}

	/**
	 * 类型标志.
	 * 
	 * @author dgh
	 * @date 2019/1/21
	 */
	public class ObjType {
		/**
		 * 私有构造函数.
		 */
		private ObjType() {

		}

		/**
		 * 消防设施运行状态
		 */
		public static final int TYPE_3 = 0x03;

		/**
		 * 报警图片
		 */
		public static final int TYPE_4 = 0x04;

		/**
		 * 电机
		 */
		public static final int TYPE_12 = 0x0C;

		/**
		 * 消防设施启动定位
		 */
		public static final int TYPE_13 = 0x0D;

		/**
		 * 模式
		 */
		public static final int TYPE_14 = 0x0E;

		/**
		 * 远程升级
		 */
		public static final int TYPE_30 = 0x1E;

		/**
		 * 自检
		 */
		public static final int TYPE_31 = 0x1F;

		/**
		 * 开关量输出
		 */
		public static final int TYPE_33 = 0x21;

		/**
		 * 发射器参数
		 */
		public static final int TYPE_36 = 0x24;
	}

	/**
	 * 操作日志类型.
	 * 
	 * @author dgh
	 *
	 */
	public class OperateLogType {
		/**
		 * 私有构造函数.
		 */
		private OperateLogType() {

		}

		/**
		 * 增加.
		 */
		public static final int ADD = 1;
		/**
		 * 删除.
		 */
		public static final int DELETE = 2;
		/**
		 * 修改.
		 */
		public static final int UPDATE = 3;
		/**
		 * 查询.
		 */
		public static final int QUERY = 4;
		/**
		 * 导出.
		 */
		public static final int EXPORT = 5;
		/**
		 * 备份.
		 */
		public static final int BACKUP = 6;
		/**
		 * 恢复.
		 */
		public static final int RESTORE = 7;
		/**
		 * 查看.
		 */
		public static final int LOOK = 8;
		/**
		 * 导入.
		 */
		public static final int IMPORT = 9;

		/**
		 * 复位.
		 */
		public static final int RESET = 10;

		/**
		 * 重启.
		 */
		public static final int RESTART = 11;

		/**
		 * 参数设置.
		 */
		public static final int SETTING = 12;

		/**
		 * 屏蔽设备.
		 */
		public static final int SHIELD = 13;

		/**
		 * 解屏蔽设备.
		 */
		public static final int RELIEVESHIELD = 14;

		/**
		 * 同步.
		 */
		public static final int SYNC = 15;
	}

	/**
	 * 属性文件配置内容.
	 */
	public class Property {

		/**
		 * 导出excel条目数限制.
		 */
		public static final String EXPORT_MAX_NUM = "EXPORT_MAX_NUM";

		/**
		 * 最大线程数.
		 */
		public static final String MAX_THREAD_NUM = "MAX_THREAD_NUM";

		/**
		 * ModbusTCP端口
		 */
		public static final String MODBUSTCP_PORT = "MODBUSTCP_PORT";

		/**
		 * 服务端监听端口
		 */
		public static final String SERVER_PORT = "SERVER_PORT";
	}

	/**
	 * 角色.
	 * 
	 * @author dgh
	 * @date 2019/5/14
	 */
	public class Role {
		/**
		 * 私有构造函数.
		 */
		private Role() {
		}

		/**
		 * 操作员.
		 */
		public static final int OPERATOR = 1;
	}

	/**
	 * 存储在session里的key值.
	 * 
	 * @author dgh
	 * @date 2018/9/25
	 */
	public class SessionKey {

		/**
		 * 私有构造函数.
		 */
		private SessionKey() {

		}

		/**
		 * 操作员姓名.
		 */
		public static final String OPERATOR = "operator";

		/**
		 * 角色.
		 */
		public static final String ROLE = "role";

		/**
		 * 1:进入操作员界面 2:进入用户界面
		 */
		public static final String SUB = "sub";

		/**
		 * 用户名.
		 */
		public static final String USERNAME = "userName";

		/**
		 * 访问日志id.
		 */
		public static final String VISITLOGID = "visitId";
	}

	/**
	 * 服务器信息
	 * 
	 * @author dgh
	 * @date 2019/6/2
	 */
	public class Server {

		/**
		 * 私有构造函数.
		 */
		private Server() {

		}

		/**
		 * 服务器设备编号.
		 */
		public static final int ID = 1;

		/**
		 * 设备类型.
		 */
		public static final int DEVTYPE = 0;

		/**
		 * 服务器设备IP.
		 */
		public static final String IP = "0.0.0.0";

		/**
		 * 服务器设备名称.
		 */
		public static final String NAME = "服务器";
	}

	/**
	 * WebSocket消息常量
	 * 
	 * @author dgh
	 * @date 2018/10/18
	 */
	public class WebSocket {

		/**
		 * 私有构造函数.
		 */
		private WebSocket() {

		}

		/**
		 * 定时发送服务器时间.
		 */
		public static final int SERVERTIME = 1;

		/**
		 * 新增告警.
		 */
		public static final int ALARM_ADD = 2;

		/**
		 * 告警恢复.
		 */
		public static final int ALARM_RESTORE = 3;

		/**
		 * 声光告警.
		 */
		public static final int ACOUSTOOPTIC = 4;

		/**
		 * 设备参数变化
		 */
		public static final int PARAMCHANGE = 5;

		/**
		 * 过有效期,催款
		 */
		public static final int EXPIRE = 6;
	}
}
