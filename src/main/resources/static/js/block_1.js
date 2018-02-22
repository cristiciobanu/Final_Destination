var imageFinder = (function () {

  /* DECLARING VARIABLES */
  var $img;

  /* CACHING VARIABLES */
  function _setup() {
    $img = $('.city-img');
  };

  /* PRIVATE BUSINESS FUNCTIONS */
  var _findImage = function() {
		var $param = $(".nome-citta").text().toLowerCase();
		$.ajax({
		  url: '/get_image_city',
		  type: "GET",
		  dataType: 'json',
		  cache: false,
			data: {"city": $param},
		  success: function(data) {
				$img.attr('src', data.photos[0].image.mobile);
			},
			error: function() {
				$img.attr('src', "https://scontent-sea1-1.cdninstagram.com/t51.2885-15/e35/12751291_1435923909815440_331812237_n.jpg");
			}
		});
  };

  /* END PRIVATE BUSINESS FUNCTIONS */

  /* DECLARING EVENT HANDLER */
  function _setObserver() {
    _findImage();
  };

  function _init() {
    try {
      _setup();
      _setObserver();
    }
    catch(e) {
        console.log('%c ' + e.message, 'color:red');
        console.log('%c ' + e.stack, 'background: #222; color: #bada55');
    }
  }

  return {
    start: _init,
  };

})();
