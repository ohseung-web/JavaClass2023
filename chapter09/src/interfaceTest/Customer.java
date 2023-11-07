package interfaceTest;

public class Customer implements Buy, Sell {

	@Override
	public void sell() {
     System.out.println("판매하기");		
	}

	@Override
	public void buy() {
		System.out.println("구매하기");		
	}

	// 같은 이름의 default 메서드는 재정의 하여 사용한다.
	@Override
	public void order() {
		System.out.println("고객의 판매 주문");
	}

}
