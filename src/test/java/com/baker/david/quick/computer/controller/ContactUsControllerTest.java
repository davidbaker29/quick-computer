package com.baker.david.quick.computer.controller;

import com.baker.david.quick.computer.dao.EMailDAO;
import com.baker.david.quick.computer.model.ContactDetails;

public class ContactUsControllerTest {

	//@Test
	public void testContactUs(){
		ContactUsController controller = new ContactUsController();
		controller.setEmailDAO(new EMailDAO());
		ContactDetails contactDetails = new ContactDetails();
		
		contactDetails.setName("Lionel Messi");
		contactDetails.setCompany("Barcelona");
		contactDetails.setEmail("leo.messi@gmail.com");
		contactDetails.setPhone("087 1234567");
		contactDetails.setRegisteredSupplier(false);
		contactDetails.setSupplierCode("");
		contactDetails.setIssue("Why have I not scored many goals lately?");
		
		controller.processContactRequest(contactDetails );
	}
}
