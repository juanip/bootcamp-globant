package entities;

public class Fridge extends Appliance {

	private double capacity;

	public Fridge(int serialNumber, double price) {
		this(serialNumber, price, 0);
	}

	public Fridge(int serialNumber) {
		this(serialNumber, 0, 0);
	}

	public Fridge(int serialNumber, double price, double capacity) {
		super(serialNumber, price);
		setCapacity(capacity);
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getCapacity() {
		return this.capacity;
	}

	@Override
	public String toString() {
		return getSerialNumber() + " | Fridge: " + getCapacity() + " lts. List Price: $" + getListPrice();

	}
}
