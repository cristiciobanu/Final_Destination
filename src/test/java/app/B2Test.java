package app;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import app.models.DatiGiorno;
import app.models.GestioneForecast;
import app.services.ApiCallObjectForecast;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class B2Test {

//	@Autowired
//	private MockMvc mockMvc;

	String res,icon;
	ApiCallObjectForecast api = new ApiCallObjectForecast("https://api.openweathermap.org/data/2.5/forecast?id=3181928&appid=68e66ece6cffc81f9c4eff0785619286");
	double result,apiMax,apiMin;
	private void init(int i) {
		// TODO Auto-generated method stub
		res = Integer.toString((int) api.getResult().getList()[i].getDt());
	}
	
	private void initDatiGiorno(int i) {
		icon = new GestioneForecast(api.getResult(), "it").getResult().get(i).getIcon();
		apiMax = new GestioneForecast(api.getResult(), "it").getResult().get(i).getT_max();
		apiMin = new GestioneForecast(api.getResult(), "it").getResult().get(i).getT_min();
	}
	
	@Test
	public void testNotNullP1 () throws Exception {
		init(0);
		JSONAssert.assertEquals("1519646400", res,true);
	}
	
	
//	@Test
//	public void testNull() throws Exception {
//		init(0);
//		JSONAssert.assertNotEquals("1", res, true);
//	}
	
	@Test
	
	public void maxTest() {
		initDatiGiorno(0);
		assert ((int)apiMax == (int)268.907);
	}
	
	@Test
	public void minTest () {
		initDatiGiorno(0);
		assert ((int)apiMin == (int)268.24375);
	}
	
	@Test
	public void icon() {
		initDatiGiorno(0);
		assert(icon.equals("01n"));
	}
	
//	@Test
//	public void testCity() throws Exception {
//		mockMvc.perform(get("/weather_station").param("id", "3181928"))
//				.andExpect(content().string(containsString("Bologna")));
//	}

}
