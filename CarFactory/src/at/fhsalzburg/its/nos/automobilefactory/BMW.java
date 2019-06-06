package at.fhsalzburg.its.nos.automobilefactory;

import java.util.ArrayList;
import java.util.List;

public class BMW {
	private List<String> productionState = new ArrayList<String>();
	
	public void setAutoID(List<String> productionState) {
		this.productionState = productionState;
	}
	
	public List<String> getProductionState() {
		return productionState;
	}
	
	public void insertID(String ID) {
		productionState.add(ID);
	}
	
	public void getLastValue(List<String> productionState){
        if(productionState == null || productionState.isEmpty()){
            return;
        }
	}
	
	public synchronized void printID() {	//Die Methode wird synchronisiert, dass heißt, jeder Thread
		for(Object elem : productionState)	//betritt "exklusiv" diese Methode. Alle anderen Threads müssen so 
			System.out.println(elem);		//lange warten, bis der aktuelle Thread die Methode abgearbeitet hat
	}
}
