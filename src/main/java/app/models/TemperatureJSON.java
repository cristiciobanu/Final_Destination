package app.models;

public class TemperatureJSON {
	
	private String day;
	private double max,min;
	
	public TemperatureJSON(String d, double max, double min) {
		setDay(d);
		setMax(max);
		setMin(min);
	}
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	
	
	

}
