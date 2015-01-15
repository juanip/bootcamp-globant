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
		StringBuffer sb = new StringBuffer();
		sb.append(getSerialNumber());
		sb.append(". TV - ");
		sb.append(getScreenSize());
		sb.append(" inches. ........ $");
		sb.append(getListPrice());

		return sb.toString();
	}
}
