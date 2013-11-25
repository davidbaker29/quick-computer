define(['backbone', 'view/auction-view', 'view/auctions-view', 'view/bids-view',
         'view/auction-details-view', 'view/about-us-view', 'view/contact-us-view', 'view/admin-view'],
function (Backbone, AuctionView, AuctionsView, BidsView, AuctionDetailsView, 
		AboutUsView, ContactUsView, AdminView) {
	
    var AppRouter = Backbone.Router.extend({

// See http://mikeygee.com/blog/backbone.html for the stuff about loading views etc
    
        routes:{
            '': 'latestAuctionList',
            'latestAuctions': 'latestAuctionList',
            'bids/:auctionId': 'bids',
            'about' : 'about',
            'contact' : 'contact',
            'allAuctions' : 'allAuctions',
            'myBids' : 'myBids',
            'admin' : 'admin',
        },
        
        loadView : function(view, closePrevious) {
    		//if (closePrevious == true){
        	//	this.view && (this.view.close ? this.view.close() : this.view.remove());
    		//}
        	//this.view && this.view.close();
    		this.view = view;
    	},
    	
    	// for any view that may have a dirty condition, set a property named dirty to true, 
    	//and if the user navigates away, a confirmation dialog will show
    	hashChange : function(evt) {
    		if(this.cancelNavigate) { // cancel out if just reverting the URL
    			evt.stopImmediatePropagation();
    			this.cancelNavigate = false;
    			return;
    		}
    		if(this.view && this.view.dirty) {
    			var dialog = confirm("You have unsaved changes. To stay on the page, press cancel. To discard changes and leave the page, press OK");
    			if(dialog == true)
    				return;
    			else {
    				evt.stopImmediatePropagation();
    				this.cancelNavigate = true;
    				window.location.href = evt.originalEvent.oldURL;
    			}
    		}
    	},
    	
    	beforeUnload : function() {
    		if(this.view && this.view.dirty)
    			return "You have unsaved changes. If you leave or reload this page, your changes will be lost.";
    	},

        latestAuctionList:function () {
        	console.log('***In latestAuctionList****');
        	//new AuctionsView();
        	//this.loadView(new AuctionsView()), true;
        	this.loadView(new AuctionsView(), true);
        	
        },
        bids:function (auctionId) {
        	console.log('***In bids****' + auctionId);
        	//http://stackoverflow.com/questions/18467020/cannot-use-in-operator-to-search-for-model
        	
        	//On home page I'm loading auctions header and table in one view, but here
        	//I'm using two..
        	this.loadView(new AuctionDetailsView({auctionId:auctionId}), true);
        	this.loadView(new BidsView({auctionId:auctionId}), false);
        },
        about:function () {
        	console.log('***In about****');
        	//this.loadView(new AboutUsView()), true;  	
        	this.loadView(new AboutUsView(), true);  	
        },
        contact:function () {
        	console.log('***In contact****');
        	this.loadView(new ContactUsView(), true);      	
        },
        admin:function () {
        	console.log('***In admin****');
        	this.loadView(new AdminView(), true);      	
        }
        
    });
    
    var initialize = function() {
    	var app_router = new AppRouter;
    	
    	$(window).on("hashchange", app_router.hashChange); // this will run before backbone's route handler
    	$(window).on("beforeunload", app_router.beforeUnload);
    	//Backbone.history.start({ pushState: true});
    	//Backbone.history.start({ pushState: true, root: "/index.html" });
    	Backbone.history.start(); //above two lines not working - they are the HTML5 version of this
    	console.log('***History started***');
    };
    return {
    	initialize: initialize
    };

    return AppRouter;
});