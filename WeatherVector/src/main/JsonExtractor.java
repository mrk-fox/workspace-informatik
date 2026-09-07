package main;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExtractor {
	
	public static JsonNode getjson(String p_tree) throws Exception, JacksonException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(p_tree);
		return json;
	}
	
	public static void print_data(String resp_b) throws Exception, JacksonException {
		
		JsonNode json = getjson(resp_b);
		double temp = json.path("current").path("temperature_2m").asDouble();
		double humidity = json.path("current").path("relative_humidity_2m").asDouble();
		double windv = json.path("current").path("wind_speed_10m").asDouble();
		double winddir = json.path("current").path("precipitation").asDouble();
		double precip = json.path("current").path("precipitation").asDouble();
		
		Vector write = new Vector(new Temperature(temp), new Humidity(humidity), new WindSpeed(windv), new WindDir(winddir), new Precipitation(precip), false);
		write.print();
	}
	
	public static Vector extVectorFromAPI(String resp_b) throws Exception, JacksonException {
		JsonNode json = getjson(resp_b);
		double temp = json.path("current").path("temperature_2m").asDouble();
		double humidity = json.path("current").path("relative_humidity_2m").asDouble();
		double windv = json.path("current").path("wind_speed_10m").asDouble();
		double winddir = json.path("current").path("precipitation").asDouble();
		double precip = json.path("current").path("precipitation").asDouble();
		
		return new Vector(new Temperature(temp), new Humidity(humidity), new WindSpeed(windv), new WindDir(winddir), new Precipitation(precip), false);
	}

	
	
}
