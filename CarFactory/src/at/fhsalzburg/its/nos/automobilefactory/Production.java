package at.fhsalzburg.its.nos.automobilefactory;


public class Production {
	
	public String produce(String state) {
		state = "Car is produced!";
		System.out.println(state);		
		return state;
	}
	
	public void startThreads(BMWOne one, BMWOne one1, BMWFour four, BMWSeven seven) {
		Thread T1 = new Thread(one);
		Thread T2 = new Thread(one1);
		Thread T3 = new Thread(four);
		Thread T4 = new Thread(seven);
		
		T1.setName(one.getBMW1());
		T2.setName("2. " + one1.getBMW1());
		T3.setName(four.getBMW4());
		T4.setName(seven.getBMW7());
		
		T1.start();
		T2.start();
		T3.start();
		T4.start();

		try {
			T1.join();
			T2.join();
			T3.join();
			T4.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
	}
}
