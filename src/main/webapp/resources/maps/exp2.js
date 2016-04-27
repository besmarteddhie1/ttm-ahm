var dealerPoint = [];
dealerPoint = [{
    nama : "Dummy 1",
    lat : -42.088534,
    lon : 146.596076
},{
    nama : "Dummy 2",
    lat : -42.984253,
    lon : 146.96765
},{
    nama : "Dummy 3",
    lat : -42.660900,
    lon : 146.1096633
},{
    nama : "Dummy 4",
    lat : -41.088534,
    lon : 146.596076
}]

console.log("Ini",dealerPoint);
var map = new OpenLayers.Map({
    div: "map",
    allOverlays: false,
    units: "inches"
});
var position = new OpenLayers.LonLat(146.596076,-42.088534);
var position2 = new OpenLayers.LonLat(146.96765,-42.984253);
var position3 = new OpenLayers.LonLat(146.1096633,-42.660900);

var zoom = 8;

var ol_sb = new OpenLayers.Layer.WMS(
    "State Boundaries",
    "http://localhost:8099/geoserver/gwc/service/wms",
    {
        layers: "topp:tasmania_state_boundaries",
        transparent: true
    },
    {
        isBaseLayer:true,
        attribution:"Provided by AHM",
        units: "inches"
    }
    );

var ol_wb = new OpenLayers.Layer.WMS(
    "Water Boundaries",
    "http://localhost:8099/geoserver/gwc/service/wms",
    {  
        layers: "topp:tasmania_water_bodies",
        transparent: true
    },
    {
        isBaseLayer:false,
        displayInLayerSwitcher:false
    }
    );

var ol_tr = new OpenLayers.Layer.WMS(
    "Tasmania Roads",
    "http://localhost:8099/geoserver/gwc/service/wms",
    {
        layers: "topp:tasmania_roads",
        transparent: true
    },
    {
        isBaseLayer:false,
        displayInLayerSwitcher:false
    }
    );

var ol_tc = new OpenLayers.Layer.WMS(
    "Tasmania Cities",
    "http://localhost:8099/geoserver/gwc/service/wms",
    {
        layers: "topp:tasmania_cities",
        transparent: true
    },
    {
        isBaseLayer:false,
        displayInLayerSwitcher:false
    }
    );
// Styling
/*
var pointStyle = new OpenLayers.StyleMap({
    "default": new OpenLayers.Style({
                    pointRadius: 4,
                    fillColor: "#ffffff",
                    strokeColor: "#ff9933",
                    strokeWidth: 2
                })
});

var ring1Style = new OpenLayers.StyleMap({
    "default": new OpenLayers.Style({
                    pointRadius: 24,
                    fillColor: "#ffeeee",
                    fillOpacity: 0.7,
                    strokeColor: "#ff9933",
                    strokeWidth: 2
                })
});

var ring2Style = new OpenLayers.StyleMap({
    "default": new OpenLayers.Style({
                    pointRadius: 40,
                    fillColor: "#eeeeee",
                    fillOpacity: 0.5,
                    strokeColor: "#ff9933",
                    strokeWidth: 2
                })
});
*/
//  // Create Marker
// var size = new OpenLayers.Size(21,25);
// var offset = new OpenLayers.Pixel(-(size.w/2), - size.h);
// var icon = new OpenLayers.Icon('img/marker-blue.png',size,offset);
// var markers = new OpenLayers.Layer.Markers( "Markers" );
// markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(0,0),icon));  

var dealer = new OpenLayers.Layer.Vector("Dealer", {
    units: "inches"
    // transparent: true,
    // styleMap: pointStyle
});
var ring1 = new OpenLayers.Layer.Vector("Ring 1", {
    // transparent: true,
    // styleMap: ring1Style
});
var ring2 = new OpenLayers.Layer.Vector("Ring 2", {
    // transparent: true,
    // styleMap: ring2Style
});

for(i=0;i<dealerPoint.length;i++){
//    console.log(i,dealerPoint[i]);
    $("#info").append(dealerPoint[i].nama+" <button onclick=setFocus("+dealerPoint[i].lon+","+dealerPoint[i].lat+")>Show</button><br><hr>");
    position = new OpenLayers.LonLat(dealerPoint[i].lon,dealerPoint[i].lat);

    var p = new OpenLayers.Geometry.Point(position.lon,position.lat);
    var r1 = new OpenLayers.Geometry.Point(position.lon,position.lat);
    var r2 = new OpenLayers.Geometry.Point(position.lon,position.lat);
    var region = new OpenLayers.Geometry.Point(position3.lon,position3.lat);
    var p = new OpenLayers.Geometry.Polygon.createRegularPolygon(p,0.1,360,0);
    console.log("lingkaran",p);

    var inside = p.intersects(region);
    console.log("inside",inside);
    
    dealer.addFeatures([new OpenLayers.Feature.Vector(p)]);
    ring1.addFeatures([new OpenLayers.Feature.Vector(r1)]);
    // ring2.addFeatures([new OpenLayers.Feature.Vector(r2)]);
}
/*
var p = new OpenLayers.Geometry.Point(position.lon,position.lat);
var r1 = new OpenLayers.Geometry.Point(position.lon,position.lat);
var r2 = new OpenLayers.Geometry.Point(position.lon,position.lat);

var p2 = new OpenLayers.Geometry.Point(position2.lon,position2.lat);
var r12 = new OpenLayers.Geometry.Point(position2.lon,position2.lat);
var r22 = new OpenLayers.Geometry.Point(position2.lon,position2.lat);

var p3 = new OpenLayers.Geometry.Point(position3.lon,position3.lat);
var r13 = new OpenLayers.Geometry.Point(position3.lon,position3.lat);
var r23 = new OpenLayers.Geometry.Point(position3.lon,position3.lat);

dealer.addFeatures([new OpenLayers.Feature.Vector(p),new OpenLayers.Feature.Vector(p2),new OpenLayers.Feature.Vector(p3)]);
ring1.addFeatures([new OpenLayers.Feature.Vector(r1)]);         
ring1.addFeatures([new OpenLayers.Feature.Vector(r12)]); 
ring1.addFeatures([new OpenLayers.Feature.Vector(r13)]); 
ring2.addFeatures([new OpenLayers.Feature.Vector(r2),new OpenLayers.Feature.Vector(r22),new OpenLayers.Feature.Vector(r23)]);
*/

map.addLayers([ol_sb,ol_wb,ol_tr,ring2,ring1,dealer]);
map.addControl(new OpenLayers.Control.LayerSwitcher());
map.zoomToMaxExtent();
map.setCenter(position, zoom);
//console.log("Unit",dealer.getDataExtent());
function setFocus(lon,lat){
    console.log(lon,lat);
    var lonlat = new OpenLayers.LonLat(lon, lat);
    map.panTo(lonlat);
    map.zoomTo(zoom+1);
    // map.setCenter(lonlat,10)
    // map.moveTo(lonlat,8)
}
