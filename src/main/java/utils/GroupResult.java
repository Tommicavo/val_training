package utils;

import model.bean.GruppoBean;
import java.util.Map;

public class GroupResult {
	
	private GruppoBean gruppoBean;
	private Map<String, String> messages;
	
	public GroupResult() {}
	public GroupResult(GruppoBean gruppoBean, Map<String, String> messages) {
		this.gruppoBean = gruppoBean;
		this.messages = messages;
	}
	
	public GruppoBean getGruppoBean() {
		return gruppoBean;
	}
	public Map<String, String> getMessages() {
		return messages;
	}
}
