var searchCity = (function () {

  /* DECLARING VARIABLES */

  var $wrapper;
  var $lista;
	var $a;
	var BOOLEAN;
  /* CACHING VARIABLES */
  function _setup() {
    $wrapper = $('.search');
    $lista = $('.lista');
		$a = $('UL');
		BOOLEAN = true;
  };

  /* PRIVATE BUSINESS FUNCTIONS */
  const getCity = function(param) {
    getData("/searchCity?search="+param).then(
      function(response) {
				$wrapper.find('.lista').empty();
				response._embedded["city:search-results"].forEach(function(element){
					$lista.append("<a href='#'><li class='element' data-id='"+element._links["city:item"].href+"'>"+element.matching_full_name+"</li></a>");;
				 });
      },
      function(error) {
        console.error("Failed!", error);
      }
    );
  };


  const getData = function(url) {
    // Return a new promise.
    return new Promise(function(resolve, reject) {
      // Do the usual XHR stuff
      var req = new XMLHttpRequest();
      req.open('GET', url);

      req.onload = function() {
        // This is called even on 404 etc
        // so check the status
        if (req.status == 200) {
          // Resolve the promise with the response text
          resolve(req.response);
        }
        else {
          // Otherwise reject with the status text
          // which will hopefully be a meaningful error
          reject(Error(req.statusText));
        }
      };
      // Handle network errors
      req.onerror = function() {
        reject(Error("Network Error"));
      };

      // Make the request
      req.responseType = 'json';
      req.send();
    });
  };

	var check = function(){
		var $this = $(this);
		var text =$this.val();
			if(text.trim().length == 0){
				$wrapper.find('.lista').empty();
			}
			else{
				getCity(text);
			}
	};

	var refresh = function($this){+
		getData($this.find('LI').data('id')).then(
			function(response) {
				$('input[type=hidden]').val(response.geoname_id);
				console.log(response.geoname_id);
			},
			function(error) {
				console.error("Failed!", error);
			}
		);
		BOOLEAN = false;
		$('.form').submit();
	};
  /* END PRIVATE BUSINESS FUNCTIONS */

  /* DECLARING EVENT HANDLER */
  function _setObserver() {
		$(document).ready(function() {
  		$('form').on('submit', function(e){
    			if(BOOLEAN === true){
      			e.preventDefault();
					}
  		});
		});
    $wrapper.on('keyup','input',check);
		$a.on('click','a', function(){
			var $this = $(this);
			refresh($this);
		});
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
