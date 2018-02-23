package app.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.TreeMap;



public class Language {
	
	public static final char[] CURRENTLANG = {'i','t'};
	public static final String CURRENTLANGS = "";
	
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
	
	 public static String getCurrentLang() throws Exception, Exception
	    {
		//try updating a String field first
         Field field = Language.class.getDeclaredField( "CURRENLANG" );
         field.setAccessible( true );

         //'modifiers' - it is a field of a class called 'Field'. Make it accessible and remove
         //'final' modifier for our 'CONSTANT' field
         Field modifiersField = Field.class.getDeclaredField( "modifiers" );
         modifiersField.setAccessible( true );
         modifiersField.setInt( field, field.getModifiers() & ~Modifier.FINAL );

         //it updates a field, but it was already inlined during compilation...
         field.set( null, new String(CURRENTLANG) );
         
         return getConstantReflection();
	    }
	 
	 public static String getConstantReflection(){
		 try{
			 final Field fld = Language.class.getDeclaredField( "CURRENTLANG" );
	            return (String) fld.get( null );
	        }catch (NoSuchFieldException e) {
	            return null;
	        }catch (IllegalAccessException e) {
	            return null;
	        }
	}

	public static void setConstant(String lang) throws Exception, Exception{
		{
            //now try to update not constant expression type field
            Field field = Language.class.getDeclaredField( "CURRENTLANG" );
            field.setAccessible( true );
 
            //'modifiers' - it is a field of a class called 'Field'. Make it accessible and remove
            //'final' modifier for our 'CONSTANT' field
            Field modifiersField = Field.class.getDeclaredField( "modifiers" );
            modifiersField.setAccessible( true );
            modifiersField.setInt( field, field.getModifiers() & ~Modifier.FINAL );
 
            //this update should actually work
            field.set( null, new String(lang).toCharArray() );
        }
	}
	
}
