package at.fhsalzburg.its.nos.automobilefactory;

public class QualityControl extends Production {		//Qualitätskontrolle
	
	
	private String setTrack() {							//Spur einstellen
		String st = "Track is set!";
		return st;
	}
	
	private String fillLiquids() {						//Bremsflüssigkeit - Motoröl - Wischwasser etc.
		String fl = "Liquids are replenished!";
		return fl;
	}
	
	private String polishCar() {						//Auto polieren
		String pc = "Car is polished!";		
		return pc;
	}
	
	public String produce(String state) {
		state = "Quality acceptance was successful";	
		return state;
	}
	
	public void printCount() throws InterruptedException {
		Thread t = Thread.currentThread();
		for(int i = 3; i > 2; i--) {
			String st = setTrack();
			System.out.println(t.getName() + ": " + st + " --- " + i);
			wait(6000);
		}
		
		for(int i = 2; i > 1; i--) {
			String fl = fillLiquids();
			System.out.println(t.getName() + ": " + fl + " --- " + i);
			wait(4000);
		}
		
		for(int i = 1; i > 0; i--) {
			String pc = polishCar();
			System.out.println(t.getName() + ": " + pc + " --- " + i);
			wait(2000);
		}
	}	
}
