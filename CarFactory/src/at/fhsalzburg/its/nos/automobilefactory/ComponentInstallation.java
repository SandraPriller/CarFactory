package at.fhsalzburg.its.nos.automobilefactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.w3c.dom.ranges.RangeException;


public class ComponentInstallation extends Production {					//Komponenteneinbau
	private String extras;
	private String extras1;
	private int price;
	private int price1;
	
	
	protected synchronized void randExtras() {					//Funktion adaptiert aus https://www.baeldung.com/java-random-list-element
	    Random rand = new Random();										
	    List<String> extraList = Arrays.asList("Sunroof", "Navigation Device", "Leather Interior", "Air Conditioner", "Heated Seats", "Parking Assistant", "Multifunctional Steering Wheel");	 
	    int numberOfElements = 1;
	 
	    try {
	    	for(int i = 0; i < numberOfElements; i++) {
	    		int randomIndex = rand.nextInt(extraList.size());
	    		extras = extraList.get(randomIndex);
	    	}
	    
	    	setExtras(extras);
	    
	    	for(int i = 0; i < numberOfElements; i++) {
	    		int randomIndex = rand.nextInt(extraList.size());
	    		extras1 = extraList.get(randomIndex);
	        
	    		while(extras1.equals(getExtras())) {				//Die Methode wurde auch synchronisiert, da es vorkam, dass beispielsweise
	    			randomIndex = rand.nextInt(extraList.size());		//das Auto 2 Schiebedächer hatte
	    			extras1 = extraList.get(randomIndex);		    	
	    		} 
	    			setExtras1(extras1);
	    	}
	    	
	    } catch (RangeException r) {
	    	System.out.println("An Error has occured!");
		}   
	}
	
	private void setExtrasPrice() {
		String extra = getExtras();
		
		switch(extra) {
			case "Sunroof": setPrice(500);
				 break;
			case "Navigation Device": setPrice(350);
				 break;
			case "Leather Interior": setPrice(700);
				 break;
			case "Air Conditioner": setPrice(400);
				 break;
			case "Heated Seats": setPrice(275);
				 break;
			case "Parking Assistant": setPrice(425);
				 break;
			case "Multifunctional Steering Wheel": setPrice(630);
				 break;
				 
			default: throw new IllegalArgumentException("Invalid Extra: " + extra);
		} 
		
	}
	
	private void setExtras1Price() {
		String extra1 = getExtras1();
		
		switch(extra1) {
			case "Sunroof": setPrice1(500);
				 break;
			case "Navigation Device": setPrice1(350);
				 break;
			case "Leather Interior": setPrice1(700);
				 break;
			case "Air Conditioner": setPrice1(400);
				 break;
			case "Heated Seats": setPrice1(275);
				 break;
			case "Parking Assistant": setPrice1(425);
				 break;
			case "Multifunctional Steering Wheel": setPrice1(630);
				 break;
				 
			default: throw new IllegalArgumentException("Invalid Extra: " + extra1);
		} 
	}
	
	public synchronized int calculateExtrasPrice() {		//Auch hier wird die Methode synchronisiert, um jeden Thread einzeln
		setExtrasPrice();					//abzuarbeiten und den berechneten Preis nicht von einem anderen Thread zu
		setExtras1Price();					//überschreiben
		int price = getPrice() + getPrice1();		
		return price;
	}

	private String interior() {					//Innenausbau - Sitze - Konsole
		String wheel = "Interior is created!";		
		return wheel;
	}
	
	private String exterior() {					//Außenausbau - Spiegel - Antenne - Scheinwerfer
		String trans = "Exterior is created!";		
		return trans;
	}
	
	private String electrical() {					//Elektrik
		String eng = "Electrical is created!";
		return eng;
	}
	
	private String engineInstallation() {				//Motoreinbau
		String eng = "Engine is installed!";
		return eng;
	}
	
	public String produce(String state) {
		state = "Components are installed";	
		return state;
	}
	
	public void printCount() throws InterruptedException {
		Thread t = Thread.currentThread();
		for(int i = 4; i > 3; i--) {
			String in = interior();
			System.out.println(t.getName() + ": " + in + " --- " + i);
			wait(8000);
		}
			
		for(int j = 3; j > 2; j--) {
			String ex = exterior();
			System.out.println(t.getName() + ": " + ex + " --- " + j);
			wait(6000);	
		}
			
		for(int k = 2; k > 1; k--) {
			String el = electrical();
			System.out.println(t.getName() + ": " + el + " --- " + k);
			wait(3000);
		}
		
		for(int k = 1; k > 0; k--) {
			String enIn = engineInstallation();
			System.out.println(t.getName() + ": " + enIn + " --- " + k);
			wait(3000);
		}
	}
	
	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getExtras1() {
		return extras1;
	}

	public void setExtras1(String extras1) {
		this.extras1 = extras1;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice1() {
		return price1;
	}

	public void setPrice1(int price1) {
		this.price1 = price1;
	}
}
