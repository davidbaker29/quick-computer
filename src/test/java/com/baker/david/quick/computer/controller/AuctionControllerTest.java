package com.baker.david.quick.computer.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.baker.david.quick.computer.dao.InMemoryAuctionsDao;

public class AuctionControllerTest {
	
	AuctionController auctionController;
	
	BidController bidController;

	@Before
	public void init(){
		auctionController = new AuctionController();
		bidController = new BidController();
		auctionController.setBidController(bidController);
		//TODO: change to interface 
		//IAuctionController controller = new AuctionController();
		auctionController.setAuctionsDAO(new InMemoryAuctionsDao());
		bidController.setAuctionsDAO(new InMemoryAuctionsDao());
	}

	
	@Test
	public void testGetAllAuctions(){		
		assertTrue(auctionController.getAllAuctions().size() > 0);
	}
	
	@Test
	public void testGetAuction(){		
		assertEquals(auctionController.getAuction(1).getBestBid(),1000,0);
	}
 
}
