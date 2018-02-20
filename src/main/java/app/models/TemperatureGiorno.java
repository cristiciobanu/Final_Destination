package app.models;

import java.util.Date;
import java.util.LinkedList;

public class TemperatureGiorno {
	
	private Date d;
	private LinkedList<TemperaturaOra> temperature;
	
	public TemperatureGiorno(Date d) {
		setD(d);
		newLinkedList();
	}
	
	public void setTemperatura (int ora, double temperatura) {
		TemperaturaOra t = new TemperaturaOra(ora, temperatura)
		for (int i = 0; i < array.length; i++) {
			
		}
				
				
		temperature.add();
	}
	
	public LinkedList<TemperaturaOra> getTemperature() {
		return temperature;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}
	
	private void newLinkedList() {
		temperature = new LinkedList<>();
		temperature.clear();
	}
	
	
	public boolean contains(TemperatureGiorno t) {
		if (this.getD())
	}
	
	private boolean contains(TemperaturaOra t) {
		for (int i = 0; i < temperature.size(); i++) {
			if (temperature.get(i).toString().equals(t.toString()))
		}

	}
	

}
