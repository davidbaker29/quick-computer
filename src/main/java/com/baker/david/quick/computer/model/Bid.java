package com.baker.david.quick.computer.model;

public class Bid implements Comparable<Bid> {
 
	private int id;
	
	private int auctionId;
	
	private double bidAmount;
	
	private String dateSubmitted;
	
	private Company submittingCompany;
	
	private boolean accepted = false;
	
	public Bid(){};
	
	public Bid(int id, double bidAmount, String dateSubmitted, Company submittingCompany, int auctionId){
		this.id = id;
		this.auctionId = auctionId;
		this.bidAmount = bidAmount;
		this.dateSubmitted = dateSubmitted;
		this.submittingCompany = submittingCompany;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Company getSubmittingCompany() {
		return submittingCompany;
	}

	public void setSubmittingCompany(Company submittingCompany) {
		this.submittingCompany = submittingCompany;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	@Override
	public int compareTo(Bid bid) {
		int result = 0;
		
		if (this.getBidAmount() == bid.getBidAmount()){
			return 0;
		}
		else if (this.getBidAmount() < bid.getBidAmount()){
			return -1;
		}
		else if (this.getBidAmount() > bid.getBidAmount()){
			return 1;
		}
		
		return result;
	}
	
	
	
}
