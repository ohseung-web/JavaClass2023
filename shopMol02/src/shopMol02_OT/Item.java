package shopMol02_OT;

public class Item  {
	String name; // ī�װ��� item �̸�
	int price; // item ����
	String category; // ī�װ� : ����, ���� , ��� ��Ÿ ���

	//������
	public Item() {}
	public Item(String name, int price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	//��� �޼���
	public void printInfo() {
		System.out.println("["+name+"]"+"["+price+"]"+"["+category+"]");
	}
}
