var geo = (function () {

  /* DECLARING VARIABLES */
  var $lat, $lon;

  /* CACHING VARIABLES */
  function _setup() {
    $lat = $('input[name=lat]');
		$lon = $('input[name=lon]');
  };

  /* PRIVATE BUSINESS FUNCTIONS */
  var getLocation = function () {
  	if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition);
    } else {
      console.log("Geolocation is not supported by this browser.");
    }
	};

  var showPosition = function (position) {
    $lat.val(position.coords.latitude.toFixed(2));
    $lon.val(position.coords.longitude.toFixed(2));
	};
  /* END PRIVATE BUSINESS FUNCTIONS */

  /* DECLARING EVENT HANDLER */
  function _setObserver() {
		getLocation();
  };

  function _init() {
    try {
      _setup();
      _setObserver();
		}
    catch(e){
      console.log('%c ' + e.message, 'color:red');
      console.log('%c ' + e.stack, 'background: #222; color: #bada55');
    }
  }

  return {
    start: _init
  };

})();

geo.start();
