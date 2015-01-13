public class HouseDirector {

	private Builder builder = null;

	public HouseDirector(Builder builder) {
		this.builder = builder;
	}

	public void constructHouse() {
		builder.buildBedrooms();
		builder.buildDiningroom();
		builder.buildSwimmingPool();
		builder.buildBarbecue();
		builder.paintHouse();
	}

	public House getHouse() {
		return builder.getHouse();
	}
}
