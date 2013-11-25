define([ 'backbone', 'collection/auctions', 'view/auction-view', 
         'text!templates/auctions-template.html', 'twitter'],
function (Backbone, Auctions, AuctionView, AuctionsTemplate, Twitter) {
    //This view is really just a controller that loops through each auction 
	//in the returned JSON and calls the auction-view to append a row to 
	//the table. It's used as the starting point of the app. It sets up most
	//of the Home Page and creates a div that the auctions table is then added to
    var AuctionsView = Backbone.View.extend({
    	
    	el: '#intro',
    	
        // Define view template
    	 template: _.template( AuctionsTemplate ),
    	 
        initialize:function () {
            // Initialize the collection
            this.collection = new Auctions();
            
            // Render the view when the collection is retrieved from the server
            this.listenTo(this.collection, 'sync', this.render);   //arg 2 was 'change'
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} }); //use rest
            
            this.render();

        },

	    render: function() {
	    	this.$el.html(this.template());
	    	
	    	this.collection.each(function(auction){
	            var auctionView = new AuctionView({ model: auction });
	    	},this);
	    	
	    	Twitter.loadTweets(document,"script","twitter-wjs");
	    	
	    	return this;
	    },
	    
	    close: function() {
			this.remove();
		}

    });
    return AuctionsView;
});