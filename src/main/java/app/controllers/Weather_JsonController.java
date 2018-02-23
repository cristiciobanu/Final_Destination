package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.models.Management;
import app.models.forecast.Lista;
import app.services.ApiCallObjectForecast;
import app.utils.urlBuilderX;

@RestController
public class Weather_JsonController {
	
	@RequestMapping("/greeting")
    public Object greeting(
    		@RequestParam(value="id", required=false, defaultValue="3181928") String id) throws Exception {
    	
    	ApiCallObjectForecast y = new ApiCallObjectForecast(urlBuilderX.buildSearchForecastUrl(id));
    	
    	
    	// MODIFICARE
    	Management m = new Management();
    	
    	Lista[] l = y.getResult().getList();

    	
    	for (int i = 0; i < l.length; i++) {
    		Lista li = l[i];
			m.addGiorniTemperature(li.getDt_txt(), li.getMain().getTemp(),li.getMain().getTemp_max(),li.getMain().getTemp_min());
			m.addIcon(li.getWeather()[0].getIcon(), li.getDt_txt());
		}
    	
        return m.jsonTemperature();
    }
}