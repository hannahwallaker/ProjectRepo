package com.revature.models;

public class Reimbursements {

	private int reId;
	private double reAmount;
	private boolean reSubmitted;
	private boolean reResolved;
	private String reDescription;
	private User reCreator;
	private String reCreatorUsername;
	private User reResolver;
	private ReimbursementStatus reStatus;
	private int reStatusId;
	private ReimbursementType reType;
	private int reTypeId;

	public Reimbursements(int reId, double reAmount, boolean reSubmitted, boolean reResolved, String reDescription,
			User reCreator, User reResolver, ReimbursementStatus reStatus, ReimbursementType reType) {
		super();
		this.reId = reId;
		this.reAmount = reAmount;
		this.reSubmitted = reSubmitted;
		this.reResolved = reResolved;
		this.reDescription = reDescription;
		this.reCreator = reCreator;
		this.reResolver = reResolver;
		this.reStatus = reStatus;
		this.reType = reType;
	}

	public Reimbursements(int reid, User recreator, double reamount, String redescription, ReimbursementStatus restatus,
			ReimbursementType retype) {
		this.reId = reid;
		this.reCreator = recreator;
		this.reAmount = reamount;
		this.reDescription = redescription;
		this.reStatus = restatus;
		this.reType = retype;
	}

	public Reimbursements(int reid, String recreator, double reamount, String redescription, int restatus, int retype) {
		this.reId = reid;
		this.setReCreatorUsername(recreator);
		this.reAmount = reamount;
		this.reDescription = redescription;
		this.setReStatusId(restatus);
		this.setReTypeId(retype);
	}

	public int getReId() {
		return reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}

	public double getReAmount() {
		return reAmount;
	}

	public void setReAmount(double reAmount) {
		this.reAmount = reAmount;
	}

	public boolean isReSubmitted() {
		return reSubmitted;
	}

	public void setReSubmitted(boolean reSubmitted) {
		this.reSubmitted = reSubmitted;
	}

	public boolean isReResolved() {
		return reResolved;
	}

	public void setReResolved(boolean reResolved) {
		this.reResolved = reResolved;
	}

	public String getReDescription() {
		return reDescription;
	}

	public void setReDescription(String reDescription) {
		this.reDescription = reDescription;
	}

	public User getReCreator() {
		return reCreator;
	}

	public void setReCreator(User reCreator) {
		this.reCreator = reCreator;
	}

	public User getReResolver() {
		return reResolver;
	}

	public void setReResolver(User reResolver) {
		this.reResolver = reResolver;
	}

	public ReimbursementStatus getReStatus() {
		return reStatus;
	}

	public void setReStatus(ReimbursementStatus reStatus) {
		this.reStatus = reStatus;
	}

	public ReimbursementType getReType() {
		return reType;
	}

	public void setReType(ReimbursementType reType) {
		this.reType = reType;
	}

	public String getReCreatorUsername() {
		return reCreatorUsername;
	}

	public void setReCreatorUsername(String reCreatorUsername) {
		this.reCreatorUsername = reCreatorUsername;
	}

	public int getReStatusId() {
		return reStatusId;
	}

	public void setReStatusId(int reStatusId) {
		this.reStatusId = reStatusId;
	}

	public int getReTypeId() {
		return reTypeId;
	}

	public void setReTypeId(int reTypeId) {
		this.reTypeId = reTypeId;
	}

}
