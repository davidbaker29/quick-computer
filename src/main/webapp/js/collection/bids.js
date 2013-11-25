define(['backbone', 'model/bid'], function (Backbone, Bid) {
	
    var Bids = Backbone.Collection.extend({

    	// Reference to this collection's model.  
        model: Bid,
    });  
    	
    
    return Bids;
});


