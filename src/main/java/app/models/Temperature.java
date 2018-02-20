package app.models;

import java.util.Date;

public class Temperature {
	private String d;
	private double temperatura;
	
	public Temperature(Date d, double t) {
		setD(d);
		setTemperatura(t);
	}
	
	
	public String getD() {
		return d;
	}
	public void setD(Date d) {
		String mese = "";
		
		switch (d.getMonth()) {
		case 1:
			mese = "Gennaio";
			break;
			
		case 2:
			mese = "Febbraio";
			break;
		case 3:
			mese = "Marzo";
			break;
		case 4:
			mese = "Aprile";
			break;	
		case 5:
			mese = "Maggio";
			break;	
		case 6:
			mese = "Giugno";
			break;	
		case 7:
			mese = "Luglio";
			break;	
		case 8:
			mese = "Agosto";
			break;	
		case 9:
			mese = "Settembre";
			break;	
		case 10:
			mese = "Ottobre";
			break;	
		case 11:
			mese = "Novembre";
			break;	
		case 12:
			mese = "Dicembre";
			break;	
		default:
			break;
		}
		
		this.d = d.getDay() + " "+ mese;
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
