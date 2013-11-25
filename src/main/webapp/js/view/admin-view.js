define(['backbone', 'text!templates/admin-template.html'],
function (Backbone, Admin) {
    
    var AdminView = Backbone.View.extend({
        
        el: '#intro',

        template: _.template( Admin ),

        initialize: function(){
            
            this.render();
        },

        render: function(){
        	this.$el.html(this.template());
        	return this;
        }

    });
    return AdminView;
});