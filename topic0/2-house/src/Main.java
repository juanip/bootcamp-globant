public class Main {

	public static void main(String[] args) {
		HouseBuilder hb1 = new HouseBuilder();
		House house1;

		HouseBuilder hb2 = new HouseBuilder();
		House house2;

		house1 = hb1.addBarbecue().addBedroom().addBedroom().addDiningroom().getHouse();
		System.out.println(house1);

		house2 = hb2.addSwimmingPool().addBedroom().addDiningroom().getHouse();
		System.out.println(house2);
	}
}
