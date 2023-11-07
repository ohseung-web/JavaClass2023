package shopmal;

import java.util.*;

public class Item {
	String name;
	int price;
	String category; // 카테고리 // 육류 , 과자 , 어류 , 과일 등등

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
	String userId; // 구입한 유저 id
	String itemName; // 구입한 아이템

	public void print() {
		System.out.println("[" + userId + "]" + "아이템 : " + itemName);
	}
}

class ItemManager {
	Scanner scan = new Scanner(System.in);
	Vector<String> category = new Vector<String>();
	Vector<Item> itemList = new Vector<Item>(); // 전체 아이템리스트
	Vector<Cart> jangList = new Vector<Cart>(); // 전체 장바구니
	
	public ItemManager() {
		init();
	}

	public void init() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		Item temp = new Item("새우깡", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
		itemList.add(temp);
		temp = new Item("닭", 5500, category.get(2));
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
	
