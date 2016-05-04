/*
    Layer AHM, dan switch layer
*/

/* Click controller
 * Digunakan untuk mendapatkan kordinat pada saat event single click pada peta.
 * Koordinat disimpan pada variable clickPos.
 */

var clickPos;
OpenLayers.Control.Click = OpenLayers.Class(OpenLayers.Control, {                
                defaultHandlerOptions: {
                    'single': true,
                    'double': false,
                    'pixelTolerance': 0,
                    'stopSingle': false,
                    'stopDouble': true
                },

                initialize: function(options) {
                    this.handlerOptions = OpenLayers.Util.extend(
                        {}, this.defaultHandlerOptions
                    );
                    OpenLayers.Control.prototype.initialize.apply(
                        this, arguments
                    ); 
                    this.handler = new OpenLayers.Handler.Click(
                        this, {
                            'click': this.trigger
                        }, this.handlerOptions
                    );
                }, 

                trigger: function(e) {
                    var lonlat = map.getLonLatFromPixel(e.xy);
                    clickPos = lonlat;
                    clickPeta();
                }

            });

var layarBatas,map;
var zoom = 8;
var center = new OpenLayers.LonLat(122.970810,-2.367789); 

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


function buildMap(){
	layerBatas = [provinsi,kabupaten,kecamatan];

	map.addLayers([indonesia,provinsi,kabupaten,kecamatan,label]);   
	map.addControl(new OpenLayers.Control.LayerSwitcher());
	map.zoomToMaxExtent();

	map.setCenter(center, 4);
	var click = new OpenLayers.Control.Click();
	map.addControl(click);
	click.activate();
}

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



function clickPeta(){
	console.log("You click near",clickPos);
}

function renderMap(namaForm)
{
	 map = new OpenLayers.Map("map"+namaForm);
	buildMap();
}
