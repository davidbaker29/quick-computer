package com.baker.david.quick.computer.dao;

import java.util.Collection;

import com.baker.david.quick.computer.model.Auction;
import com.baker.david.quick.computer.model.Bid;

public interface IAuctionsDAO {

	Collection<Auction> getAllAuctions();

	Auction getAuction(int auctionId);
	
	Collection<Bid> getBids(int auctionId);
	
	Bid getBid(int bidId);

	void createBid(Bid bid);
}
