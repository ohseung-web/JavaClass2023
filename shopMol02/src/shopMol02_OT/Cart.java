package shopMol02_OT;

public class Cart {
	
	String userId; // ������ ���� id
	String itemName; // ������ ������
	int price ; // ������  ������ �ݾ�
	int Quantity ; // ���ż���
	
	public Cart() {}
	public Cart(String itemName, int price) {
		this.itemName = itemName;
		this.price = price;
	}

	public void printCart() {
		System.out.println("["+userId+"]"+"�׸� : " + itemName + " ,�ݾ� :"+ price 
				+ " ,���� : " + Quantity + "��" );
	}
}
