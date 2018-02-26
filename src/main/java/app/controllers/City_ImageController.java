package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.services.ApiCallObject;
import app.utils.urlBuilderX;

@RestController
public class City_ImageController {
	
	@RequestMapping("/get_image_city")
	public Object get_image_city(
			@RequestParam(value="city", required = false) String city) {
		
		ApiCallObject y = new ApiCallObject(urlBuilderX.buildImageUrl(city));
		
	    return y.getResult();
	}
}