package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.services.ApiCallObject;
import app.utils.urlBuilderX;
import java.text.SimpleDateFormat;

@Controller
public class Weather_StationController {
	
	  @RequestMapping("/weather_station")
	  public String weather_station(
			  @RequestParam(value="city", required=false, defaultValue="bologna") String city, Model model) {
		  
		  ApiCallObject y = new ApiCallObject(urlBuilderX.buildWeatherUrl(city));
	      model.addAttribute("infoWeather", y.getResult());
	      
	      //data corrente TOP: da sistema
	      long unixSeconds = System.currentTimeMillis();
		  SimpleDateFormat sdf = new SimpleDateFormat("d MMMM");
		  String date = sdf.format(unixSeconds);
		  model.addAttribute("dataCONV", date);
		   
	      return "weather_station";
	  }
}
