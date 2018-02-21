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
public class Weather_InputController {
	
	@RequestMapping("/searchCity")
    public Object searchCity(
    		@RequestParam(value="search", required = false) String city)
    		{
    	
    	UriComponents urlcity = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getTeleportHost())
			      .path(GlobalProperties.getTeleportPathCities()).queryParam("search", city).queryParam("limit", 10).build();
    	
    	ApiCallObject y = new ApiCallObject(urlcity.toString());
    	
        return y.getResult();
    }
	
	@RequestMapping("/getId")
    public Object getId(
    		@RequestParam(value="url", required = false) String url) {
    	
    	ApiCallObject y = new ApiCallObject(url);
    	
        return y.getResult();
    }
}