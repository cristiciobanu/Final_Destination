package app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetId {
	
	private int geoname_id;

	public int getGeoname_id() {
		return geoname_id;
	}

	public void setGeoname_id(int geoname_id) {
		this.geoname_id = geoname_id;
	}

}
