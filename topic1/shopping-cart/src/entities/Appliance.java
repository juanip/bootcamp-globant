package entities;

public abstract class Appliance implements Item {
	private final int serialNumber;
	private double listPrice;

	public Appliance(int serialNumber, double price) {
		this.serialNumber = serialNumber;
		setListPrice(price);
	}

	public Appliance(int serialNumber) {
		this(serialNumber, 0);
	}

	public int getSerialNumber() {
		return this.serialNumber;
	}

	public double getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(double price) {
		this.listPrice = price;
	}

	public abstract String toString();

}
