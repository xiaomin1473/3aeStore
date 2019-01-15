package store.ae.server.common;

public enum ParamEnums {
	PROMOTER('@', "启动"),
	TERMINATOR('#', "终止");
	
	private String paramInfo;

	private int param;
	
	private ParamEnums(int param, String paramInfo) {
		this.param = param;
		this.paramInfo = paramInfo;
	}
	
	public String getParamInfo() {
		return paramInfo;
	}

	public int getParam() {
		return param;
	}

	public static ParamEnums paramof(int index) {
		for(ParamEnums param : values()) {
			if(param.getParam() == index) {
				return param;
			}
		}
		
		return null;
	}
}
