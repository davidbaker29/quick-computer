package com.baker.david.quick.computer.controller;

import java.util.Collection;

import com.baker.david.quick.computer.model.Bid;

public interface IBidController {

	public Collection<Bid> getAllBids(int auctionId);
	
	public Bid getBestBid(int auctionId);
	
	public void createBid(Bid bid) throws InvalidBidException;
	
	public void acceptBid(Bid bid);

	public Bid getBid(int bidId);
}
