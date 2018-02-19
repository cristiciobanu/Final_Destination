package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import app.services.ApiCallObject;
import app.services.ApiCallObjects;
import app.utils.GlobalProperties;

@RestController
public class controlloInputJsonController {
	
	@RequestMapping("/asd")
    public Object greeting(
    		@RequestParam(value="city", required = false, defaultValue="london") String city) {
    	
    	UriComponents urlWeather = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getWeatherHost())
			      .path(GlobalProperties.getWeatherPathWeather()).queryParam("appid", GlobalProperties.getWeatherId())
			      .queryParam("q", city).build();
    	
    	ApiCallObject y = new ApiCallObject(urlWeather.toString());
    	
        return y.getResult();
    }
}