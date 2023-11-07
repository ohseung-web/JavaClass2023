package shopMol02_OT;
import java.util.*;

public class ItemManager {

	Scanner scan = new Scanner(System.in);

	// ī�װ��� String �ڷ������� ArrayList ����
	ArrayList<String> category = new ArrayList<>();

	//��ü �����۸���Ʈ��  Item �ڷ������� ArrayList ����
	ArrayList<Item> itemList = new ArrayList<>(); 

	// ��ü ��ٱ���
	ArrayList<Cart> jangList = new ArrayList<>(); 

	UserMenu user = new UserMenu();

	public ItemManager() {
		info();
	}

	// ī�װ� �߰� �� item �߰� �޼��� -------------------------------------------------------
	public void info() {
		category.add("����"); // index 0��°
		category.add("����"); // index 1��°
		category.add("����"); // index 2��°
		category.add("�����"); // index 3��°
		Item temp = new Item("�����", 1000, category.get(0)); // Item �ν��Ͻ� ��
		itemList.add(temp);
		temp = new Item("����", 2000, category.get(1)); 
		itemList.add(temp);
		temp = new Item("ĭ��", 3600, category.get(0)); 
		itemList.add(temp);
		temp = new Item("�Ұ��", 6500, category.get(2)); 
		itemList.add(temp);
		temp = new Item("�������", 5500, category.get(2)); 
		itemList.add(temp);
		temp = new Item("�ݶ�", 1000, category.get(3)); 
		itemList.add(temp);
		temp = new Item("���̴�", 1500, category.get(3)); 
		itemList.add(temp);
		temp = new Item("����", 1800, category.get(1)); 
		itemList.add(temp);
	}

	// ī�װ� ��� �޼��� ---------------------------------------------------------------------------
	public void printCategory() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+i+"]"+category.get(i));
		}
	}

	//item ��� ��� �޼��� ---------------------------------------------------------------------------
	public void printItemList() {
		for(int i=0; i< itemList.size(); i++) {
			System.out.print("["+i+"]");
			itemList.get(i).printInfo();
		}
	}

	// ��ٱ���  ----------------------------------------------------------------------------------------
	// usID => id, caID => ī�װ� index ��ȣ,  itemID => �׸� index ��ȣ
	public void addCart(String usID, int caID, int itemID) {

		int cnt = 0;
		int jangcnt = 0; // ��ٱ��Ͽ� �ߺ��� �������� ���� ����  Ȯ�� ġƮŰ
		int log = user.logindex; // UsermenuŬ������ �α��ε� log���� static�� ���� ��
		Cart temp = new Cart();
		temp.userId = usID;

		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(itemID).name.equals(itemList.get(i).name)) {

				jangcnt = 0;

				for(int j=0; j<jangList.size(); j++) {
					if(jangList.get(j).itemName.equals(itemList.get(i).name) 
							&& jangList.get(j).userId.equals(user.id[log]) ) {
						jangList.get(j).price += itemList.get(i).price;
						jangList.get(j).Quantity += 1;
						jangcnt += 1;
					}
				}
				if (jangcnt == 0) {
					temp.itemName = itemList.get(i).name;
					temp.price = itemList.get(i).price ;
					cnt += 1;
					temp.Quantity = cnt;
					jangList.add(temp);
				} 
			}
		}

	}

	// ��ٱ��� �μ� ---------------------------------------------------------------------------
	public void printJang() {
		for (int i = 0; i < jangList.size(); i++) {
			jangList.get(i).printCart();
		}
	}


	// ��ٱ��� delete ---------------------------------------------------------------------------
	public void cartClear() {
		int jangsize = jangList.size();
		for (int i = 0; i < jangsize; i++) {
			jangList.remove(0);
		}
	}

	// item �߰�  ---------------------------------------------------------------------------
	public void addItem(String addname, int addprice, int addcategory) {
		Item temp = new Item(addname, addprice, category.get(addcategory)); 
		itemList.add(temp);
	}


	// item ����  ---------------------------------------------------------------------------
	public void deleteItem(int deleteindex) {
			itemList.remove(deleteindex);
	}	

	// item ����  ---------------------------------------------------------------------------
	public void updateItem(int indexNUM, String updatename, int updateprice) {
		for(int i =0; i< itemList.size(); i++) {
			itemList.get(indexNUM).name  = updatename ;
			itemList.get(indexNUM).price  = updateprice ;
		}

	}
}