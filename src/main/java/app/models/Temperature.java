package app.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Temperature {
	private String d;
	private double temperatura;
	
	public Temperature(Date d, double t) {
		setD(d);
		setTemperatura(t);
	}
	
	public Temperature(String s, double t) throws Exception {
		setD(s);
		setTemperatura(t);
	}
	
	public String getD() {
		return d;
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
		
		this.d = d.getDate()+"-"+ mese;
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
	
	
	public void setD(String s) throws Exception {
		Date d = Management.DATEFORMAT.parse(s);
		
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
		
		this.d = d.getDate() + "-"+mese;
	}
	
	
}
