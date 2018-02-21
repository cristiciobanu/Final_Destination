var moduloPrevisioni = (function () {

  /* DECLARING VARIABLES */
  var $city,$url,$article,index;

  /* CACHING VARIABLES */
  function _setup() {
		$city = "bologna";

		$article=("<article class='previsione'></article>");
	}
   /* PRIVATE BUSINESS FUNCTIONS */

	var _ajaxCallFromServer = function (){
		$.ajax({
			type: 'GET',
      url: "/greeting",
      dataType: 'json',
      cache: false,
			success: function (data){
				_printPrevisioni(data);
			}
		});
	}

	var _printPrevisioni = function (data) {
		data.forEach (function (element) {
			var min = Math.trunc(element.min);
			var max = Math.trunc (element.max);
			$(".previsioniSettimana").append("<article class='previsione'><p>  "+element.day+"<div>"+"</div>"+"</p><p class='minmax'>"+min+"°"+"</p><p class='minmax'>"+max+"°</p></article>");
		});
	}

  /* END PRIVATE BUSINESS FUNCTIONS */

   /* DECLARING EVENT HANDLER */
  function _setObserver() {
    _ajaxCallFromServer();
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
    start: _init
  };

})();
