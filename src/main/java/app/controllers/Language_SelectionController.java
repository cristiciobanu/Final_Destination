package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import app.utils.Language;

@RestController
public class Language_SelectionController {
	
	@RequestMapping("/language")
	public Object language() throws JsonProcessingException {
		
	    return Language.ret();
	}
	
	@RequestMapping("/currentLang")
	public Object urrentLang() throws JsonProcessingException {
		
	    return Language.getCurrentLang();
	}
	
	
}