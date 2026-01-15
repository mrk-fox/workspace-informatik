package rebot;


public class RobotVerwaltung {
	
	static List<Roboter> RobotList = new List<Roboter>();	//Internal list for  updates
	List<String> RSignature = new List<String>();	//Roboter Hex Signature
	static Stack<Roboter> RobotStack = new Stack<Roboter>(); //Roboter Charging system

	public static void checkBotsDebug() { //prints 
		RobotList.toFirst();
		while(RobotList.hasAccess()) {
			System.out.println(RobotList.getContent().giveName());
			System.out.println(RobotList.getContent().getBat());
			RobotList.next();
		}
	}
	
	
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
		RobotList.insert(h01);
		RobotList.toLast();
		RobotList.insert(h02);
		RobotList.toLast();
		RobotList.insert(h03);
		RobotList.toLast();
		RobotList.insert(h04);
		checkBotsDebug();
	}


	public static void minusBat() {
		RobotList.toFirst();
		while(RobotList.hasAccess()) {
			if(!RobotList.getContent().currentLoad()) {
				RobotList.getContent().changeBat(1);
			}
			else {
				RobotList.getContent().chargeBat(1);
			}
			
			System.out.println(RobotList.getContent().giveName());
			System.out.println(RobotList.getContent().getBat());
			RobotList.next();
		}
	}

	public static void checkBat() {
		RobotList.toFirst();
		while(RobotList.hasAccess()) {
			if(RobotList.getContent().getBat() < 95 && !RobotList.getContent().currentLoad()) {
				RobotStack.push(RobotList.getContent());
				System.out.println("Added to loading queue: " + RobotList.getContent().giveName());
				RobotList.getContent().changeLoad();
			}
			else if(RobotList.getContent().getBat() == 100 && RobotList.getContent().currentLoad()) {
				RobotList.getContent().changeLoad();
			}
			RobotList.next();
		}
	}
	
	public static void onEverySecond() {
		minusBat();
		checkBat();
	}
	

}

