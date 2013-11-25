define([ 'backbone', 'collection/bids', 'view/bid-view', 'model/bid', 'text!templates/bids-template.html'],
function (Backbone, Bids, BidView, Bid, BidsTemplate) {
    //This view is really just a controller that loops through each auction 
	//in the returned JSON and calls the bids-view to append a row to 
	//the table. It sets up the table header and the form for a new Bid.
	//Possibly I could have merged this in with the auction-details view,
	//sort of like I did with the auctions-view - the higher level view
	//creates the table header. Issues with micing auction and bid data
	//prevented this though
	
    var BidsView = Backbone.View.extend({
    	
    	//el: '#bidsDiv',
    	tagName: 'div',
    	id: 'bidsDiv',
    	className: 'CSSTableGenerator',
        
        // Define view template
    	template: _.template( BidsTemplate ),
    	
        initialize:function (opts) {
            // Initialize the collection
            this.collection = new Bids();
            
            //http://stackoverflow.com/questions/18467020/cannot-use-in-operator-to-search-for-model
            this.auctionId = opts.auctionId; 
            
            // Render the view when the collection is retrieved from the server
            this.listenTo(this.collection, 'sync', this.render);   //arg 2 was 'change'
            
            this.collection.url = 'http://galileo.davidbaker29.cloudbees.net/auction-data/auctions/' +
    			this.auctionId + '/bids';
            //this.collection.url = 'http://localhost:8080/quick.computer-0.0.1-SNAPSHOT/auction-data/auctions/' +
			//	this.auctionId + '/bids';
                
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} }); //use rest
            
            //Ensures newly added bids go to the top of the list
            this.collection.comparator = 'bidAmount';

        },

	    render: function() {
	    	this.el.innerHTML = this.template();
	    	$("#intro").append(this.el);
	    	this.collection.each(function(bid){
	            var bidView = new BidView({ model: bid });
	    	},this);
	    	
	    	return this;
	    	
	    },
	    
	    events: {
	    	"submit #frmSubmitBid":"submit",               
        },
        
        submit : function(e) {
            e.preventDefault();             
            
            var bid = new Bid({auctionId: this.auctionId, 
        		bidAmount: this.$('input[name=newBid]').val(), 
        		dateSubmitted: '19/11/2013', 
        		submittingCompany: {
        			name: 'PC Universe',
        			address: 'Manhattan, New York, New York',
        			email: 'sales@pc-universe.com'
        		}
            });      
           
            this.collection.create(
            	bid,
            {
                wait:true,
            	success: function(model, response){
                	console.log('Success creating a new Bid');
                    $('#bidResultSuccess').html("<p>Thank you. Your bid has been received. </p>");  
                    $('#bidResultFail').html("");
                },
                error: function(model, response){
                	console.log('Error creating a new Bid');

                	$('#bidResultSuccess').html("");
                	$('#bidResultFail').html("<p>Invalid Bid!</p>");
                }
            }
            );      
        }

    });
    return BidsView;
});