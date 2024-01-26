package utils;

import model.bean.UtenteBean;
import java.util.Map;

public class AuthResult {
	
	private UtenteBean utenteBean;
	private Map<String, String> messages;
	
	public AuthResult() {}
	public AuthResult(UtenteBean utenteBean, Map<String, String> messages) {
		this.utenteBean = utenteBean;
		this.messages = messages;
	}

	public UtenteBean getUtenteBean() {
		return utenteBean;
	}

	public Map<String, String> getMessages() {
		return messages;
	}
}
