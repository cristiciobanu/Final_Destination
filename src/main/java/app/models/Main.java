package app.models;

public class Main {
	
	private int temp;
	
	public void setTemp(String temp) {
		this.temp = Integer.parseInt(temp);
		this.temp+= 273;
	}
	
	public int getTemp() {
		return temp;
	}

}
