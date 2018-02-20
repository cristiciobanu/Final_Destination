package app.services;

import org.springframework.web.client.RestTemplate;

import app.models.Forecast;

public class ApiCallObjectWForecast {
	private String url;
	private Forecast result;
	
	public ApiCallObjectWForecast(String url) {
		setUrl(url);
		RestTemplate restTemplate = new RestTemplate();
		setResult(restTemplate.getForObject(getUrl(), Forecast.class));
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setResult(Forecast result) {
		this.result = result;
	}
	
	public Forecast getResult() {
		return result;
	}
}
