
package at.fhsalzburg.its.nos.automobilefactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.w3c.dom.ranges.RangeException;

//17-stellige Nummer -> Vehicle Identification number (VIN)
//Gesperrt sind die Buchstaben I, O und Q 
//aufgrund der hohen Verwechslungsgefahr mit den 
//Ziffern 0 und 1 laut https://de.wikipedia.org/wiki/Fahrzeug-Identifizierungsnummer
//Ersten drei Ziffern -> World Manufacturer Identifier (WMI)


public class Chassis extends Production {				//Fahrgestell
	private String VIN;							
	private String WMI = "WBA";					//WBA für BMW (W steht für Europa bzw. Deutschland, BA für die Automarke BMW)				
	private String PS;
	
	
	protected void generateRandString(String VIN, String WMI) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(WMI);
		
		try {
			for(int i = 0; i < 5; i++) {
				char c = (char)('A' + r.nextInt(26));
			
				if(c == 'I' || c == 'O' || c == 'Q') {
					c++;
				}
			
				sb.append(c);
				int j = (int)(0 + r.nextInt(10));
				sb.append(j);
			}

			VIN = sb.toString();
			setVIN(VIN);
			
		} catch(RangeException re) {
			System.out.println("An Error has occured!");
		}
	}
	
	protected void randPS() {				//Funktion adaptiert aus https://www.baeldung.com/java-random-list-element
	    Random rand = new Random();
	    List<String> colorList = Arrays.asList("100 PS", "110 PS", "130 PS", "150 PS", "180 PS", "200 PS", "220 PS", "250 PS", "300 PS");	 
	    int numberOfElements = 1;
	 
	    try {
	    	for(int i = 0; i < numberOfElements; i++) {
	    		int randomIndex = rand.nextInt(colorList.size());
	    		PS = colorList.get(randomIndex);	        
	    	}
	    
	    	setPS(PS);
	    	
	    } catch (RangeException r) {
			System.out.println("An Error has occured!");
		}
	}
	
	private String wheelSuspension() {			//Radaufhängung
		String wheel = "Wheel suspension is mounted!";		
		return wheel;
	}
	
	private String transmission() {				//Getriebe
		String trans = "Transmission is mounted!";		
		return trans;
	}

	private String engine() {				//Motor
		String eng = "Engine is mounted!";
		return eng;
	}

	public String produce(String state) {
		state = "Chassis is manufactured";		
		return state;
	}
	
	public void printCount() throws InterruptedException {
		Thread t = Thread.currentThread();
		for(int i = 4; i > 2; i--) {
			String wheel = wheelSuspension();
			System.out.println(t.getName() + ": " + wheel + " --- " + i);
			wait(8000);
		}
			
		for(int j = 2; j > 1; j--) {
			String trans = transmission();
			System.out.println(t.getName() + ": " + trans + " --- " + j);
			wait(6000);	
		}
			
		for(int k = 1; k > 0; k--) {
			String eng = engine();
			System.out.println(t.getName() + ": " + eng + " --- " + k);
			wait(3000);
		}
	}	
	
	public String getPS() {						
		return PS;
	}

	public void setPS(String PS) {
		this.PS = PS;
	}
	
	public String getVIN() {
		return VIN;
	}

	public void setVIN(String VIN) {
		this.VIN = VIN;
	}

	public String getWMI() {
		return WMI;
	}

	public void setWMI(String WMI) {
		this.WMI = WMI;
	}
}
