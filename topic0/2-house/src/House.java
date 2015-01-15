public class House {

	private int bedrooms = 0;
	private boolean barbecue = false;
	private boolean diningroom = false;
	private boolean swimmingPool = false;

	public House(int bedrooms, boolean barbecue, boolean diningroom, boolean swimmingPool) {
		this.bedrooms = bedrooms;
		this.barbecue = barbecue;
		this.diningroom = diningroom;
		this.swimmingPool = swimmingPool;
	}

	public String toString() {
		String desc = "A house with:\n";
		desc += this.bedrooms + " bedrooms.\n";
		desc += this.diningroom ? "A dining room.\n" : "";
		desc += this.barbecue ? "A barbecue.\n" : "";
		desc += this.swimmingPool ? "A swimming pool.\n" : "";

		return desc;
	}
}
