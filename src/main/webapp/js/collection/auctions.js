define(['backbone', 'model/auction'], function (Backbone, Auction) {
	
    var Auctions = Backbone.Collection.extend({

    	// Reference to this collection's model.  
        model: Auction,
        //url: 'http://localhost:8080/quick.computer-0.0.1-SNAPSHOT/auction-data/auctions'
        url: 'http://galileo.davidbaker29.cloudbees.net/auction-data/auctions/'
    });
    return Auctions;
});


