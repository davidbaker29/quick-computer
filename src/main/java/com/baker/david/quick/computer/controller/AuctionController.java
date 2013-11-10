package com.baker.david.quick.computer.controller;

import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.baker.david.quick.computer.dao.IAuctionsDAO;
import com.baker.david.quick.computer.dao.InMemoryAuctionsDao;
import com.baker.david.quick.computer.model.Auction;

@Path("/auctions")
public class AuctionController implements IAuctionController {
	
	@Inject
	private IAuctionsDAO auctionsDAO;
	//private IAuctionsDAO auctionsDAO = new InMemoryAuctionsDao(); //Tomcat has no CDI
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Auction> getAllAuctions(){
		System.out.println("**************** All auctions requested**************");
		
		Collection<Auction> auctions = Collections.emptyList();
		
		try{
			auctions = this.auctionsDAO.getAllAuctions();
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		
		return auctions;
	}
	
	@Path("/{id}/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Auction getAuction(@PathParam("id") int auctionId){
		System.out.println("**************** Auction requested**************");
		return this.auctionsDAO.getAuction(auctionId);
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
