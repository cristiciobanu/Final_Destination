package app.utils;

import java.util.Map;
import java.util.TreeMap;



public class Language {
	
	public static Map<String, String> currentLang;
	static{
		currentLang= new TreeMap<String, String>();
		currentLang.put("lang", "");
	}
	
	public static final Map<String, String> language;
	static {
		language = new TreeMap<String, String>();
		language.put("Arabic", "ar");
		language.put("Bulgarian ", "bg");
		language.put("Catalan ", "ca");
		language.put("Czech ", "cz");
		language.put("German ", "de");
		language.put("Greek", "el");
		language.put("English ", "en");
		language.put("Persian (Farsi)", "fa");
		language.put("Finnish ", "fi");
		language.put("French ", "fr");
		language.put("Galician ", "gl");
		language.put("Croatian ", "hr");
		language.put("Hungarian ", "hu");
		language.put("Italian ", "it");
		language.put("Japanese ", "ja");
		language.put("Korean ", "kr");
		language.put("Latvian ", "la");
		language.put("Lithuanian ", "lt");
		language.put("Macedonian ", "mk");
		language.put("Dutch ", "nl");
		language.put("Polish ", "pl");
		language.put("Portuguese ", "pt");
		language.put("Romanian ", "ro");
		language.put("Russian ", "ru");
		language.put("Swedish ", "se");
		language.put("Slovak ", "sk");
		language.put("Slovenian ", "sl");
		language.put("Spanish ", "es");
		language.put("Turkish ", "tr");
		language.put("Ukrainian ", "ua");
		language.put("Vietnamese ", "vi");
		language.put("Chinese Simplified", "zh_cn");
	}
	
	public static TreeMap<Integer, Object> ret(){
		TreeMap<Integer, Object> ret = new TreeMap<Integer, Object>();
		Integer i = 0;
		for(Map.Entry<String, String> entry : language.entrySet()) {
			TreeMap<String, Object> r = new TreeMap<String, Object>();
			r.put("name", entry.getKey());
			r.put("iso", entry.getValue());
			ret.put(i, r);
			i++;
		}
		return ret;	
	}
	
	public static Map<String, String> getCurrentLang() {
		return currentLang;
	}
	
	public static void setCurrentLang(String lang) {
		currentLang.replace("lang", Language.getCurrentLang().get("lang"), lang);
	}
}
