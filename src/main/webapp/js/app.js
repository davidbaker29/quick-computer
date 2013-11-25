//// Filename: app.js
//define([
//  'router/app-router', // Request router.js
//], function(router){
//  var initialize = function(){
//    // Pass in our Router module and call it's initialize function
//	  console.log('***In app****');
//      Router.initialize();
//  }
//
//  return {
//    initialize: initialize
//  };
//});

define(['router/app-router'], function (router){
	console.log('In app');
	return {
		initialize:function(){
			console.log('About to init router');
			router.initialize();
		}
	};
});