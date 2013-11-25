package com.baker.david.quick.computer.model;

import java.util.Collection;


public class Auction {
	
	private int id;
    private String name;
    private PartType partType;
    private int requiredQuantity;
    private double bestBid;
    private Collection<Bid> bids;
    private String closingDate;
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public PartType getPartType() {
		return partType;
	}
	
	public void setPartType(PartType partType) {
		this.partType = partType;
	}
	
	public int getRequiredQuantity() {
		return requiredQuantity;
	}
	
	public void setRequiredQuantity(int requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}
	
	public String getClosingDate() {
		return closingDate;
	}
	
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}

	public double getBestBid() {
		return bestBid;
	}

	public void setBestBid(double bestBid) {
		this.bestBid = bestBid;
	}

	public Collection<Bid> getBids() {
		return bids;
	}

	public void setBids(Collection<Bid> bids) {
		this.bids = bids;
	}
	
	
    
}
