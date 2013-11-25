// Set the require.js configuration for your application.
require.config({

    shim: {
        'underscore': {
            exports: '_'
        },
        'underscore-string': {
            deps: [
                'underscore'
            ]
        },
        'backbone': {
            deps: [
                'underscore',
                'underscore-string',
                'jquery'
            ],
            exports: 'Backbone'
        },
        'jquery-ui': {
            deps: [
                'jquery'
            ]
        },
    },

    // Libraries
    paths: {
        jquery: 'lib/jquery',
        'jquery-ui': 'lib/jquery-ui',   //the dash causes a problem if no quotes
        underscore: 'lib/underscore',
        'underscore-string': 'lib/underscore-string',
        backbone: 'lib/backbone',
        text: 'lib/text',
        async:'lib/async'
    }
});

// Load our app module and pass it to our definition function
require(['app'], function(App){
	console.log('***In main****');
	App.initialize();         
});
//require(['view/auctions-view','twitter','router/app-router'], function(AuctionView){
//	  var auctionView = new AuctionView;
//	});