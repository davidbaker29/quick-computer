package com.baker.david.quick.computer.model;


public class Auction {
	
	private long id;
    private String name;
    private PartType partType;
    private int requiredQuantity;
    private int bestBid;
    private String closingDate;
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
	
	public int getBestBid() {
		return bestBid;
	}
	public void setBestBid(int bestBid) {
		this.bestBid = bestBid;
	}
	
	public String getClosingDate() {
		return closingDate;
	}
	
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
    
}
