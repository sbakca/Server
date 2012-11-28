package json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Decoder {

	private double longtitude = 0;
	private double latitude = 0;
	private String time = "";
	private String username = "";
	private String password = "";
	private boolean available = false;

	public Decoder(String jsonString) {
		JSONObject info = JSONObject.fromObject(jsonString);
		JSONArray location = info.getJSONArray("location");

		longtitude = Double.parseDouble(location.getString(0));
		latitude = Double.parseDouble(location.getString(1));
		time = info.getString("time");
		username = info.getString("username");
		password = info.getString("password");
		available = true;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getTime() {
		return time;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public boolean isAvailable() {
		return available;
	}

}
