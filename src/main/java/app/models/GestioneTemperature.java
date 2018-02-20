package app.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import org.mockito.internal.creation.instance.InstantationException;
import org.springframework.boot.autoconfigure.jdbc.DataSourceInitializedEvent;

public class GestioneTemperature {
	Date date;
	LinkedList<TemperatureGiorno> map;
	
	public static final SimpleDateFormat DATEFORMAT= new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
	
	public GestioneTemperature() {
		map = new LinkedList<>();
		map.clear();
		date = new Date();
		
	}
	
	
	public void aggiungiTemperatura(String s, double t) throws Exception {
		Date d = DATEFORMAT.parse(s);
		if (map.containsKey(d)) {
			map.get(d).add(t);
			System.out.println("OGGETTO PRESENTE");
		}
		else {
			map.put(d, new LinkedList<Double>());
			map.get(d).add(t);
			System.out.println("NUOVO OGGETTO AGGIUNTO");
		}

	}
	
	public void aggiungiTemperatura (Date d, double t) {
		if (map.containsKey(d)) {
			map.get(d).add(t);
			System.out.println("OGGETTO PRESENTE");
		}
		else {
			map.put(d, new LinkedList<Double>());
			map.get(d).add(t);
			System.out.println("NUOVO OGGETTO AGGIUNTO");
		}
	}
	
	

	
	
	public double mediaGiorno (Date d) {
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setDate(0);
		double media = 0;
		if (d.getDay()==date.getDay()) {
			int hour = date.getHours();
			int ore = hour/3;
			LinkedList<Double>temperature = map.get(d);
			switch (ore) {
			case 0:
				for (int i = 0; i < 8; i++) {
					media+=temperature.get(i);
				}
				media/=8;
				break;
				
			case 1:
				for (int i = 0; i < 7; i++) {
					int m = i++;
					media+=temperature.get(m);
				}
				media/=7;
				break;	
				
			case 2:
				for (int i = 0; i < 6; i++) {
					int m = i+2;
					media+=temperature.get(m);
				}
				media/=6;
				break;
	
			case 3:
				for (int i = 0; i < 5; i++) {
					int m = i+3;
					media+=temperature.get(m);
				}
				media/=5;
				break;
				
	
			case 4:
				for (int i = 0; i < 4; i++) {
					int m = i+4;
					media+=temperature.get(m);
				}
				media/=4;
				break;
				
	
			case 5:
				for (int i = 0; i < 3; i++) {
					int m = i+5;
					media+=temperature.get(m);
				}
				media/=3;
				break;
				
	
			case 6:
				for (int i = 0; i < 2; i++) {
					int m = i+6;
					media+=temperature.get(m);
				}
				media/=2;
				break;
				
	
			case 7:
					media+=temperature.get(7);
				break;
				
			default:
				break;
			}
		}
		
		else {
			LinkedList<Double>list = map.get(d);
			
			for (int i = 0; i < list.size(); i++) {
				media+=list.get(i);
			}
			media/=list.size();
		}
		return media;
	}

}

//	public void aggiungiTemperatura(double t) {
//		temperature.add(t);
//	}
//	
//	public double mediaGiornoOdierno() 
//		int hour = d.getHours();
//		int ore = hour/3;
//		double media = 0;
//		switch (ore) {
//		case 0:
//			for (int i = 0; i < 8; i++) {
//				media+=temperature.get(i);
//			}
//			media/=8;
//			break;
//			
//		case 1:
//			for (int i = 0; i < 7; i++) {
//				int m = i++;
//				media+=temperature.get(m);
//			}
//			media/=7;
//			break;	
//			
//		case 2:
//			for (int i = 0; i < 6; i++) {
//				int m = i+2;
//				media+=temperature.get(m);
//			}
//			media/=6;
//			break;
//
//		case 3:
//			for (int i = 0; i < 5; i++) {
//				int m = i+3;
//				media+=temperature.get(m);
//			}
//			media/=5;
//			break;
//			
//
//		case 4:
//			for (int i = 0; i < 4; i++) {
//				int m = i+4;
//				media+=temperature.get(m);
//			}
//			media/=4;
//			break;
//			
//
//		case 5:
//			for (int i = 0; i < 3; i++) {
//				int m = i+5;
//				media+=temperature.get(m);
//			}
//			media/=3;
//			break;
//			
//
//		case 6:
//			for (int i = 0; i < 2; i++) {
//				int m = i+6;
//				media+=temperature.get(m);
//			}
//			media/=2;
//			break;
//			
//
//		case 7:
//				media+=temperature.get(7);
//			break;
//			
//		default:
//			break;
//		}
//		
//		return media;
//		
//	}