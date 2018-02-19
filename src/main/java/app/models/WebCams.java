package app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebCams {
	
	private String name;
    private String url;
    
    public String getName() {
		return name;
	}
    
    public String getUrl() {
		return url;
	}

}
