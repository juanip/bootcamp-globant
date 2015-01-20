package ex5_1;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Customer customer = new Customer("Juan Perez");

		customer.setMember(true);
		customer.setMemberType("silver");

		System.out.println(customer);

		Visit visit = new Visit(customer, new Date());

		visit.setProductExpense(200);
		visit.setServiceExpense(300);

		System.out.println(visit);

	}
}
