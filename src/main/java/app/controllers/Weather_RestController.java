package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.models.GestioneForecast;
import app.services.ApiCallObjectForecast;
import app.utils.urlBuilderX;

@RestController
public class Weather_RestController {
	
	@RequestMapping("/previsioni")
    public Object previsioni(
    		@RequestParam(value="id", required=false, defaultValue="3181928") String id,
    			@RequestParam(value="lang", required=false, defaultValue="en") String lang) throws Exception {
    	
    	ApiCallObjectForecast y = new ApiCallObjectForecast(urlBuilderX.buildSearchForecastUrl(id));
    	GestioneForecast x = new GestioneForecast(y.getResult(), lang);
    	
    	return x.getResult();
    }
}