package main;

public class Vector {
	Temperature temp;
	Humidity hum;
	WindSpeed windv;
	WindDir windd;
	Precipitation precip;
	boolean isDelta;
	
	public Vector(
		    Temperature p_temp,
			Humidity p_hum,
			WindSpeed p_windv,
			WindDir p_windd,
			Precipitation p_precip,
			boolean p_delta) {
		temp = p_temp;
		hum = p_hum;
		windv = p_windv;
		windd = p_windd;
		precip = p_precip;
		isDelta = p_delta;
	}
	
	// get
	public Temperature getTemp() { return temp; }
	public Humidity getHum() { return hum; }
	public WindSpeed getWindv() { return windv; }
	public WindDir getWindd() { return windd; }
	public Precipitation getPrecip() { return precip; }
	public boolean getIsDelta() {return isDelta;}

	// set
	public void setTemp(Temperature temp) { this.temp = temp; }
	public void setHum(Humidity hum) { this.hum = hum; }
	public void setWindv(WindSpeed windv) { this.windv = windv; }
	public void setWindd(WindDir windd) { this.windd = windd; }
	public void setPrecip(Precipitation precip) { this.precip = precip; }
	public void setDelta(boolean s_delta) { this.isDelta = s_delta; }
	
	
	public void print() {
	    System.out.println("Temperature:   " + this.getTemp().getTemp());
	    System.out.println("Humidity:      " + this.getHum().getHum());
	    System.out.println("Wind Speed:    " + this.getWindv().getSpeed());
	    System.out.println("Wind Direction:" + this.getWindd().getWDir());
	    System.out.println("Precipitation: " + this.getPrecip().getPrecip());
	    System.out.println("Delta Flag: " + this.getIsDelta());

	}
}
