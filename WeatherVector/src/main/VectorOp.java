package main;

public class VectorOp {
	public static Vector delta(Vector v1, Vector v2) {
		Temperature t_vm;
		Humidity hum_vm;
		WindSpeed windv_vm;
		WindDir windd_vm;
		Precipitation precip_vm;
		boolean isDelta_vm;
		
		t_vm = new Temperature(v1.getTemp().getTemp() - v2.getTemp().getTemp());
		hum_vm = new Humidity(v1.getHum().getHum()- v2.getHum().getHum());
		windv_vm = new WindSpeed(v1.getWindv().getSpeed() - v2.getWindv().getSpeed());
		windd_vm = new WindDir(v1.getWindd().getWDir() - v2.getWindd().getWDir());
		precip_vm = new Precipitation(v1.getPrecip().getPrecip() - v2.getPrecip().getPrecip());
		isDelta_vm = true;
		
		return new Vector(t_vm, hum_vm, windv_vm, windd_vm, precip_vm, isDelta_vm);
	}
	
	public static void print(Vector v1) {
		System.out.println(v1.getTemp().getTemp());
		System.out.println(v1.getHum().getHum());
		System.out.println(v1.getWindv().getSpeed());
		System.out.println(v1.getWindd().getWDir());
		System.out.println(v1.getPrecip().getPrecip());
		System.out.println(v1.getIsDelta());

	}
	
	public static boolean compareVectors(Vector v1, Vector v2) {
		if(v1.getTemp().getTemp() == v2.getTemp().getTemp() || 
		   v1.getHum().getHum() == v2.getHum().getHum() ||
		   v1.getWindv().getSpeed() == v2.getWindv().getSpeed() ||
		   v1.getWindd().getWDir() == v2.getWindd().getWDir() ||
		   v1.getPrecip().getPrecip() == v2.getPrecip().getPrecip()
		   ) {
			return true;
		}
		return false;
	}
	
	public static Vector addVector(Vector v1, Vector add) {
		Temperature t_vm;
		Humidity hum_vm;
		WindSpeed windv_vm;
		WindDir windd_vm;
		Precipitation precip_vm;
		boolean isDelta_vm;
		
		t_vm = new Temperature(v1.getTemp().getTemp() + add.getTemp().getTemp());
		hum_vm = new Humidity(v1.getHum().getHum() + add.getHum().getHum());
		windv_vm = new WindSpeed(v1.getWindv().getSpeed() + add.getWindv().getSpeed());
		windd_vm = new WindDir(v1.getWindd().getWDir() + add.getWindd().getWDir());
		precip_vm = new Precipitation(v1.getPrecip().getPrecip() + add.getPrecip().getPrecip());
		isDelta_vm = true;
		
		return new Vector(t_vm, hum_vm, windv_vm, windd_vm, precip_vm, isDelta_vm);
	}
}
