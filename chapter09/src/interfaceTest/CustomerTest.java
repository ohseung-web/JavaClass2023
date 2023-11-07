package interfaceTest;

public class CustomerTest {

	public static void main(String[] args) {

		Customer customer = new Customer();
		
		Buy buyer = customer;
		buyer.buy();
		Sell seller = customer;
		seller.sell();
		
		// 가상 메서드로 order()메서드를 재정의한 customer 클래스의 order()메서드가 출력된다.
		customer.order();
		buyer.order();
		seller.order();
	}

}
