package app.models;

public class DatiGiorno {
	private String day, icon;
	private double t_max, t_min;
	
	public DatiGiorno(String day, String icon, double t_max, double t_min) {
		super();
		this.day = day;
		this.icon = icon;
		this.t_max = t_max;
		this.t_min = t_min;
	}
	
	public double getT_max() {
		return t_max;
	}
	public void setT_max(double t_max) {
		this.t_max = t_max;
	}
	public double getT_min() {
		return t_min;
	}
	public void setT_min(double t_min) {
		this.t_min = t_min;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icona) {
		this.icon = icona;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String data) {
		this.day = data;
	}

}