var searchCity = (function () {

  /* DECLARING VARIABLES */

  var $wrapper;
  var $lista;
  // var URL = "https://api.teleport.org/api/cities/?search={name}"; //"https://restcountries.eu/rest/v2/name/{name}";

  /* CACHING VARIABLES */
  function _setup() {
    $wrapper = $('.search');
    $lista = $('.lista');
  };

  /* PRIVATE BUSINESS FUNCTIONS */
  var addElement = function(data){
    console.log(data);

  };

  var getId= function(url, name) {
      $.ajax({
       url: url,
       type: "GET",
       dataType: 'json',
       cache: false,
       success: function(data) {
         $lista.append("<a href='#'><li class='element' data-id='"+data.geoname_id+"'>"+name+"</li></a>");
       }
     });
  };

  var getCountry = function(param) {
       var url = "/searchCity";
      // url = url.replace("{name}",param);
      $.ajax({
       url: url,
       type: "GET",
       data: { city: param},
       dataType: 'json',
       cache: false,
       success: function(data) {
         $wrapper.find('.lista').empty();
         data._embedded["city:search-results"].forEach(function(element){
           getId(element._links["city:item"].href, element.matching_full_name);
         });
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
