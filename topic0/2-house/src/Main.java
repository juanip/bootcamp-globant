public class Main {

	public static void main(String[] args) {
		HouseDirector hd = new HouseDirector(new HouseBuilder());
		House house = null;

		hd.constructHouse();
		house = hd.getHouse();

		System.out.println(house);
	}
}
