package app.models;

import java.util.Date;

public class Icon {
	
	private String codIcon,day;
	
	public Icon(String codIcon, Date day) {
		setCodIcon(codIcon);
		setDay(day);
	}

	public void setDay(Date day) {
		String mese = "";
		
		switch (day.getMonth()) {
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
		
		this.day = day.getDate()+" "+ mese;
	
	}
	
	public String getDay() {
		return day;
	}
	
	public String getCodIcon() {
		return codIcon;
	}

	public void setCodIcon(String codIcon) {
		int index = Integer.MIN_VALUE;
		if (codIcon.contains("d")) {
			index = codIcon.indexOf("d");			
		}
		
		else {
			index = codIcon.indexOf("n");
		}
		this.codIcon = codIcon.substring(0, index);	
	}
	
	

}
