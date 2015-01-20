package ex5_1;

public class Customer {

	private String name;
	private boolean member;
	private String memberType;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean isMember() {
		return this.member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public String getMemberType() {
		return this.memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(name);
		sb.append(isMember() ? ", is " : ", is not ");
		sb.append("a member");
		sb.append(isMember() ? " of type " + getMemberType() : "");
		sb.append(".");

		return sb.toString();
	}
}
