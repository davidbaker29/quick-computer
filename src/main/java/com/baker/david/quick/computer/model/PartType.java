package com.baker.david.quick.computer.model;

public enum PartType {

	RAM ("RAM"),
	CPU ("CPU"),
	HDD ("HDD"),
	Router ("Router");

	private final String type;
	
	PartType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
