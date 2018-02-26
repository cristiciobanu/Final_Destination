package app;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCityById() throws Exception {
		mockMvc.perform(get("/weather_station").param("id", "3181928"))
				.andExpect(content().string(containsString("Bologna")));
	}
	
	@Test
	public void testCityByName() throws Exception {
		mockMvc.perform(get("/searchCity").param("search", "bologna"))
				.andExpect(content().string(containsString("Bologna")));
	}
	
	@Test
	public void testId() throws Exception {
		mockMvc.perform(get("/getId").param("url", "https://api.teleport.org/api/cities/geonameid:3181928/"))
				.andExpect(content().string(containsString("3181928")));
	}
}
