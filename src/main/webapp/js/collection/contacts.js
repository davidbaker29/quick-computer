define(['backbone', 'model/contactUs'], function (Backbone, Contact) {
	
    var Contacts = Backbone.Collection.extend({

    	// Reference to this collection's model.  
        model: Contact,
        //url: 'http://localhost:8080/quick.computer-0.0.1-SNAPSHOT/auction-data/contact'
        url: 'http://galileo.davidbaker29.cloudbees.net/auction-data/contact'
    });
    return Contacts;
});


