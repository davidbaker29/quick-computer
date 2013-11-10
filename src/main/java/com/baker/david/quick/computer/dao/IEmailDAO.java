package com.baker.david.quick.computer.dao;

import com.baker.david.quick.computer.model.ContactDetails;

public interface IEmailDAO {

	public void sendEmail(ContactDetails contactDetails);
}
