package ex5_1;

import java.util.Date;

public class Visit {

	private Customer customer;
	private Date date;
	private double serviceExpense;
	private double productExpense;

	public Visit(Customer customer, Date date) {
		this.date = date;
		this.customer = customer;
	}

	public String getName() {
		return this.customer.getName();
	}

	public double getServiceExpense() {
		return this.serviceExpense;
	}

	public void setServiceExpense(double ex) {
		double discount = ex * DiscountRate.getServiceDiscountRate(customer.getMemberType());
		serviceExpense = ex - discount;
	}

	public double getProductExpense() {
		return this.productExpense;
	}

	public void setProductExpense(double ex) {
		double discount = ex * DiscountRate.getProductDiscountRate(customer.getMemberType());
		productExpense = ex - discount;
	}

	public double getTotalExpense() {
		return getProductExpense() + getServiceExpense();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Date: " + date + ". ");
		sb.append(customer.getName());
		sb.append("'s visit. ");
		sb.append(customer.isMember() ? "Membership: " + customer.getMemberType() + ". " : "");
		sb.append("Products expense: $" + getProductExpense());
		sb.append(". Services expense: $" + getServiceExpense());
		sb.append(". Total: $" + getTotalExpense());

		return sb.toString();
	}
}
