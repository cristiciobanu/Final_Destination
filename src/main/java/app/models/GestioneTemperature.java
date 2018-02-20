package app.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import org.mockito.internal.creation.instance.InstantationException;
import org.springframework.boot.autoconfigure.jdbc.DataSourceInitializedEvent;

public class GestioneTemperature {
	Date date;
	ArrayList<TemperatureGiorno> giorni_temperature;	
	public static final SimpleDateFormat DATEFORMAT= new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
	
	public GestioneTemperature() {
		clearAllList();
		date = Calendar.getInstance().getTime();
	}
	
	public void addTemperatureGiorno(String s, double temp) throws Exception{
		Date d = DATEFORMAT.parse(s);
		int index = searchDate(d);
		if (index!=-1 && thisDay(d)) {
			giorni_temperature.add(index, new TemperatureGiorno(d, (24-date.getHours())/3));
		}
		
		else if (index!=-1 && !thisDay(d)) {
			giorni_temperature.add(index, new TemperatureGiorno(d));
		}
		
		else {
			System.out.println("ERROR");
		}
	}
	
	private int searchDate(Date d) {
		int index, tmp;
		index= 0;
		tmp = 0;
		for (int i = 0; i < giorni_temperature.size(); i++) {
			if (giorni_temperature.get(i).getD().getDate() == d.getDate()) {
				tmp = 1;
				index=i;
			}
			else if (giorni_temperature.get(i).getD().getDate()!=d.getDate() && tmp == 1) {
				return index;
			}
		}
		return -1;
	}
	
	private void clearAllList(){
		giorni_temperature = new ArrayList<>(5);
		giorni_temperature.clear();
	}
	
	private boolean thisDay(Date d) {
		return (d.getDate()==date.getDate());
	}
}