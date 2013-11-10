package com.baker.david.quick.computer.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.baker.david.quick.computer.dao.InMemoryAuctionsDao;

public class AuctionControllerTest {
	
	AuctionController controller;

	@Before
	public void init(){
		controller = new AuctionController();

		//TODO: change to interface 
		//IAuctionController controller = new AuctionController();
		controller.setAuctionsDAO(new InMemoryAuctionsDao());
	}

	
	@Test
	public void testGetAllAuctions(){		
		assertTrue(controller.getAllAuctions().size() > 0);
	}
	
	@Test
	public void testGetAuction(){		
		assertEquals(controller.getAuction(1).getBestBid(),1000);
	}
 
}
