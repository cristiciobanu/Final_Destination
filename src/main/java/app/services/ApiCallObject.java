package app.services;

import org.springframework.web.client.RestTemplate;

public class ApiCallObject {
	private String url;
	private Object result;
	
	public ApiCallObject(String url) {
		setUrl(url);
		RestTemplate restTemplate = new RestTemplate();
		setResult(restTemplate.getForObject(getUrl(), Object.class));
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setResult(Object result) {
		this.result = result;
	}
	
	public Object getResult() {
		return result;
	}
}
