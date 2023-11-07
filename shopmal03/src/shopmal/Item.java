package shopmal;

import java.util.*;

public class Item {
	String name;
	int price;
	String category; // ī�װ� // ���� , ���� , ��� , ���� ���

	public Item(String name, int price, String category) {
		this.name = name;
		this.price = price;
		this.category =category;
	}

	public void print() {
		System.out.println("[" + name + "]" + "[" + price + "]" + "[" + category + "]");
	}

}

class Cart {
	String userId; // ������ ���� id
	String itemName; // ������ ������

	public void print() {
		System.out.println("[" + userId + "]" + "������ : " + itemName);
	}
}

class ItemManager {
	Scanner scan = new Scanner(System.in);
	Vector<String> category = new Vector<String>();
	Vector<Item> itemList = new Vector<Item>(); // ��ü �����۸���Ʈ
	Vector<Cart> jangList = new Vector<Cart>(); // ��ü ��ٱ���
	
	public ItemManager() {
		init();
	}

	public void init() {
		category.add("����");
		category.add("����");
		category.add("����");
		category.add("�����");
		Item temp = new Item("�����", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("����", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("ĭ��", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("�Ұ��", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("�ݶ�", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("����", 1800, category.get(1));
		itemList.add(temp);
		temp = new Item("��", 5500, category.get(2));
		itemList.add(temp);
	}

	public void printCategory() {
		for (int i = 0; i < category.size(); i++) {
			System.out.println("[" + i + "] " + category.get(i));
		}
	}

	public void printItemList() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + i + "]");
			itemList.get(i).print();
		}
	}

	public void addCart(String usID, int caID, int itemID) {
		int n = 0;
		Cart temp = new Cart();
		temp.userId = usID;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).category)) {
				if (itemID == n) {
					temp.itemName = itemList.get(i).name;
				}
				n += 1;
			}
		}
		jangList.add(temp);
	}
}
	
