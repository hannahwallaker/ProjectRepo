package com.revature.models;

public class ReimbursementStatus {
	
	private int statusId;
	private String reStatus;
	
	
	public ReimbursementStatus(int statusId, String reStatus) {
		super();
		this.statusId = statusId;
		this.reStatus = reStatus;
	}
	
	public ReimbursementStatus(int id) {
		super();
		this.statusId = statusId;
		switch(statusId) {
		case 1:
			reStatus = "approved";
			break;
		case 2:
			reStatus = "denied";
			break;
		case 0:
			reStatus = "pending";
			break;
		default:
			reStatus = "unknown";
			break;
		}
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getReStatus() {
		return reStatus;
	}

	public void setReStatus(String reStatus) {
		this.reStatus = reStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", reStatus=" + reStatus + "]";
	}

	
}

