import java.util.ArrayList;

public class House {

	private String color;
	private ArrayList<String> bedrooms = new ArrayList<String>();
	private String barbecue;
	private String diningroom;
	private String swimmingPool;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ArrayList<String> getBedrooms() {
		return bedrooms;
	}

	public void setBedroom(String bedroom) throws Exception {
		if (this.bedrooms.size() < 3) {
			this.bedrooms.add(bedroom);
		} else {
			throw new Exception("Too many bedrooms!");
		}
	}

	public String getBarbecue() {
		return barbecue;
	}

	public void setBarbecue(String barbecue) throws Exception {
		if (this.barbecue == null) {
			this.barbecue = barbecue;
		} else {
			throw new Exception("There is a barbecue already");
		}
	}

	public String getDiningroom() {
		return diningroom;
	}

	public void setDiningroom(String diningroom) throws Exception {
		if (this.diningroom == null) {
			this.diningroom = diningroom;
		} else {
			throw new Exception("There is a dining room already");
		}
	}

	public String getSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(String swimmingPool) throws Exception {
		if (this.swimmingPool == null) {
			this.swimmingPool = swimmingPool;
		} else {
			throw new Exception("There is a swimming pool already");
		}
	}

	public String toString() {
		String desc = "A " + getColor() + " house with:\n" + getDiningroom() + "\n" + getBarbecue() + "\n" + getSwimmingPool() + "\n";
		for (String b : this.bedrooms) {
			if (b != null) {
				desc += b + "\n";
			}
		}
		return desc;
	}
}
