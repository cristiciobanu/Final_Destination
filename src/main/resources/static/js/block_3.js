var searchCity = (function () {

  /* DECLARING VARIABLES */
	var $wrapper;
  var $lista;
	var $hiddenInputId;
	var $hiddenInputL;
	var $form;
	var BOOLEAN;

	/* CACHING VARIABLES */
  function _setup() {
    $wrapper = $('.search');
    $lista = $('.lista');
		$hiddenInputId = $('.search FORM  input[name=id]');
		$hiddenInputL = $('.search FORM  input[name=lang]');
		$form =  $('.search FORM');
		BOOLEAN = true;
  };

  /* PRIVATE BUSINESS FUNCTIONS */
  const getCity = function(param) {
    getData("/searchCity?search="+param).then(
      function(response) {
				$wrapper.find('.lista').empty();
				response._embedded["city:search-results"].forEach(function(element){
					$lista.append("<li data-id='"+element._links["city:item"].href+"'><a>"+element.matching_full_name+"</a></li>");;
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

	const check = function(text){
		if(text.trim().length == 0){
			$wrapper.find('.lista').empty();
		}
		else{
			getCity(text);
		}
	};

	const refresh = function($this){
		getData("/getId?url="+$this.data('id')).then(
			function(response) {
				$hiddenInputId.val(response.geoname_id);
				$hiddenInputL.val($('.data input[name=lang]').val());
				BOOLEAN = false;
				$form.submit();
			},
			function(error) {
				console.error("Failed!", error);
			}
		);
	};
  /* END PRIVATE BUSINESS FUNCTIONS */

  /* DECLARING EVENT HANDLER */
  function _setObserver() {
		$form.on('submit', function(e){
  			if(BOOLEAN === true){
    			e.preventDefault();
				}
		});

    $wrapper.on('keyup','input',function(){
			check($(this).val());
		});

		$lista.on('click','li', function(){
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
    start: _init,
		check: check
  };

})();
