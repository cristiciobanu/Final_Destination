package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.services.ApiCallObject;
import app.services.ApiCallObjectId;
import app.utils.urlBuilderX;

@RestController
public class Weather_InputController {
	
	@RequestMapping("/searchCity")
    public Object searchCity( @RequestParam(value="search", required = false) String city ) {
    	
    	ApiCallObject y = new ApiCallObject(urlBuilderX.buildSearchCityUrl(city).toString());
    	
        return y.getResult();
    }
	
	@RequestMapping("/getId")
    public Object getId( @RequestParam(value="url", required = false) String url) {
    	
    	ApiCallObjectId y = new ApiCallObjectId(url);
    	
        return y.getResult();
    }
}