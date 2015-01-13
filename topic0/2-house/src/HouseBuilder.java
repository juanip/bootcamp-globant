public class HouseBuilder implements Builder {

	House house = new House();

	@Override
	public House getHouse() {
		return house;
	}

	@Override
	public void paintHouse() {
		house.setColor("Red");
	}

	@Override
	public void buildBedrooms() {
		try {
			house.setBedroom("A little bedrooom with a bed and a wardrobe.");
			house.setBedroom("Another bedroom with blue carpet and two beds.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buildDiningroom() {
		try {
			house.setDiningroom("A huge dining room with a jar full of cookies.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buildBarbecue() {
		try {
			house.setBarbecue("A big barbecue room with a fridge full of beer.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buildSwimmingPool() {
		try {
			house.setSwimmingPool("A majestic swimming pool with a scarily tall trampoline");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
