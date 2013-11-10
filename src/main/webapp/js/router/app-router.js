define(['backbone', 'view/auction-view', 'view/auctions-view', 'view/contact-us-view'],
function (Backbone, AuctionView, AuctionsView, ContactUsView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
            Backbone.history.start({ pushState: true, root: "/" });
        },

        routes:{
            '': 'home',
            'home': 'home',
            'about': 'about'
        },

        home:function () {
            new AuctionsView({ root: $('#main') });
        },
        about:function () {
            new ContactUsView({ root: $('#contact') });
        }
        
    });

    return AppRouter;

});