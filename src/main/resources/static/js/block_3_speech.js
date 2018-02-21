var speechInput = (function () {

  /* DECLARING VARIABLES */
	var SpeechRecognition = SpeechRecognition || webkitSpeechRecognition;
	var SpeechGrammarList = SpeechGrammarList || webkitSpeechGrammarList;
	var SpeechRecognitionEvent = SpeechRecognitionEvent || webkitSpeechRecognitionEvent;

	var recognition;
	var speechRecognitionList;

	var $input;
	var $text;

	var CLICK;
  /* CACHING VARIABLES */
  function _setup() {
		CLICK = false;
		recognition = new SpeechRecognition();
		speechRecognitionList = new SpeechGrammarList();
		//recognition.continuous = false;
		recognition.lang = 'it';
		recognition.interimResults = false;
		recognition.maxAlternatives = 1;
		$input = $('.icon');
		$text = $('.input');
  };

  /* PRIVATE BUSINESS FUNCTIONS */

	var _privateFunction = function() {

  };

  var _privateFunctionBis = function() {

  };
  /* END PRIVATE BUSINESS FUNCTIONS */

  /* DECLARING EVENT HANDLER */
  function _setObserver() {
		$input.on('click',function() {
			alert("pulsante");
		  recognition.start();
		  console.log('Ready to receive a color command.');
		});

		recognition.onresult = function(event) {
		  // The SpeechRecognitionEvent results property returns a SpeechRecognitionResultList object
		  // The SpeechRecognitionResultList object contains SpeechRecognitionResult objects.
		  // It has a getter so it can be accessed like an array
		  // The [last] returns the SpeechRecognitionResult at the last position.
		  // Each SpeechRecognitionResult object contains SpeechRecognitionAlternative objects that contain individual results.
		  // These also have getters so they can be accessed like arrays.
		  // The [0] returns the SpeechRecognitionAlternative at position 0.
		  // We then return the transcript property of the SpeechRecognitionAlternative object

		  var last = event.results.length - 1;
		  var word = event.results[last][0].transcript;
		  console.log('Result received: ' + word);
			$text.val(word);
			searchCity.check($text.val());
		}

		recognition.onspeechend = function() {
		  recognition.stop();
		}

		recognition.onnomatch = function(event) {
		  console.log("I didn't recognise that color.");
		}

		recognition.onerror = function(event) {
		  console.log('Error occurred in recognition: ' + event.error);
		}

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
    publicFunction: _privateFunction
  };

})();
