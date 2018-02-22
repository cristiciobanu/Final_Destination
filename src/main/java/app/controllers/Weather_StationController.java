package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.services.ApiCallObject;
import app.utils.urlBuilderX;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Controller
public class Weather_StationController {
	
	  @RequestMapping("/weather_station")
	  public String weather_station(
			  @RequestParam(value="id", required=false, defaultValue="3181928") String id, Model model) {
		  
		  ApiCallObject y = new ApiCallObject(urlBuilderX.buildWeatherUrl(id));
		  String oggi = new SimpleDateFormat("dd MMMM").format(Calendar.getInstance().getTime());
		  
		  model.addAttribute("infoWeather", y.getResult());  
		  model.addAttribute("oggi", oggi);
		   
	      return "weather_station";
	  }
}
