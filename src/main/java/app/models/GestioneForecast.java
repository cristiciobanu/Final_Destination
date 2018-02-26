package app.models;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;

import app.models.forecast.Forecast;
import app.models.forecast.Lista;

public class GestioneForecast {
	private LinkedList<DatiGiorno> json;
	private Lista[] liste;
	private String lang;
	
	public GestioneForecast(Forecast f, String lang) {
		setListe(f.getList());
		setLang(lang);
		json = new LinkedList<DatiGiorno>();
		popolaJson();
	}
	
	private void popolaJson() {
		double somma_min = 0;
		double somma_max = 0;
		int index = 0;
		String data_corr = costruisciData(liste[0].getDt());
		HashMap<String, Integer> lista_icone = new HashMap<String, Integer>();
		
		for (int i = 0; i < liste.length; i++) {
			if (data_corr.equals(costruisciData(liste[i].getDt()))) {
				somma_min += liste[i].getMain().getTemp_min();
				somma_max += liste[i].getMain().getTemp_max();
				if (lista_icone.containsKey(liste[i].getWeather()[0].getIcon())) {
					lista_icone.put(liste[i].getWeather()[0].getIcon(), lista_icone.get(liste[i].getWeather()[0].getIcon()) + 1);
				} else {
					lista_icone.put(liste[i].getWeather()[0].getIcon(), 1);
				}
				index++;
			}
			else {
				DatiGiorno temp = new DatiGiorno(data_corr, findIcon(lista_icone), somma_max/index, somma_min/index);
				json.add(temp);
				
				data_corr = costruisciData(liste[i].getDt());
				somma_min = 0;
				somma_max = 0;
				lista_icone.clear();
				index = 0;
				i--;
			}
		}
		
		DatiGiorno temp = new DatiGiorno(data_corr, findIcon(lista_icone), somma_max/index, somma_min/index);
		json.add(temp);
	}
	
	private String findIcon(HashMap<String, Integer> hmap) {   
    return hmap.entrySet().stream().max((entry1, entry2) -> entry1
    		.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
	}
	
	private String costruisciData(long l) {
		return new SimpleDateFormat("dd MMMM", Locale.forLanguageTag(lang)).format(new Date(l*1000L));
	}
	
	public LinkedList<DatiGiorno> getResult() {
		return json;
	}

	public Lista[] getListe() {
		return liste;
	}

	public void setListe(Lista[] liste) {
		this.liste = liste;
	}
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
}
