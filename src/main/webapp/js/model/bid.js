define(['backbone'], function(Backbone) {
    var Bid = Backbone.Model.extend({
         
         validate: function(attributes){
             if(!attributes.bidAmount){
                 return "Please enter a bid amount";
             }
             if(isNaN(attributes.bidAmount)){
                 return "Please enter a numeric value for the bid";
             }
             if(attributes.bidAmount < 0.01){
                 return "Please enter a value greater than zero for the bid";
             }
         },
         
         initialize: function(){
        	 this.on("invalid", function(model, error){
        		 alert(error);
        		 console.log(error);
        	 });
         }
    });

    return Bid;
});

