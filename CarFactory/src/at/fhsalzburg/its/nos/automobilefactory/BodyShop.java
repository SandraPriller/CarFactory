package at.fhsalzburg.its.nos.automobilefactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.w3c.dom.ranges.RangeException;


public class BodyShop extends Production {		//Karosseriebau
	private String color;
	
	
	protected void randColor() {				//Funktion adaptiert aus https://www.baeldung.com/java-random-list-element
	    Random rand = new Random();
	    List<String> colorList = Arrays.asList("Green", "Yellow", "White", "Black", "Grey", "Red", "Blue", "Pink", "Magenta");	 
	    int numberOfElements = 1;
	 
	    try {
	    	for(int i = 0; i < numberOfElements; i++) {
	    		int randomIndex = rand.nextInt(colorList.size());
	    		color = colorList.get(randomIndex);	        
	    	}
	    
	    	setColor(color);
	    	
	    } catch (RangeException r) {
			System.out.println("An Error has occured!");
		}
	}
	
	private String createBodyShop() {				//Karosserie bauen
		String create = "Body shop is created!";		
		return create;
	}
	
	private String paintBodyShop() {				//Karosserie lackieren
		String paint = "Body shop is painted!";		
		return paint;
	}
	
	private String insertWindows() {				//Fenster einsetzen
		String win = "Windows are inserted!";
		return win;
	}

	public String produce(String state) {
		state = "Body shop is manufactured";				
		return state;
	}
	
	public void printCount() throws InterruptedException {
		Thread t = Thread.currentThread();
		for(int i = 3; i > 2; i--) {
			String create = createBodyShop();
			System.out.println(t.getName() + ": " + create + " --- " + i);
			wait(8000);
		}
			
		for(int j = 2; j > 1; j--) {
			String paint = paintBodyShop();
			System.out.println(t.getName() + ": " + paint + " --- " + j);
			wait(6000);	
		}
			
		for(int k = 1; k > 0; k--) {
			String win = insertWindows();
			System.out.println(t.getName() + ": " + win + " --- " + k);
			wait(3000);
		}
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
