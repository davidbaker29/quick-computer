package com.baker.david.quick.computer.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.baker.david.quick.computer.dao.InMemoryAuctionsDao;
import com.baker.david.quick.computer.model.Bid;

public class BidControllerTest {

	BidController bidController;
	
	@Rule
	 public ExpectedException exception = ExpectedException.none();


	@Before
	public void init(){
		bidController = new BidController();
		bidController.setAuctionsDAO(new InMemoryAuctionsDao());
	}

	@Test
	public void testGetAllBidsForAuction(){		
		assertTrue(bidController.getAllBids(1).size() > 0);
	}
	
	@Test
	public void testGetBestBidForAuction(){		
		assertEquals(bidController.getBestBid(4).getBidAmount(),4700,0);
	}
	
	@Test
	public void testGetSingleBid(){		
		assertEquals(bidController.getBid(4).getBidAmount(),500,0);
	}
	
	@Test
	public void createBid(){	
		
		int beforeAmountOfBids = bidController.getAllBids(1).size();
		
		Bid bid = new Bid();
		bid.setBidAmount(900);
		bid.setAuctionId(1);
		
		bidController.createBid(bid);
		
		int afterAmountOfBids = bidController.getAllBids(1).size();
		
		assertEquals(afterAmountOfBids - beforeAmountOfBids, 1);
	}

	@Test
	public void createInvalidBid(){	
		
		Bid bid = new Bid();
		bid.setBidAmount(2000);
		bid.setAuctionId(1);

		exception.expect(InvalidBidException.class);
		
		bidController.createBid(bid);

	}
}
