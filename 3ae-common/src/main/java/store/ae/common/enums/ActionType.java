package store.ae.common.enums;

import lombok.Getter;

@Getter
public enum ActionType {
	SEARCH(1, "查看"),
	INSERT(2, "添加"),
	UPDATE(3, "更新"),
	DELETE(4, "删除");
	
	private String stateInfo;
	
	private int state;
	
	private ActionType(int state, String staeInfo) {
		this.state = state;
		this.stateInfo = staeInfo;
	}
	
	public static ActionType stateof(int index) {
		for(ActionType state : values()) {
			if(state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
