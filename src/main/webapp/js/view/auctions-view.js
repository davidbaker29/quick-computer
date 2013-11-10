define([ 'backbone', 'collection/auctions', 'view/auction-view'],
function (Backbone, Auctions, AuctionView) {
    //This view is really just a controller that loops through each auction 
	//in the returned JSON and calls the auction-view to append a row to 
	//the table
    var AuctionsView = Backbone.View.extend({
    	
    	el: '#auctionsDiv',
        
        // Define view template
    	 template: _.template( $('#auction-item-template').html() ),
    	 
        initialize:function () {
            // Initialize the collection
            this.collection = new Auctions();
            
            // Render the view when the collection is retrieved from the server
            this.listenTo(this.collection, 'sync', this.render);   //arg 2 was 'change'
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} }); //use rest

        },

	    render: function() {
	    	
	    	this.collection.each(function(auction){
	            var auctionView = new AuctionView({ model: auction });
	    	},this);
	    }

    });
    return AuctionsView;
});