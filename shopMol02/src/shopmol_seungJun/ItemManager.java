package shopmol_seungJun;
import java.util.*;
public class ItemManager {
	// User Ŭ���� �ν��Ͻ� 
	User u = new User();
	
	// ������ ��ٱ��ϸ� Integer �������� �Է¹��� ���� ����
	ArrayList<Integer>[] userBasket = new ArrayList[u.id.length];
	
	// ī�װ��� String �������� �Է¹��� ���� ����
	ArrayList<String> category = new ArrayList<>();
	
	// ī�װ� �ȿ� �� �׸��� �Է¹��� ���� ���� (�ڷ��� : Item)
	ArrayList<Item> itemList = new ArrayList<>();
	
	public ItemManager() {
		Info();
		setUserBasket();
	}
	
	// ArrayList(Item) �ȿ� ������ �߰� �޼���
	public void Info() {
		category.add("����"); // �ε��� : 0
		category.add("����"); // �ε��� : 1
		category.add("����"); // �ε��� : 2
		category.add("�����"); // �ε��� : 3
		// Item Ŭ������ �ν��Ͻ��Ѵ�.
		Item temp = new Item("�����",1500,category.get(0));
		itemList.add(temp);
		temp = new Item("����Ĩ",1800,category.get(0));
		itemList.add(temp);
		temp = new Item("����",5500,category.get(1));
		itemList.add(temp);
		temp = new Item("��ġ",15000,category.get(1));
		itemList.add(temp);
		temp = new Item("����",12000,category.get(2));
		itemList.add(temp);
		temp = new Item("��������",16000,category.get(2));
		itemList.add(temp);
		temp = new Item("��ī�ݶ�",1900,category.get(3));
		itemList.add(temp);
		temp = new Item("���䷹��",2100,category.get(3));
		itemList.add(temp);
	}
	
	// 2���� �迭 ArrayList ����(userBasket) 
	public void setUserBasket() {
		for(int i=0;i<u.id.length;i++) {
			userBasket[i] = new ArrayList<Integer>();
			for(int j=0;j<itemList.size();j++) {
				userBasket[i].add(0);
			}
		}	
	}
	
	// ī�װ� ��� �޼���
	public void printCategory() {
		for(int i=0;i<category.size();i++) {
			System.out.println("["+i+"]"+category.get(i));
		}
	}
	
	// item ��� ��� �޼���
	public void printItemList(int menu) {
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).category.equals(category.get(menu))) {
				System.out.print("["+i+"]");
				itemList.get(i).printInfo();
			}
	
		}
	}
	
	// ��ٱ��Ͽ� item�� ��� �޼���
	public void addBasket(int menu) {
		itemList.get(menu).itemNum++;
	}
	
	// ��ٱ��� ��� �޼���
	public void printBasket() {
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).itemNum != 0) {
				System.out.println(itemList.get(i).name+": "+itemList.get(i).itemNum+"��");
			}
		}
	}
	
	// ���� ��ٱ��� ���� �޼���
	public void saveUserBasket(int log) {
		for(int i=0;i<itemList.size();i++) {
			userBasket[log].set(i, itemList.get(i).itemNum);
		}
	}
	
	// ��ٱ��� �ʱ�ȭ �޼���
	public void clearBasket() {
		for(int i=0;i<itemList.size();i++) {
			itemList.get(i).itemNum = 0;
		}
	}
	
	// ����� ���� ��ٱ��� �����ͷ� ��ٱ��� ä���
	public void fillBasket(int log) {
		for(int i=0;i<itemList.size();i++) {
			itemList.get(i).itemNum = userBasket[log].get(i);
		}
	}
}
