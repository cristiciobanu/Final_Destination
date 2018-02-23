package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.services.ApiCallObject;
import app.utils.Language;
import app.utils.urlBuilderX;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Controller
public class Weather_StationController {
	
	  @RequestMapping("/weather_station")
	  public String weather_station(
			  @RequestParam(value="id", required=false, defaultValue="3181928") String id, Model model,
	  		  @RequestParam(value="lang", required=false, defaultValue=new String(Language.CURRENTLANG)) String lang) throws Exception{
		  
		  ApiCallObject y = new ApiCallObject(urlBuilderX.buildWeatherUrl(id, lang));
		  Language.setConstant(lang);
		  String oggi = new SimpleDateFormat("dd MMMM").format(Calendar.getInstance().getTime());
		  
		  model.addAttribute("infoWeather", y.getResult());  
		  model.addAttribute("oggi", oggi);
		   
	      return "weather_station";
	  }
}
