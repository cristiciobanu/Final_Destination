var getCountryModule = (function () {

  /* DECLARING VARIABLES */
  var $wrapper,
      $itemTemplate = $(<img src="" />;

  function setted() {
    RESTURL = "**";
    }
  }
  /* CACHING VARIABLES */
  function _setup() {
    $wrapper = $('.preferiti');
  };

   /* PRIVATE BUSINESS FUNCTIONS */
  var _aggiungere = function(attributo,tipo,$appendTO) {
    var $createEl = $itemTemplate.attr("data-" + tipo + "-type",attributo).clone();
    $createEl.find('img').attr('src',attributo);
    $appendTO.append($createEl);
  };

 var _filteringData = function(data) {
    $wrapper.find('.list-group').empty();
    data.forEach(function(element){
      _aggiungere(element.image_url,"country",$wrapper.find('.list-group'));
    });
 }

  var _getCountry = function(param, usingInternal) {
    var url = setted();
    $.ajax({
      url: url,
      type: "GET",
      dataType: 'json',
      cache: false,
      success: function(data) {
         if(usingInternal)
           _filteringData(data)
      }
    });
  }

getCountryModule.start();
