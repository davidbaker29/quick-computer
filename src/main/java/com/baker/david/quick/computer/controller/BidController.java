package com.baker.david.quick.computer.controller;

import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.baker.david.quick.computer.dao.IAuctionsDAO;
import com.baker.david.quick.computer.model.Bid;
import com.baker.david.quick.computer.model.Company;

@Path("/auctions/{auctionId}/bids")
public class BidController implements IBidController {

	@Inject
	private IAuctionsDAO auctionsDAO;
	
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Bid> getAllBids(@PathParam("auctionId") int auctionId) {
		return this.auctionsDAO.getBids(auctionId);
	}
	
	@Override
	@Path("/{id}/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Bid getBid(@PathParam("id") int bidId) {
		return this.auctionsDAO.getBid(bidId);
	}

	@Override
	public Bid getBestBid(int auctionId) {
		Collection<Bid> bids = this.auctionsDAO.getBids(auctionId);
		return Collections.min(bids, null);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void createBid(Bid bid) throws InvalidBidException {
		System.out.println("********Creating bid*****");
		double currentHighBid = this.auctionsDAO.getAuction(bid.getAuctionId()).
				getBestBid();
		
		System.out.println("********Current high bid*****: " + currentHighBid);
		
		if (bid.getBidAmount() >= currentHighBid){
			throw new InvalidBidException();
		}
		else{
			System.out.println("********Calling DAO*****: ");
			
			Company submittingCompany = new Company("PC Universe", "Manhattan, New York, New York", "sales@pcuniverse.com");
			bid.setSubmittingCompany(submittingCompany);
			
			this.auctionsDAO.createBid(bid);
		}
	}

	@Override
	public void acceptBid(Bid bid){
		bid.setAccepted(true);
	}
	
	//Only using these to allow unit test to work. Use Weld or Arquillian in the
	//test and then these can go
	public IAuctionsDAO getAuctionsDAO() {
		return auctionsDAO;
	}

	public void setAuctionsDAO(IAuctionsDAO auctionsDAO) {
		this.auctionsDAO = auctionsDAO;
	}

}
