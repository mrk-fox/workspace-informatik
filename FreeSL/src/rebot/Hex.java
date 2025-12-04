package rebot;

import java.util.Random;

public class Hex {

	public static String generateUnboundedRandomHex() {
	    Random random = new Random();
	    long randomLong = random.nextLong();
	    return Long.toHexString(randomLong);
	}
		
}
