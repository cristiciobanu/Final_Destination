var lang = (function () {

  /* DECLARING VARIABLES */
	var $select;
  var $link;

  /* CACHING VARIABLES */
  function _setup() {
    $select = $('.sel');
		$link = $('FORM A');
  };

  /* PRIVATE BUSINESS FUNCTIONS */
  var ajaxCall = function() {

		$.ajax({
			url: '/language',
			type: "GET",
			dataType: 'json',
			cache: false,
			success: function(data) {
				stampa(data);
			}
		});
  };

  var stampa = function(data) {

		for(var i = 0; i < Object.keys(data).length; i++){
			$select.append("<option value="+data[i].iso+">"+data[i].name+"</option>");
		}
  };
  /* END PRIVATE BUSINESS FUNCTIONS */

  /* DECLARING EVENT HANDLER */
  function _setObserver() {
    $link.on('click',function(){
			$('FORM').submit();
		});
  };

  function _init() {
    try {
      _setup();
      _setObserver();
			ajaxCall();
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

lang.start();
