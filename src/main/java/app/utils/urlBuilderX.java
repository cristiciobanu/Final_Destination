package app.utils;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class urlBuilderX {
	  
	  public String buildWeatherUrl (String id) {
		  UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme(GlobalProperties.getScheme()).host(GlobalProperties.getWeatherHost())
			      .path(GlobalProperties.getWeatherPathWeather()).queryParam("appid", GlobalProperties.getWeatherId())
			      .queryParam("q", id).queryParam("units", "metric").build();
		  return url.toString();
	  }

}
