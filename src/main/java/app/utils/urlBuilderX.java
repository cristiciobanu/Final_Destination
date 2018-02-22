package app.utils;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class urlBuilderX {
	  
	  public static String buildWeatherUrl (String id) {
		  UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getWeatherHost())
			      .path(GlobalProperties.getWeatherPathWeather()).queryParam("appid", GlobalProperties.getWeatherId())
			      .queryParam("q", id).queryParam("units", "metric").build();
		  return url.toString();
	  }
	  
	  public static String buildSearchCityUrl (String city) {
		  UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getTeleportHost())
			      .path(GlobalProperties.getTeleportPathCities()).queryParam("search", city).queryParam("limit", 10).build();
		  return url.toString();
	  }

}