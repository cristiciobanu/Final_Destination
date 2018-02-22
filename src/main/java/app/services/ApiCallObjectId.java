package app.services;

import org.springframework.web.client.RestTemplate;

import app.models.GetId;

public class ApiCallObjectId {
	private String url;
	private GetId result;
	
	public ApiCallObjectId(String url) {
		setUrl(url);
		RestTemplate restTemplate = new RestTemplate();
		setResult(restTemplate.getForObject(getUrl(), GetId.class));
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setResult(GetId result) {
		this.result = result;
	}
	
	public GetId getResult() {
		return result;
	}
}
