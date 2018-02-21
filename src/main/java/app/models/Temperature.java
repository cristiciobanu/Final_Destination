package app.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Temperature {
	private String d;
	private double temperatura,tempMax,tempMin;
	
	public Temperature(Date d, double t,double tM, double tm) {
		setD(d);
		setTemperatura(t);
		setTempMax(tM);
		setTempMin(tm);	
	}
	
	public Temperature (String d,double tM, double tm) {
		setD(d);
		setTempMax(tM);
		setTempMin(tm);
	}
	
	
	private void setD(String s) {
		this.d=s;
	}
	
	public String getD() {
		return d;
	}
	
	public double getTempMax() {
		return tempMax;
	}
	
	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}
	
	public double getTempMin() {
		return tempMin;
	}
	
	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}
	
	public void setD(Date d) {
		String mese = "";
		
		switch (d.getMonth()) {
		case 0:
			mese = "Gennaio";
			break;		
		case 1:
			mese = "Febbraio";
			break;
		case 2:
			mese = "Marzo";
			break;
		case 3:
			mese = "Aprile";
			break;	
		case 4:
			mese = "Maggio";
			break;	
		case 5:
			mese = "Giugno";
			break;	
		case 6:
			mese = "Luglio";
			break;	
		case 7:
			mese = "Agosto";
			break;	
		case 8:
			mese = "Settembre";
			break;	
		case 9:
			mese = "Ottobre";
			break;	
		case 10:
			mese = "Novembre";
			break;	
		case 11:
			mese = "Dicembre";
			break;	
		default:
			break;
		}
		
		this.d = d.getDate()+" "+ mese;
	}
	
	public double getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	@Override
	public String toString() {
		return "DATA: "+d.toString()+"\nTEMPERATURA: "+temperatura;
	}
	
	
}
