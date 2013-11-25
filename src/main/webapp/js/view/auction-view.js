define([ 'backbone', 'text!templates/auction-template.html'],
function (Backbone, AuctionTemplate) {
    
	//This view represents one row in the Auctions table on the Home Page
    var AuctionView = Backbone.View.extend({
        
        el: '#auctionsTable',

        template: _.template( AuctionTemplate ),

        initialize: function(){
            this.render();
        },

        render: function(){
            this.$el.append( this.template(this.model.toJSON()));
            return this;
        }

    });
    return AuctionView;
});