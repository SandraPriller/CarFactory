package at.fhsalzburg.its.nos.automobilefactory;

public class BMWSeven extends BMW implements Runnable {
	private String ID, PS, color, extras, extras1, tires;
	private String BMW7 = "BMW7";
	private int price = 31890;
	private Chassis ch;
	private BodyShop bs;
	private ComponentInstallation ci;
	private VehicleAssembly va;
	private QualityControl qc;

	public BMWSeven(Chassis ch, BodyShop bs, ComponentInstallation ci, VehicleAssembly va, QualityControl qc) {
		this.ch = ch;
		this.bs = bs;
		this.ci = ci;
		this.va = va;
		this.qc = qc;
	}
		
	private void insertType() {
		String state = null;
		ch.generateRandString(ch.getVIN(), ch.getWMI());
		ID = ch.getVIN() + getBMW7();
		setID(ID);
		ch.setVIN(ID);
		ch.randPS();
		setPS(ch.getPS());
		state = ch.produce(state) + " with VIN " + getID() + " and " + getPS() + "!";
		insertID(state);
		printID();
	}
	
	private void insertColor() {
		String state = null;
		bs.randColor();
		setColor(bs.getColor());
		state = bs.produce(state) + " with Color " + getColor() + "!";
		insertID(state);
		getLastValue(getProductionState());
		int size = getProductionState().size();
		System.out.print(getProductionState().get(size-1) + "\n");
	}
	
	private void componentInstallation() {
		String state = null;
		ci.randExtras();
		setExtras(ci.getExtras());
		setExtras1(ci.getExtras1());
		int price = getPrice() + ci.calculateExtrasPrice();
		setPrice(price);
		state = ci.produce(state) + " with Extras: " + getExtras() + " and " + getExtras1() + " € " + String.valueOf(price) + "!";
		insertID(state);
		getLastValue(getProductionState());
		int size = getProductionState().size();
		System.out.println(getProductionState().get(size-1));
	}

	private void componentAssembly() {
		String state = null;
		va.randTires();
		setTires(va.getTire());
		state = va.produce(state) + " with wheelsize " + getTires() + "!";
		insertID(state);
		getLastValue(getProductionState());
		int size = getProductionState().size();
		System.out.println(getProductionState().get(size-1));
	}
	
	private void controllQuality() {
		String state = null;
		state = qc.produce(state) + "!";
		insertID(state);
		getLastValue(getProductionState());
		int size = getProductionState().size();
		System.out.println(getProductionState().get(size-1));
	}
	
	public void printInfo() {
		printID();
	}

	@Override
	public void run() {	
		Thread t = Thread.currentThread();
		System.out.println("Starting " + t.getName());
		synchronized (ch) {
			try {
				ch.printCount();
				ch.notifyAll();					
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + t.getName() + " exiting.");
		insertType();
		
		System.out.println("Starting " + t.getName());
		synchronized (bs) {
			try {
				bs.printCount();
				bs.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + t.getName() + " exiting.");
		insertColor();
		
		System.out.println("Starting " + t.getName());
		synchronized (ci) {
			try {
				ci.printCount();
				ci.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + t.getName() + " exiting.");
		componentInstallation();
		
		System.out.println("Starting " + t.getName());
		synchronized (va) {
			try {
				va.printCount();
				va.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + t.getName() + " exiting.");
		componentAssembly();
		
		System.out.println("Starting " + t.getName());
		synchronized (qc) {
			try {
				qc.printCount();
				qc.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + t.getName() + " exiting.");
		controllQuality();
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
		
	public String getID() {
		return ID;
	}

	public String getBMW7() {
		return BMW7;
	}

	public void setBMW1(String BMW7) {
		this.BMW7 = BMW7;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPS() {
		return PS;
	}

	public void setPS(String pS) {
		PS = pS;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getTires() {
		return tires;
	}

	public void setTires(String tires) {
		this.tires = tires;
	}
}
