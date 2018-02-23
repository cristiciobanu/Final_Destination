package app.utils;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class urlBuilderX {
	  
	  public static String buildWeatherUrl (String id) {
		  UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getWeatherHost())
			      .path(GlobalProperties.getWeatherPathWeather()).queryParam("appid", GlobalProperties.getWeatherId())
			      .queryParam("id", id).queryParam("units", "metric").queryParam("lang", "it").build();
		  return url.toString();
	  }
	  
	  public static String buildImageUrl (String city) {
		  UriComponents url = UriComponentsBuilder.newInstance()
	      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getTeleportHost())
	      .path(GlobalProperties.getTeleportPathStart()).path(city).path(GlobalProperties.getTeleportPathEnd()).build();
		  return url.toString();
	  }
	  
	  public static String buildSearchCityUrl (String city) {
		  UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getTeleportHost())
			      .path(GlobalProperties.getTeleportPathCities()).queryParam("search", city).queryParam("limit", 10).build();
		  return url.toString();
	  }
	  
	  public static String buildSearchForecastUrl (String id) {
		  UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getWeatherHost())
			      .path(GlobalProperties.getWeatherPathForecast()).queryParam("appid", GlobalProperties.getWeatherId())
			      .queryParam("id", id).queryParam("units", "metric").build();
		  return url.toString();
	  }
	  
	  

}
