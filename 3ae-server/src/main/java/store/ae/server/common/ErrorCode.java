package store.ae.server.common;

public class ErrorCode {

	/**
	 * 私有构造函数.
	 */
	private ErrorCode() {

	}

	/**
	 * 通用错误码.
	 * 
	 * @author dgh
	 * @date 2018/9/29
	 */
	public class Common {

		/**
		 * 私有构造函数.
		 */
		private Common() {

		}

		/**
		 * 操作失败,失败原因：数据库备份失败
		 */
		public static final String BACKUPDB = "操作失败,失败原因：数据库备份失败";

		/**
		 * 操作失败,失败原因：删除数据失败.
		 */
		public static final String DELETEDB = "操作失败,失败原因：删除数据失败";

		/**
		 * 操作失败,失败原因：设备不在线.
		 */
		public static final String DEV_IDLE = "操作失败,失败原因：设备不在线";

		/**
		 * 操作失败,失败原因：导出数据失败.
		 */
		public static final String EXPORT = "操作失败,失败原因：导出数据失败";

		/**
		 * 操作失败,失败原因：导出数据量大.
		 */
		public static final String EXPORT_LARGE_NUM = "操作失败,失败原因：导出数据量超过{0}条";

		/**
		 * 操作失败,失败原因：查询数据库失败.
		 */
		public static final String FINDDB = "操作失败,失败原因：查询数据库失败";

		/**
		 * 操作失败,失败原因：导入文件失败.
		 */
		public static final String IMPORT = "操作失败,失败原因：导入文件失败";

		/**
		 * 操作失败,失败原因：插入数据库失败.
		 */
		public static final String INSERTDB = "操作失败,失败原因：插入数据库失败";

		/**
		 * 操作失败,失败原因：没有要导出的数据.
		 */
		public static final String NODATATOEXPORT_ERROR = "操作失败,失败原因：没有要导出的数据";

		/**
		 * 操作失败,失败原因：旧密码不正确.
		 */
		public static final String OLDPASS = "操作失败,失败原因：旧密码不正确";

		/**
		 * 操作失败,失败原因：参数为空.
		 */
		public static final String PARAMNULL = "操作失败,失败原因：参数为空";

		/**
		 * 操作失败,失败原因：复位告警失败.
		 */
		public static final String RESETALARM = "操作失败,失败原因：复位告警失败";

		/**
		 * 操作失败,失败原因：数据库恢复失败.
		 */
		public static final String RESTOREDB = "操作失败,失败原因：数据库恢复失败";

		/**
		 * 该设备已被屏蔽,请在网络设备页面解屏蔽后,再操作.
		 */
		public static final String SHIELD = "该设备已被屏蔽,请在网络设备页面解屏蔽后,再操作";

		/**
		 * 操作成功.
		 */
		public static final String SUCCESS = "操作成功";

		/**
		 * 操作失败,失败原因：更新数据库失败.
		 */
		public static final String UPDATEDB = "操作失败,失败原因：更新数据库失败";
	}

	/**
	 * 报文错误码.
	 * 
	 * @author dgh
	 * @date 2018/9/5
	 */
	public class PKG {
		/**
		 * 私有构造函数.
		 */
		private PKG() {
		}

		/**
		 * 正常(没有错误发生)
		 */
		public static final int SUCCESS = 0x00;

		/**
		 * 校验和错误.(校验和失败)
		 */
		public static final int CHECK = 0x01;

		/**
		 * 不支持操作.(不支持指定的控制命令字节或应用数据单元类型)
		 */
		public static final int COMMANDNOTSUPPORT = 0x02;

		/**
		 * 执行错误.(接收方执行操作失败)
		 */
		public static final int EXCUTE = 0x03;

		/**
		 * 接收方忙.(接收方正在处理较耗时的操作，不能立即响应，发送方应等待一段时间后再次发送上次的命令)
		 */
		public static final int RECEIVEBUSY = 0x04;

		/**
		 * 应用数据单元长度不正确.(超过限定值(100*1024*1024))
		 */
		public static final int DATALENGTH = 0x05;

		/**
		 * 信息对象数目不正确.(信息对象数目与应用数据单元长度或实际信息数据不匹配)
		 */
		public static final int OBJNUM = 0x06;

		/**
		 * 设备类型不正确.(设备类型值与消防设施实际类型不匹配)
		 */
		public static final int DEVTYPE = 0x07;

		/**
		 * 信息对象数据无效.(应用数据单元的信息对象格式不正确或数值无效)
		 */
		public static final int OBJINVALID = 0x08;

		/**
		 * 操作失败,失败原因：设备不在线.
		 */
		public static final int DEV_IDLE = 0x09;

		/**
		 * 超时.
		 */
		public static final int TIMEOUT = 0x0A;

		/**
		 * 其他错误,忽略包.
		 */
		public static final int IGNORE = 0x0B;
	}

	/**
	 * 打印错误码.
	 * 
	 * @author dgh
	 * @date 2018/9/5
	 */
	public class Print {
		/**
		 * 私有构造函数.
		 */
		private Print() {
		}

		/**
		 * 正常(没有错误发生)
		 */
		public static final int SUCCESS = 0x00;

		/**
		 * 打印失败,请检查打印机
		 */
		public static final int FAILURE = 0x01;

		/**
		 * 没有发现配置的打印机设备
		 */
		public static final int NOTFOUN = 0x02;
	}

	/**
	 * 用户相关.
	 * 
	 * @author dgh
	 * @date 2018/9/29
	 */
	public class User {

		/**
		 * 私有构造函数.
		 */
		private User() {

		}

		/**
		 * 操作失败,失败原因：插入访问日志失败.
		 */
		public static final String INSERTVISITLOGERROR = "操作失败,失败原因：插入访问日志失败";

		/**
		 * 操作失败,失败原因：该用户已登录.
		 */
		public static final String LOGINED = "操作失败,失败原因：该用户已登录";

		/**
		 * 操作失败,失败原因：用户名或密码错误.
		 */
		public static final String USERNAMEORPASSWORDERROR = "操作失败,失败原因：用户名或密码错误";

		/**
		 * 操作失败,失败原因：用户不存在.
		 */
		public static final String USERNOTEXISTS = "操作失败,失败原因：用户不存在";
	}
}
