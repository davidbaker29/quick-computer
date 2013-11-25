 package com.baker.david.quick.computer.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;

import com.baker.david.quick.computer.model.Auction;
import com.baker.david.quick.computer.model.Bid;
import com.baker.david.quick.computer.model.Company;
import com.baker.david.quick.computer.model.PartType;

@Singleton
public class InMemoryAuctionsDao implements IAuctionsDAO {
	
	public InMemoryAuctionsDao(){
		this.init();
	}

	Collection<Auction> auctions = new ArrayList<Auction>();
	
	//key is auction id
	Map<Integer,Collection<Bid>> allBids;
	
	private void init() {
		
		System.out.println("****** InMemoryAuctionsDAO init ******");
		
		Company company1 = new Company("Notebook-Pro", "Park West Business Campus, Dublin 14 ,Ireland", "info@cpu-pro.com");
		Company company2 = new Company("PC Builders", "Greenwich, London XHR143, England", "sales@hdd-pro.com");
		
		Auction auction1 = new Auction();
		auction1.setId(1);
		
		Auction auction2 = new Auction();
		auction2.setId(2);
		
		Auction auction3 = new Auction();
		auction3.setId(3);
		
		Auction auction4 = new Auction();
		auction4.setId(4);
		
		
		Bid a1bid1 = new Bid(1,1100,"01/12/2013", company1, 1);
		Bid a1bid2 = new Bid(2,1000,"02/12/2013", company2, 1);
		
		Collection<Bid> a1Bids = new ArrayList<Bid>();
		a1Bids.add(a1bid1);
		a1Bids.add(a1bid2);
		
		
		Bid a2bid1 = new Bid(3,600,"01/12/2013", company1, 2);
		Bid a2bid2 = new Bid(4,500,"02/12/2013", company2, 2);
		Bid a2bid3 = new Bid(5,400,"04/12/2013", company1, 2);
				
		Collection<Bid> a2Bids = new ArrayList<Bid>();
		a2Bids.add(a2bid1);
		a2Bids.add(a2bid2);
		a2Bids.add(a2bid3);
		
		
		Bid a3bid1 = new Bid(6,600,"01/12/2013", company1, 3);
		Bid a3bid2 = new Bid(7,500,"02/12/2013", company2, 3);
		Bid a3bid3 = new Bid(8,450,"04/12/2013", company1, 3);
		
		Collection<Bid> a3Bids = new ArrayList<Bid>();
		a3Bids.add(a3bid1);
		a3Bids.add(a3bid2);
		a3Bids.add(a3bid3);	
		
		
		Bid a4bid1 = new Bid(9,6000,"03/11/2013", company2, 4);
		Bid a4bid2 = new Bid(10,5000,"06/12/2013", company1, 4);
		Bid a4bid3 = new Bid(11,4800,"07/12/2013", company2, 4);
		Bid a4bid4 = new Bid(12,4700,"07/12/2013", company1, 4);
		
		Collection<Bid> a4Bids = new ArrayList<Bid>();
		a4Bids.add(a4bid1);
		a4Bids.add(a4bid2);
		a4Bids.add(a4bid3);
		a4Bids.add(a4bid4);
		
		allBids = new HashMap<Integer,Collection<Bid>>();
		allBids.put(1, a1Bids);
		allBids.put(2, a2Bids);
		allBids.put(3, a3Bids);
		allBids.put(4, a4Bids);
		


		auction1.setName("Dell RAM - 8Gb");
		auction1.setPartType(PartType.RAM); //TODO change this to use the enum
		auction1.setBestBid(1000);
		auction1.setRequiredQuantity(200);
		auction1.setClosingDate("20/11/2013");
	

			
		auction2.setName("Intel Celeron");
		auction2.setPartType(PartType.CPU); //TODO change this to use the enum
		auction2.setBestBid(400);
		auction2.setRequiredQuantity(550);
		auction2.setClosingDate("20/12/2013");


		auction3.setName("Intel RAM - 4Gb");
		auction3.setPartType(PartType.RAM); //TODO change this to use the enum
		auction3.setBestBid(450);
		auction3.setRequiredQuantity(2000);
		auction3.setClosingDate("01/01/2014");
		
		
		auction4.setName("Cisco Router");
		auction4.setPartType(PartType.Router); //TODO change this to use the enum
		auction4.setBestBid(4700);
		auction4.setRequiredQuantity(10);
		auction4.setClosingDate("25/12/2013");
		
		this.auctions.add(auction1);
		this.auctions.add(auction2);
		this.auctions.add(auction3);
		this.auctions.add(auction4);
		
	}

	@Override
	public Collection<Auction> getAllAuctions() {
		System.out.println("****** InMemoryAuctionsDAO getAllAuctions ******");
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
		throw new AuctionNotFoundException();
	}

	@Override
	public Collection<Bid> getBids(int auctionId) {
		// TODO Auto-generated method stub
		Collection<Bid> bids = this.allBids.get(auctionId);
		Collections.sort((List<Bid>) bids); 
		return bids;
	}

	@Override
	public Bid getBid(int bidId) throws BidNotFoundException {
		
		Iterator<Collection<Bid>> allBidsIterator = this.allBids.values().iterator();
		
		while(allBidsIterator.hasNext()){
			Collection<Bid> currBidCollection = allBidsIterator.next();
			Iterator<Bid> bids = currBidCollection.iterator();
			while(bids.hasNext()){
				Bid currBid = bids.next();
				if (currBid.getId() == bidId){
					return currBid;
				}
			}
		}
		throw new BidNotFoundException();
	}

	@Override
	public void createBid(Bid bid) {
		// TODO Auto-generated method stub
		System.out.println("********Create bid in DAO*****");
		
		Auction auction = this.getAuction(bid.getAuctionId());
		
		System.out.println("****** Best bid is  " + auction.getBestBid());
		System.out.println("******Num bids is : " + allBids.get(bid.getAuctionId()).size());
		
		bid.setId(allBids.get(bid.getAuctionId()).size());
		
		Collection<Bid> allBidsForAuction = allBids.get(bid.getAuctionId());
		allBidsForAuction.add(bid);
		
		this.allBids.put(bid.getAuctionId(), allBidsForAuction);
		
		System.out.println("********Added bid in DAO*****");
		
		auction.setBestBid(bid.getBidAmount());
		System.out.println("********Set best bid in DAO*****");
		System.out.println("****** Best bid is now " + auction.getBestBid());
		System.out.println("******Num bids is now : " + allBids.get(bid.getAuctionId()).size());
		
		Collection<Bid> collBids = allBids.get(bid.getAuctionId());
		Iterator<Bid> bidIterator = collBids.iterator();
		while(bidIterator.hasNext()){
			Bid aBid = bidIterator.next();
			System.out.println("A bid for the auction:" + aBid.getBidAmount());
		}
	}

}
