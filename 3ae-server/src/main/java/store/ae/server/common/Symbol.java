package store.ae.server.common;

public final class Symbol {

	/**
	 * 私有构造函数.
	 */
	private Symbol() {

	}

	/**
	 * 列名与值间隔符.
	 */
	public static final String columnvaluesplit = "#1&";

	/**
	 * 列与列间隔符.
	 */
	public static final String columncolumnsplit = "#2&";

	/**
	 * 通用的符号.
	 * 
	 * @author dgh
	 * @date 2018/9/25
	 */
	public class Common {

		/**
		 * 私有构造函数.
		 */
		private Common() {

		}

		/**
		 * 大括号(左).
		 */
		public static final String BRACE_LEFT = "{";

		/**
		 * 大括号(右).
		 */
		public static final String BRACE_RIGHT = "}";

		/**
		 * 反斜杠.
		 */
		public static final String BACKSLASH = "\\";

		/**
		 * 冒号.
		 */
		public static final String COLON = ":";

		/**
		 * 逗号.
		 */
		public static final String COMMA = ",";

		/**
		 * 点.
		 */
		public static final String DOT = ".";

		/**
		 * 圆括号(左).
		 */
		public static final String PARENTHESE_LEFT = "(";

		/**
		 * 圆括号(右).
		 */
		public static final String PARENTHESE_RIGHT = ")";

		/**
		 * 加号.
		 */
		public static final String PLUS = "+";

		/**
		 * 分号.
		 */
		public static final String SEMICOLON = ";";

		/**
		 * 斜杠.
		 */
		public static final String SLASH = "/";

		/**
		 * 分割符.
		 */
		public static final String SPLIT = "-";

		/**
		 * 斜杠 /.
		 */
		public static final String SPRIT = "/";

		/**
		 * 下划线.
		 */
		public static final String UNDERLINE = "_";
	}

	/**
	 * 正则表达式用的符号.
	 * 
	 * @author dgh
	 * @date 2018/9/25
	 */
	public class Regex {

		/**
		 * 私有构造函数.
		 */
		private Regex() {

		}

		/**
		 * 大括号(左).
		 */
		public static final String BRACE_LEFT = "\\{";

		/**
		 * 大括号(右).
		 */
		public static final String BRACE_RIGHT = "\\}";

		/**
		 * 逗号.
		 */
		public static final String COMMA = "\\,";

		/**
		 * 点.
		 */
		public static final String DOT = "\\.";

		/**
		 * 双引号.
		 */
		public static final String QUOTES = "\"";

		/**
		 * 分割符.
		 */
		public static final String SPLIT = "\\-";
	}
}
