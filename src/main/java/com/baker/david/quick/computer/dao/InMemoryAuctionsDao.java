 package com.baker.david.quick.computer.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.baker.david.quick.computer.model.Auction;
import com.baker.david.quick.computer.model.PartType;

public class InMemoryAuctionsDao implements IAuctionsDAO {

	Collection<Auction> auctions = new ArrayList<Auction>();
	
	public InMemoryAuctionsDao(){
		this.init();
	}
	
	private void init() {
		Auction auction1 = new Auction();
		
		auction1.setId(1);
		auction1.setName("Dell RAM - 8Gb");
		auction1.setPartType(PartType.RAM); //TODO change this to use the enum
		auction1.setBestBid(1000);
		auction1.setRequiredQuantity(200);
		auction1.setClosingDate("20/11/2013");
		
		Auction auction2 = new Auction();

		auction2.setId(2);
		auction2.setName("Intel Celeron");
		auction2.setPartType(PartType.CPU); //TODO change this to use the enum
		auction2.setBestBid(3500);
		auction2.setRequiredQuantity(550);
		auction2.setClosingDate("20/12/2013");
		
		Auction auction3 = new Auction();
		
		auction3.setId(3);
		auction3.setName("Intel RAM - 4Gb");
		auction3.setPartType(PartType.RAM); //TODO change this to use the enum
		auction3.setBestBid(7000);
		auction3.setRequiredQuantity(2000);
		auction3.setClosingDate("01/01/2014");
		
		Auction auction4 = new Auction();

		auction4.setId(4);
		auction4.setName("Cisco Router");
		auction4.setPartType(PartType.Router); //TODO change this to use the enum
		auction4.setBestBid(1500);
		auction4.setRequiredQuantity(10);
		auction4.setClosingDate("25/12/2013");
		
		this.auctions.add(auction1);
		this.auctions.add(auction2);
		this.auctions.add(auction3);
		this.auctions.add(auction4);
		
	}

	@Override
	public Collection<Auction> getAllAuctions() {
		return this.auctions;
	}

	@Override
	public Auction getAuction(int auctionId) {
		// TODO: make the auctions a map rather than a list
		// so that the get is more efficient. Prob need
		// to key on ID rather than name
		for (Auction auction: this.auctions){
			if (auction.getId() == auctionId){
				return auction;
			}
		}
		return null;
	}

}
