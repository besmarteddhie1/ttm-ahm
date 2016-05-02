/*
    Layer AHM, dan switch layer
*/
var zoom = 8;
var center = new OpenLayers.LonLat(122.970810,-2.367789); 

var map = new OpenLayers.Map("map");
var wmsUrl = "http://t0186.astra-honda.com:7223/geoserver/gwc/service/wms";

var indonesia = new OpenLayers.Layer.WMS( "World Map",
    wmsUrl, 
    {
        layers: 'indonesia',                    
        isTiled: true,
        isTransparent: false,
        isVisible: true,
        format: "image/png"                 
    },
    {isBaseLayer:true}
    );

var provinsi = new OpenLayers.Layer.WMS( "Provinsi",
		wmsUrl, 
    {
        layers: 'ahm:INA_PROP',                 
        isTiled: true,
        istransparent: false,
        isVisible: false,
        format: "image/png"
    } ,
    {
        isBaseLayer:false,
        attribution:"Provided by AHM"
    }
    );  
var kabupaten = new OpenLayers.Layer.WMS( "Kabupaten",
		wmsUrl, 
    {
        layers: 'ahm:INA_KAB',                  
        isTiled: true,
        istransparent: false,
        isVisible: false,
        format: "image/png"
    } ,
    {isBaseLayer:false}
    );
var kecamatan = new OpenLayers.Layer.WMS( "Kecamatan",
		wmsUrl, 
    {
        layers: 'ahm:INA_KEC',                  
        isTiled: true,
        istransparent: false,
        isVisible: false,
        format: "image/png"
    } ,
    {isBaseLayer:false}
    );

var label = new OpenLayers.Layer.WMS( "Label",
		wmsUrl, 
    {
        layers: 'label',                    
        istiled: false,
        istransparent: true,
        isvisible: false,
        format: "image/png"                 
    } ,
    {isBaseLayer:false}
    );              

var layerBatas = [provinsi,kabupaten,kecamatan];

map.addLayers([indonesia,provinsi,kabupaten,kecamatan,label]);   
map.addControl(new OpenLayers.Control.LayerSwitcher());
map.zoomToMaxExtent();

map.setCenter(center, 4);
// Common Function

function setFocus(lon,lat,level){
    console.log(lon,lat,level);
    var lonlat = new OpenLayers.LonLat(lon, lat);
    console.log("lonlat",lonlat);
    for(i=0;i<layerBatas.length;i++){
    	if(level == i+1){
    		layerBatas[i].setVisibility(true);
    	}else{
    		layerBatas[i].setVisibility(false);
    	}
    }
    map.panTo(lonlat);
    map.zoomTo(zoom+1+level);
}
