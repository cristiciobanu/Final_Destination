package app.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class Management {
	
	private LinkedList<Temperature>temperature;
	public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss");
	private HashMap<String, Double> medie;
	private LinkedList<String> date;
	
	public Management() {
		clear();
	}
	
	public void addGiorniTemperature(String s, double d) throws Exception {
		Date date = DATEFORMAT.parse(s);
		temperature.add(new Temperature(date, d));
	}
	
	
	private void clear() {
		temperature = new LinkedList();
	}
	
	private void mediaGiorni () {
		getDate();
		for (int i = 0; i < date.size(); i++) {
			medie.put(date.get(i), media(date.get(i)));
		}
	}
	
	private double media (String string) {
		double m = 0;
		int index = 0;
		for (int i = 0; i < temperature.size(); i++) {
			if (temperature.get(i).getD()== string) {
				m+=temperature.get(i).getTemperatura();
				index++;
			}
		}
		
		return m/=index;
	}
	
	private void getDate () {
		for (int i = 0; i < temperature.size(); i++) {
			String data = temperature.get(i).getD();
			if (!date.contains(data)) {
				date.add(data);
			}
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for (String key : medie.keySet()) {
			s+=key+" TEMPERATURA "+medie.get(key)+"K\n";
		}
		return s;
	}

}
