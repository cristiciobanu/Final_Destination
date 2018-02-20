package app.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Lista{
	
	private String dt_txt;
	private Main main;
	
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
}
