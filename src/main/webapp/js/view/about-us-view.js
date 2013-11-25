define(['backbone', 'text!templates/about-us-template.html','map'],
function (Backbone, AboutUs, Map) {
    
    var AboutUsView = Backbone.View.extend({
        
        el: '#intro',

        template: _.template( AboutUs ),

        initialize: function(){         
            this.render();
        },

        render: function(){
        	this.$el.html(this.template());
        	var map = Map.loadMap();
        	map.loadMap();
        	return this;
        }

    });
    return AboutUsView;
});