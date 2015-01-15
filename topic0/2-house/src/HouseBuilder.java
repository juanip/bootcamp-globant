public class HouseBuilder {

	private int bedrooms = 0;
	private boolean diningroom = false;
	private boolean swimmingPool = false;
	private boolean barbecue = false;

	public HouseBuilder addBedroom() {
		if (this.bedrooms < 3) {
			this.bedrooms++;
		} else {
			throw new RuntimeException("Too many bedrooms!");
		}

		return this;
	}

	public HouseBuilder addDiningroom() {
		if (!this.diningroom) {
			this.diningroom = true;
		} else {
			throw new RuntimeException("There is a dining room alredy!");
		}

		return this;
	}

	public HouseBuilder addBarbecue() {
		if (!this.barbecue) {
			this.barbecue = true;
		} else {
			throw new RuntimeException("There is a barbecue alredy!");
		}

		return this;
	}

	public HouseBuilder addSwimmingPool() {
		if (!this.swimmingPool) {
			this.swimmingPool = true;
		} else {
			throw new RuntimeException("There is a swimming pool alredy!");
		}

		return this;
	}

	public House getHouse() {
		return new House(bedrooms, barbecue, diningroom, swimmingPool);
	}

}
