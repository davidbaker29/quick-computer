package com.baker.david.quick.computer.dao;

import java.util.Collection;

import com.baker.david.quick.computer.model.Auction;

public interface IAuctionsDAO {

	Collection<Auction> getAllAuctions();

	Auction getAuction(int auctionId);
}
