package interfaceTest;

public class CustomerTest {

	public static void main(String[] args) {

		Customer customer = new Customer();
		
		Buy buyer = customer;
		buyer.buy();
		Sell seller = customer;
		seller.sell();
		
		// ���� �޼���� order()�޼��带 �������� customer Ŭ������ order()�޼��尡 ��µȴ�.
		customer.order();
		buyer.order();
		seller.order();
	}

}
