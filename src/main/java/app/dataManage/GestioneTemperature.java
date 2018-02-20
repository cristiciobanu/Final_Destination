package app.dataManage;

import java.util.Date;
import java.util.LinkedList;

public class GestioneTemperature {
	Date d = new Date();
	LinkedList<Double> temperature;
	
	public GestioneTemperature() {
		temperature = new LinkedList<>();
		temperature.clear();
	}
	
	
	public void aggiungiTemperatura(double t) {
		temperature.add(t);
	}
	
	public double mediaGiorno() {
		int hour = d.getHours();
		int ore = hour/3;
		double media = 0;
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
		
		return media;
		
	}

}
