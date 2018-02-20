package app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
	
	private int cnt;
	private Lista list;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Object getList() {
		return list;
	}
	public void setList(Lista list) {
		this.list = list;
	}
	
}