package entities;

public class TV extends Appliance {

	private double screenSize;

	public TV(int serialNumber) {
		this(serialNumber, 0, 0);
	}

	public TV(int serialNumber, double price) {
		this(serialNumber, price, 0);
	}

	public TV(int serialNumber, double price, double screenSize) {
		super(serialNumber, price);
		setScreenSize(screenSize);
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public double getScreenSize() {
		return this.screenSize;
	}

	@Override
	public String toString() {
		return getSerialNumber() + " | TV: " + getScreenSize() + " inches. List Price: $" + getListPrice();
	}
}
