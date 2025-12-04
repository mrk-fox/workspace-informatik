package rebot;


public class RobotVerwaltung {
	
	List<Roboter> RobotList = new List<Roboter>();	//Internal list for  updates
	List<String> RSignature = new List<String>();	//Roboter Hex Signature
	Stack<Roboter> RobotStack = new Stack<Roboter>(); //Roboter Charging system


	
	
	public static void main(String[] args) {
		 runtime ts = new runtime();
	        ts.setCallback(() -> {
	            onEverySecond();
	        });

	        ts.start(true);
	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	            System.out.println("Shutting down TimeSystem...");
	            ts.stop();
	        }));
	    

	    
		
		
		Roboter h01 = new Roboter("pimeja", 1, 'a');
		Roboter h02 = new Roboter("pona", 2, 'a');
		Roboter h03 = new Roboter("nimi", 3, 'a');
		Roboter h04 = new Roboter("soweli", 4, 'b');
		int i = 0;
		while (i < 4) {
		  
		  i++;
		
		}

		
	}




	private static void onEverySecond() {
		// TODO Auto-generated method stub
		
	}

}

