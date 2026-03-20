package com.ui.pojos;

import java.util.Map;

public class Config {
	 Map<String, Enviorment> enviornments;

	public Map<String, Enviorment> getEnviorments() {
		return enviornments;
	}

	public void setEnviorments(Map<String, Enviorment> enviorments) {
		this.enviornments = enviorments;
	}
}
