var searchCity = (function () {

  /* DECLARING VARIABLES */

  var $wrapper;
  var $lista;
  var URL = "https://api.teleport.org/api/cities/?search={name}"; //"https://restcountries.eu/rest/v2/name/{name}";

  /* CACHING VARIABLES */
  function _setup() {
    $wrapper = $('.searchCity');
    $lista = $('.lista');
  };

  /* PRIVATE BUSINESS FUNCTIONS */
  var addElement = function(data){
    console.log(data);
    $wrapper.find('.lista').empty();
    data._embedded["city:search-results"].forEach(function(element){
      $lista.append("<li class='element'>"+element.matching_full_name+"</li>"); //
    });
  };

  var getCountry = function(param) {
      var url = URL;
      url = url.replace("{name}",param);
      $.ajax({
       url: url,
       type: "GET",
       dataType: 'json',
       cache: false,
       success: function(data) {
         console.log(url);
              addElement(data);
          }
      });

  };

  var finder = function() {
    var $this = $(this);
    var text = $this.val();
    if(text.trim().length >= 2) {
       getCountry(text);
    }
  };
  /* END PRIVATE BUSINESS FUNCTIONS */

  /* DECLARING EVENT HANDLER */
  function _setObserver() {
    $wrapper.on('keyup','input',finder);
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
