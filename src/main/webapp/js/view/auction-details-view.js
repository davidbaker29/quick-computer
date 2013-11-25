define([ 'backbone','model/auctionDetails', 'text!templates/auction-details-template.html'],
function (Backbone, AuctionDetails, AuctionDetailsTemplate) {
    
	//This view shows the details of a selected auction. At present it doesn't
	//show any more than we show on the Home Page for an auction. So it's 
	//inefficient to go back to the server for the data we already have on 
	//the Home Page. Not sure how to implement that though - would need to
	//set the model on the view voa client-side code rather than a Rest call.
	//In any case at least this way we can show extra info for the selected
	//auction. Probably the bids for the auction should be retrieved as 
	//part of the call for the aucton details. I had that but instead I now
	//make a direct call to the BidController. Not sure how to render a single
	//auction and a series of child bids. Would need to loop over the bids
	//and create a Bid View instance for each. Probably do-able with parent-
	//child views or Backbone-Relational
	
    var AuctionDetailsView = Backbone.View.extend({
        
        el: '#intro',
        
        template: _.template( AuctionDetailsTemplate ),

        initialize: function(opts){
        	this.model = new AuctionDetails();
        	this.auctionId = opts.auctionId; 
        	
        	this.model.url = 'http://galileo.davidbaker29.cloudbees.net/auction-data/auctions/' 
            	+ this.auctionId;
        	//this.model.url = 'http://localhost:8080/quick.computer-0.0.1-SNAPSHOT/auction-data/auctions/' 
            //	+ this.auctionId;
        	
        	// Render the view when the collection is retrieved from the server
            this.listenTo(this.model, 'sync', this.render);   //arg 2 was 'change'
            
            // Request unpaginated URL
            this.model.fetch({ data: { page: 'no'} }); //use rest
        	
            //this.render();
        },

        render: function(){
            this.$el.html( this.template(this.model.toJSON()));
            
            return this;
        }

    });
    return AuctionDetailsView;
});