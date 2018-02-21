package app.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Management {
	
	private LinkedList<Temperature>temperature;
	public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private HashMap<String, Double> medie;
	private LinkedList<String> date;
	
	public Management() {
		clear();
	}
	
	public void addGiorniTemperature(String s, double d) throws Exception {
		Date da = DATEFORMAT.parse(s);
		Temperature t = new Temperature(da, d); 
		temperature.add(t);
		if (!date.contains(t.getD())) date.add(t.getD());
	}
	
	
	private void clear() {
		date = new LinkedList<>();
		temperature = new LinkedList();
		medie = new HashMap<>();
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
	
	public Temperature getTemperatura(int index) {
		return temperature.get(index);
	}
	
	@Override
	public String toString() {
		String s= "";
		mediaGiorni();
		for (int i = 0; i < date.size(); i++) {
			s+= date.get(i)+" "+medie.get(date.get(i))+"\n";
		}
		
		return s;
	}

}
