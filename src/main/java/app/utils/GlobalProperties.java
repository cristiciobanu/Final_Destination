package app.utils;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties("api")
public class GlobalProperties {

	private static String scheme;
    
    private static String weatherHost, weatherPathWeather, weatherPathForecast, weatherId;

	public static String getWeatherHost() {
		return weatherHost;
	}

	public static void setWeatherHost(String weatherHost) {
		GlobalProperties.weatherHost = weatherHost;
	}

	public static String getScheme() {
		return scheme;
	}

	public static void setScheme(String scheme) {
		GlobalProperties.scheme = scheme;
	}

	public static String getWeatherId() {
		return weatherId;
	}

	public static void setWeatherId(String weatherId) {
		GlobalProperties.weatherId = weatherId;
	}

	public static String getWeatherPathWeather() {
		return weatherPathWeather;
	}

	public static void setWeatherPathWeather(String weatherPathWeather) {
		GlobalProperties.weatherPathWeather = weatherPathWeather;
	}

	public static String getWeatherPathForecast() {
		return weatherPathForecast;
	}

	public static void setWeatherPathForecast(String weatherPathForecast) {
		GlobalProperties.weatherPathForecast = weatherPathForecast;
	}

}
