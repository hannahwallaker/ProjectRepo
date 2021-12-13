package com.revature.models;

public class ReimbursementType {
	
	private int typeId;
	private String type;
	
	public ReimbursementType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	
	public ReimbursementType(int id) {
		super();
		this.typeId = typeId;
		switch(typeId) {
		case 1:
			type = "Lodging";
			break;
		case 2:
			type = "Travel";
			break;
		case 3:
			type = "Food";
			break;
		default:
			type = "Other";
			break;
		}
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbursementType [typeId=" + typeId + ", type=" + type + "]";
	}
	
	

}
