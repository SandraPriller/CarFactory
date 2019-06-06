package at.fhsalzburg.its.nos.automobilefactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.w3c.dom.ranges.RangeException;


public class VehicleAssembly extends Production {		//Fahrzeugmontage
	private String tire;

	
	protected void randTires() {			//Funktion adaptiert aus https://www.baeldung.com/java-random-list-element
	    Random rand = new Random();
	    List<String> tireList = Arrays.asList("225/45R8 91", "195/55R7 87", "205/55R7 91", "225/45R8 89", "225/40R10 91", "225/40R10 88");	 
	    int numberOfElements = 1;
	 
	    try {
	    	for(int i = 0; i < numberOfElements; i++) {
	    		int randomIndex = rand.nextInt(tireList.size());
	    		tire = tireList.get(randomIndex);	        
	    	}
	    
	    	setTire(tire);
	    	
	    } catch(RangeException r) {
	    	System.out.println("An Error has occured!");
	    }
	}
	
	private String componentAssembly() {
		String com = "Components are put together!";
		return com;
	}
	
	private String mountTires() {				//Reifen montieren
		String tire = "Tires are mounted!";
		return tire;
	}

	public String produce(String state) {
		state = "Components are installed";	
		return state;
	}
	
	public void printCount() throws InterruptedException {
		Thread t = Thread.currentThread();
		for(int i = 2; i > 1; i--) {
			String com = componentAssembly();
			System.out.println(t.getName() + ": " + com + " --- " + i);
			wait(8000);
		}
		
		for(int i = 1; i > 0; i--) {
			String tire = mountTires();
			System.out.println(t.getName() + ": " + tire + " --- " + i);
			wait(2000);
		}
	}
	
	public String getTire() {
		return tire;
	}

	private void setTire(String tire) {
		this.tire = tire;
	}
}
