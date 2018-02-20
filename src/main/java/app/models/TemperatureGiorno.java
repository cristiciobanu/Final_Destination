package app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class TemperatureGiorno {
	
	private Date d;
	private ArrayList<TemperaturaOra> temperature;
	
	public TemperatureGiorno(Date d) {
		setD(d);
		newList();
	}
	
	public TemperatureGiorno (Date d, int oreRimanenti) {
		setD(d);
		newList(oreRimanenti);
	}
	
	public void setTemperatura (int ora, double temperatura) {
		TemperaturaOra t = new TemperaturaOra(ora, temperatura);
		if(!contains(t)) {			
			temperature.add(t);
		}
				
	}
	
	public ArrayList<TemperaturaOra> getTemperature() {
		return temperature;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}
	
	private void newList() {
		temperature = new ArrayList<>(8);
	}
	
	private void newList(int dim) {
		temperature = new ArrayList<>(dim);
	}
	
	private double getMediaTemperature() {
		double media = 0;
		for (int i = 0; i < temperature.size(); i++) {
			media+=temperature.get(i).getTemperatura();
		}
		return media/temperature.size();
	}
	
	
	private boolean contains(TemperaturaOra t) {
		for (int i = 0; i < temperature.size(); i++) {
			if (temperature.get(i).toString().equals(t.toString())) {
				return true;
			}
		}
		return false;

	}
	
}
