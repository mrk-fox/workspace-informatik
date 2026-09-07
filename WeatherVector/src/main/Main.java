package main;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {
	
	static List<Vector> currentdata = new List<Vector>();
	static List<Vector> diffdata = new List<Vector>();
	
	public static void main(String[] args) throws Exception{
		double latitude = 51.6163;
		double longitude = 7.5287;
		
		//threading the api aqi
		Thread fetchThread = new Thread(() -> {
		    while (true) {
		        try {
		            HttpClient client = HttpClient.newHttpClient();

		            HttpRequest request = HttpRequest.newBuilder()
		                    .uri(URI.create("https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m,relative_humidity_2m,wind_speed_10m,wind_direction_10m,precipitation&timezone=Europe%2FBerlin&forecast_days=1"))
		                    .GET()
		                    .build();

		            HttpResponse<String> response =
		                    client.send(request, HttpResponse.BodyHandlers.ofString());

		            System.out.println(response.body());
		            //JsonExtractor.print_data(response.body());
		            
		            currentdata.append(JsonExtractor.extVectorFromAPI(response.body()));
		            currentdata.toLast();
		            
		            VectorOp.print(currentdata.getContent());
		            
		            if (currentdata.getBefore() != null) {
		            	Vector previousToLast = currentdata.getBefore();
		            	VectorOp.print(previousToLast);
		            	if (VectorOp.compareVectors(currentdata.getContent(), previousToLast)) { //has to be negated to get real diff
		            		diffdata.append(VectorOp.delta(currentdata.getContent(), previousToLast));
		            		diffdata.toLast();
		            		System.out.println("Delta Vector:");
		            		VectorOp.print(diffdata.getContent());
		            		
		            		//calculate prediction:
		            		VectorOp.print(VectorOp.addVector(currentdata.getContent(), diffdata.getContent()));
		            		
		            	}
		            	
		            
		            }
		            
		            
		            
		            
		            //yourMethod

		            
		            //thread manager
		            Thread.sleep(10 * 1000); // 10 minutes: 10 * 60 * 1000

		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		            System.out.println("Thread interrupted.");
		            break;
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});

		fetchThread.setDaemon(true); // stops when main program exits
		fetchThread.start();
		
		while (true) {
		    Thread.sleep(Long.MAX_VALUE);
		}
	}

}
