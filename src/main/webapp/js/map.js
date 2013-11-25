define(['async!http://maps.google.com/maps/api/js?sensor=false'], function(){
	
//See https://github.com/millermedeiros/requirejs-plugins and 
//https://groups.google.com/forum/#!topic/requirejs/lOf0-3FADjc
//Without the async dependency on google there's an error at this line:
//var latlng = new google.maps.LatLng(20.378745, -30.300293);
//as maps are not loaded
	
	console.log('Executing map support');
	return{
		loadMap:function(){
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(success, error);
			} 
			else {
				error('not supported');
			}	
		}
	};
});

function success(position) {
	var mapcanvas = document.getElementById("mapCanvas");
	mapcanvas.id = 'mapcanvas';
	mapcanvas.style.height = '400px';
	mapcanvas.style.width = '560px';
	    
	document.getElementById('mapHolder').appendChild(mapcanvas);
	
//	var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
//	var myOptions = {
//	  zoom: 15,
//	  center: latlng,
//	  mapTypeControl: false,
//	  navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
//	  mapTypeId: google.maps.MapTypeId.ROADMAP
//	};
//	  
//	var map = new google.maps.Map(document.getElementById("mapcanvas"), myOptions);
//	  
//	var marker = new google.maps.Marker({
//	   position: latlng, 
//	   map: map, 
//	   title:"You are here! (at least within a "+position.coords.accuracy+" meter radius)"
//	});
	
	var locations = [
	                 ['Paris', 48.714978, 2.395020, 1],
	                 ['New York', 40.729389, -73.993607, 2],
	                 ['Boston', 42.324666, -71.054077, 3],
	                 ['Berlin', 52.397810, 13.381348, 4],
	                 ['London', 51.498191, -0.122223, 5],
	                 ['Istanbul', 40.910659, 28.992920, 6],
	                 ['San Francisco', 37.748254, -122.406921, 7],
	                 ['Rio de Janeiro', -22.918793, -43.200989, 8],
	                 ['Dubai', 25.248810, 55.318909, 9],
	                 ['Tokyo', 35.682764, 139.783859, 10]
	               ];
	
	//var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);  
	var latlng = new google.maps.LatLng(20.378745, -30.300293);
	
	var myOptions = {
	  zoom: 2,
	  center: latlng,
	  mapTypeControl: false,
	  navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
	  mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	  
	var map = new google.maps.Map(document.getElementById("mapcanvas"), myOptions);
	  
	for (i = 0; i < locations.length; i++) {  
		var marker = new google.maps.Marker({
		   position: new google.maps.LatLng(locations[i][1], locations[i][2]), 
		   map: map
		});
	}

//	               var map = new google.maps.Map(document.getElementById('mapCanvas'), {
//	                 zoom: 11,
//	                 center: new google.maps.LatLng(-33.92, 151.25),
//	                 mapTypeId: google.maps.MapTypeId.ROADMAP
//	               });
//	               var infowindow = new google.maps.InfoWindow();
//	               var marker, i;
//	               for (i = 0; i < locations.length; i++) {  
//	                 marker = new google.maps.Marker({
//	                   position: new google.maps.LatLng(locations[i][1], locations[i][2]),
//	                   map: map
//	                 });
//	               }
}

function error(msg) {
   var x = document.getElementById('mapHolder');
   switch(msg.code) 
   {
   case error.PERMISSION_DENIED:
     x.innerHTML="<p>User denied the request for Geolocation.</p>"
     break;
   case error.POSITION_UNAVAILABLE:
     x.innerHTML="<p>Location information is unavailable.</p>"
     break;
   case error.TIMEOUT:
     x.innerHTML="<p>The request to get user location timed out.</p>"
     break;
   case error.UNKNOWN_ERROR:
     x.innerHTML="<p>An unknown error occurred.</p>"
     break;
   }
}


