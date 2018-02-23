var moduloPrevisioni = (function () {

  /* DECLARING VARIABLES */
	var $appendTO, $cityID;
  /* CACHING VARIABLES */
  function _setup() {
		$appendTO = $(".previsioniSettimana");
		$cityID = $(".nome-citta");
	}

  /* PRIVATE BUSINESS FUNCTIONS */

	var _ajaxCallFromServer = function (){
		$.ajax({
			type: 'GET',
      url: "/greeting",
      dataType: 'json',
      cache: false,
			data: {"id": $cityID.data("id")},
			success: function (data){
				_printPrevisioni(data);
			}
		});
	}

	var _printPrevisioni = function (data) {
		data.forEach (function (element) {
			var min = Math.trunc(element.min);
			var max = Math.trunc (element.max);

			$appendTO.append("<article><p>" + element.day + "</p><i class='fas icon_" + element.iconCode + "d'></i><p>" + min + "°</p><p>" + max + "°</p></article>");
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
