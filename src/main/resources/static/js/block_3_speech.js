var speechInput = (function () {

  /* DECLARING VARIABLES */
	var SpeechRecognition = SpeechRecognition || webkitSpeechRecognition;
	var recognition, $speechIcon, $text;
	var CLICK;

	/* CACHING VARIABLES */
  function _setup() {
		CLICK = false;
		recognition = new SpeechRecognition();
		recognition.lang = 'it';
		recognition.interimResults = false;
		recognition.maxAlternatives = 1;
		$speechIcon = $('.icon');
		$text = $('.input');
  }

  /* PRIVATE BUSINESS FUNCTIONS */

	var speechStart = function(){
		recognition.start();
		$speechIcon.css('color', 'red');
		document.getElementById("myText").placeholder = "In ascolto...";
		console.log('Ready to receive a color command.');
	};

	var speechResult = function(e){
		var last = e.results.length - 1;
		var word = e.results[last][0].transcript;
		console.log('Result received: ' + word);
		$text.val(word);
		searchCity.check($text.val());
	};

	var speechEnd = function(){
		recognition.stop();
		$speechIcon.css('color', 'darkgrey');
		document.getElementById("myText").placeholder = "Insert your city HERE!";
	};

	var speechError = function(e){
		$speechIcon.css('color', 'darkgrey');
		document.getElementById("myText").placeholder = "Insert your city HERE!";
		console.log('Error occurred in recognition: ' + e.error);
	};
  /* END PRIVATE BUSINESS FUNCTIONS */

  /* DECLARING EVENT HANDLER */
  function _setObserver() {
		$speechIcon.on('click',function(){
			speechStart();
		});

		recognition.onresult = function(event) {
			speechResult(event);
		};

		recognition.onspeechend = function() {
			speechEnd();
		};

		recognition.onerror = function(event) {
			speechError(event);
		};

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
