/*
    Layer AHM, dan switch layer
*/
var zoom = 8;

var map = new OpenLayers.Map("map");

var indonesia = new OpenLayers.Layer.WMS( "World Map",
    "http://t0186.astra-honda.com:7223/geoserver/gwc/service/wms", 
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
    "http://t0186.astra-honda.com:7223/geoserver/gwc/service/wms", 
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
    "http://t0186.astra-honda.com:7223/geoserver/gwc/service/wms", 
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
    "http://t0186.astra-honda.com:7223/geoserver/gwc/service/wms", 
    {
        layers: 'ahm:INA_KEC',                  
        isTiled: true,
        istransparent: false,
        isVisible: false,
        format: "image/png"
    } ,
    {isBaseLayer:false}
    );
var dealer = new OpenLayers.Layer.WMS( "Dealer",
    "http://t0186.astra-honda.com:7223/geoserver/gwc/service/wms", 
    {
        layers: 'ahm:AHMSDDPL_MSTMADLRP',                   
        isTiled: true,
        istransparent: false,
        isVisible: false,
        format: "image/png"
    } ,
    {isBaseLayer:false}
    );
var label = new OpenLayers.Layer.WMS( "Label",
    "http://t0186.astra-honda.com:7223/geoserver/gwc/service/wms", 
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
map.addLayers([indonesia,provinsi,kabupaten,kecamatan,dealer,label]);   
map.addControl(new OpenLayers.Control.LayerSwitcher());
map.zoomToMaxExtent();
console.log("layerBatas",layerBatas[0].name);
// Common Function

function setFocus(lon,lat,level){
    console.log(lon,lat,level);
    var lonlat = new OpenLayers.LonLat(lon, lat);
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
