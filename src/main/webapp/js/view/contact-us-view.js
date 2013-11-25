define(['backbone', 'collection/contacts', 'text!templates/contact-us-template.html'],
function (Backbone, Contacts, ContactUs) {
    
    var ContactUsView = Backbone.View.extend({
        
        el: '#intro',

        template: _.template(ContactUs),

        initialize: function(){
        	
            this.collection = new Contacts();
            
            this.render();
        },

        render: function(){
        	this.$el.html(this.template());
        	return this;
        },
        
        events: {
            'submit #contactUsForm': 'submitContactForm'
          },
          
        submitContactForm: function (event) {
        	console.log('****Submitting contact request');
        	event.preventDefault();
        	
//        	Collections.create() is used below to create a 
//        	new model, add it to the collection, and send it to the server in a single method call.
        	
//			The attribure 
        	
//        	While Backbone can retrieve an entire collection of models from the server at once, 
//        	updates to models are performed individually using the model’s save() method. When save() 
//        	is called on a model that was fetched from the server, it constructs a URL by appending 
//        	the model’s id to the collection’s URL and sends an HTTP PUT to the server. If the model 
//        	is a new instance that was created in the browser (i.e., it doesn’t have an id) then an 
//        	HTTP POST is sent to the collection’s URL.
        	
//          Backbone supports RESTful persistence via its fetch() and create() methods on Collections 
//       	and save() and delete() methods on Models. Backbone’s sync method underlies these 
//        	operations.
        	
        	var isSupplier = this.$('input[value=supplier]').is(':checked');
        	
            this.collection.create({
                name: this.$('input[name=personName]').val(),
                company: this.$('input[name=companyName]').val(),
                email: this.$('input[name=email]').val(),
                phone: this.$('input[name=phone]').val(),
                registeredSupplier: isSupplier,
                supplierCode: this.$('input[name=supplierID]').val(),
                issue: this.$('textarea[name=issue]').val()
            });
            
            this.$el.html("<p>Thank you. Your request has been received. We will contact you within" +
            		" three working days.");
        }

    });
    return ContactUsView;
});