package shopmol_seungJun;

public class Item {
	String name; // ī�װ��� item �̸�
	int price; // item ����
	String category; // ī�װ� : ����, ���� , ��� ��Ÿ ���
	int itemNum; // item�� ����
	//������
	public Item(String name, int price, String category) {
	this.name = name;
	this.price = price;
	this.category = category;
	itemNum = 0;
	}
	//��� �޼���
	public void printInfo() {
		System.out.println("["+name+"]"+"["+price+"]"+"["+category+"]");
	}
}
