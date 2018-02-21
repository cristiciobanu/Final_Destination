package app.controllers;

import java.lang.management.ManagementPermission;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import app.models.Lista;
import app.models.Management;
import app.models.Temperature;
import app.services.ApiCallObject;
import app.services.ApiCallObjectWForecast;
import app.utils.GlobalProperties;

@RestController
public class Weather_JsonController {
	
	@RequestMapping("/greeting")
    public Object greeting(
    		@RequestParam(value="city", required = false, defaultValue="bologna") String city) throws Exception {
    	
    	UriComponents urlWeather = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getWeatherHost())
			      .path(GlobalProperties.getWeatherPathForecast()).queryParam("appid", GlobalProperties.getWeatherId())
			      .queryParam("q", city).queryParam("units", "metric").build();
    	
    	ApiCallObjectWForecast y = new ApiCallObjectWForecast(urlWeather.toString());
    	
    	Management m = new Management();
    	
    	Lista[] l = y.getResult().getList();

    	
    	for (int i = 0; i < l.length; i++) {
    		Lista li = l[i];
			m.addGiorniTemperature(li.getDt_txt(), li.getMain().getTemp(),li.getMain().getTemp_max(),li.getMain().getTemp_min());	
		}
    	
        return m.jsonTemperature();
    }
	

}