package at.fhsalzburg.its.nos.automobilefactory;


public class TestClass {

	public static void main(String[] args) {
		Chassis ch = new Chassis();
		BodyShop bs = new BodyShop();
		ComponentInstallation ci = new ComponentInstallation();
		VehicleAssembly va = new VehicleAssembly();
		QualityControl qc = new QualityControl();
		
		BMWOne one = new BMWOne(ch, bs, ci, va, qc);
		BMWOne one1 = new BMWOne(ch, bs, ci, va, qc);
		BMWFour four = new BMWFour(ch, bs, ci, va, qc);
		BMWSeven seven = new BMWSeven(ch, bs, ci, va, qc);
		
		Production p = new Production();
		p.startThreads(one, one1, four, seven);
		
		/*one.printInfo();
		System.out.println();
		one1.printInfo();
		System.out.println();
		four.printInfo();
		System.out.println();
		seven.printInfo();*/
		
		new PriceList(one, one1, four, seven);
	}
}
