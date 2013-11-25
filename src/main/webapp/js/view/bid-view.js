define([ 'backbone','text!templates/bid-item-template.html'],
function (Backbone,BidItemTemplate) {
    //Tgis view represents a single row in the Bids table
    var BidView = Backbone.View.extend({
        
        el: '#bidsDiv',

        template: _.template(BidItemTemplate),
        
        initialize: function(){
            this.render();
        },

        render: function(){
            this.$el.append( this.template(this.model.toJSON()));
            return this;
        }

    });
    return BidView;
});