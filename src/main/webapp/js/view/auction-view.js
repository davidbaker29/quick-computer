define([ 'backbone'],
function (Backbone) {
    
    var AuctionView = Backbone.View.extend({
        
        el: '#auctionsTable',

        template: _.template( $('#auction-item-template').html()),

        initialize: function(){
            this.render();
        },

        render: function(){
            this.$el.append( this.template(this.model.toJSON()));
        }

    });
    return AuctionView;
});