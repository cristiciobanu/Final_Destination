package app.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class Management {
	public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private LinkedList<Temperature>temperature;
	private LinkedList<Icon> icons;
	private HashMap<String, String>iconCodes;
	private LinkedList<String> date;
	private HashMap<String, Double> massime;
	private HashMap<String, Double> minime;
	
	
	public Management() {
		clear();
	}
	
	public String maxTimesIcon(String day){
		String str = "";
		LinkedList<String>tmpCodes = new LinkedList<>();
		
		for (int i = 0; i < icons.size(); i++) {
			Icon tmp = icons.get(i);
			if (tmp.getDay().equals(day)&&!tmpCodes.contains(tmp.getCodIcon())) tmpCodes.add(tmp.getCodIcon());
		}
		
		HashMap<Integer,String>times = new HashMap<>();
		for (int i = 0; i < tmpCodes.size(); i++) {
			times.put(Collections.frequency(tmpCodes,tmpCodes.get(i)),tmpCodes.get(i));
		}
		
		int max = 0;
		for (int temp : times.keySet()) {
			max = Math.max(max, temp);
		}
		
		return times.get(max);
	}
	
	public void addGiorniTemperature(String s, double temp, double tempMax, double tempMin) throws Exception{
		Date da = DATEFORMAT.parse(s);
		Temperature t = new Temperature(da, temp,tempMax,tempMin); 
		temperature.add(t);
		if (!date.contains(t.getD())) date.add(t.getD());
	}
	
	public void addIcon (String codIcon, String day) throws Exception {
		Date da = DATEFORMAT.parse(day);
		Icon i = new Icon(codIcon, da);
		icons.add(i);
	}
	
	private void clear() {
		date = new LinkedList<>();
		temperature = new LinkedList();
		icons = new LinkedList<>();
		minime = new HashMap<>();
		massime = new HashMap<>();
		iconCodes = new HashMap<>();
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
	
	private void setDate () {
		for (int i = 0; i < temperature.size(); i++) {
			String data = temperature.get(i).getD();
			if (!date.contains(data)) {
				data.replaceAll("-", " ");
				date.add(data);
			}
		}
	}
	
	private Double [] maxMinTemperatura (String giorno) {
		double max,min;
		LinkedList<Double>elenco= new LinkedList<>();
		if (date.contains(giorno)) {
			for (int i = 0; i < temperature.size(); i++) {
				if (temperature.get(i).getD().equals(giorno)) {
					elenco.add(temperature.get(i).getTemperatura());
				}
			}
			
			max=elenco.get(0);
			min = elenco.get(0);
			for (int i = 0; i < elenco.size(); i++) {
				max=Math.max(max, elenco.get(i));
				min=Math.min(min, elenco.get(i));
			}
			return new Double [] {max, min};
			
		}
		
		else {
			max = -1;
			min = -1;
			return new Double[] {max,min};
		}
	}
	
	public Temperature getTemperatura(int index) {
		return temperature.get(index);
	}
	
	private void init () {
			for (int i = 0; i < date.size(); i++) {
				String d = date.get(i);
				massime.put(d, max_min_giorno(d,"max"));
				minime.put(d, max_min_giorno(d,"min"));
				iconCodes.put(d, maxTimesIcon(d));
			}
	}
	
	private double max_min_giorno(String giorno, String search) {
		LinkedList <Double> elenco = new LinkedList<>();
		double res = 0;
		if (date.contains(giorno)) {
			switch (search) {
			case "max":
				for (int i = 0; i < temperature.size(); i++) {
					Temperature t = temperature.get(i);
					if (t.getD().equals(giorno)) elenco.add(t.getTempMax());
				}
				double max = Double.MIN_VALUE;
				
				for (int i = 0; i < elenco.size(); i++) {
					max=Math.max(max, elenco.get(i));
				}
				
				res = max;
				break;
				
			case "min":
				for (int i = 0; i < temperature.size(); i++) {
					Temperature t = temperature.get(i);
					if (t.getD().equals(giorno)) elenco.add(t.getTempMin());
				}
				double min = Double.MAX_VALUE;
				
				for (int i = 0; i < elenco.size(); i++) {
					min=Math.min(min, elenco.get(i));
				}
				
				res = min;
				break;
				
				default:
				break;
			}
			
			return res;
		}
		
		return 0;
	}

	public TemperatureJSON [] jsonTemperature () {
		TemperatureJSON [] temp = new TemperatureJSON [date.size()];
		setDate();
		init();
		for (int i = 0; i < temp.length; i++) {
			String d = date.get(i);
			temp[i] = new TemperatureJSON(d, massime.get(d), minime.get(d),iconCodes.get(d));
		}
		return temp;
	}
	
}
