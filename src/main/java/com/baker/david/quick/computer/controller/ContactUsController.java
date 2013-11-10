package com.baker.david.quick.computer.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.baker.david.quick.computer.dao.EMailDAO;
import com.baker.david.quick.computer.dao.IEmailDAO;
import com.baker.david.quick.computer.model.ContactDetails;

@Path("/contact")
public class ContactUsController implements IContactUsController {

	@Inject
	private IEmailDAO emailDAO;

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void processContactRequest(ContactDetails contactDetails){
		System.out.println("*****In Contact controller*****");
		try{
			this.emailDAO.sendEmail(contactDetails);
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
	}

	public IEmailDAO getEmailDAO() {
		return emailDAO;
	}

	public void setEmailDAO(IEmailDAO emailDAO) {
		this.emailDAO = emailDAO;
	}
	
	
}
