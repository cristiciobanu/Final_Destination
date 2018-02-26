package app.models.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
	
	private int cnt;
	private Lista[] list;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Lista[] getList() {
		return list;
	}
	public void setList(Lista[] list) {
		this.list = list;
	}
	
}