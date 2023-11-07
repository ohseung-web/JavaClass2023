package shopmol_seungJun;
import java.util.*;
public class ItemManager {
	// User 클래스 인스턴스 
	User u = new User();
	
	// 고객들의 장바구니를 Integer 형식으로 입력받을 공간 생성
	ArrayList<Integer>[] userBasket = new ArrayList[u.id.length];
	
	// 카테고리를 String 형식으로 입력받을 공간 생성
	ArrayList<String> category = new ArrayList<>();
	
	// 카테고리 안에 들어갈 항목을 입력받을 공간 생성 (자료형 : Item)
	ArrayList<Item> itemList = new ArrayList<>();
	
	public ItemManager() {
		Info();
		setUserBasket();
	}
	
	// ArrayList(Item) 안에 데이터 추가 메서드
	public void Info() {
		category.add("과자"); // 인덱스 : 0
		category.add("생선"); // 인덱스 : 1
		category.add("육류"); // 인덱스 : 2
		category.add("음료수"); // 인덱스 : 3
		// Item 클래스를 인스턴스한다.
		Item temp = new Item("새우깡",1500,category.get(0));
		itemList.add(temp);
		temp = new Item("꼬북칩",1800,category.get(0));
		itemList.add(temp);
		temp = new Item("고등어",5500,category.get(1));
		itemList.add(temp);
		temp = new Item("갈치",15000,category.get(1));
		itemList.add(temp);
		temp = new Item("삼겹살",12000,category.get(2));
		itemList.add(temp);
		temp = new Item("차돌박이",16000,category.get(2));
		itemList.add(temp);
		temp = new Item("코카콜라",1900,category.get(3));
		itemList.add(temp);
		temp = new Item("게토레이",2100,category.get(3));
		itemList.add(temp);
	}
	
	// 2차원 배열 ArrayList 생성(userBasket) 
	public void setUserBasket() {
		for(int i=0;i<u.id.length;i++) {
			userBasket[i] = new ArrayList<Integer>();
			for(int j=0;j<itemList.size();j++) {
				userBasket[i].add(0);
			}
		}	
	}
	
	// 카테고리 출력 메서드
	public void printCategory() {
		for(int i=0;i<category.size();i++) {
			System.out.println("["+i+"]"+category.get(i));
		}
	}
	
	// item 목록 출력 메서드
	public void printItemList(int menu) {
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).category.equals(category.get(menu))) {
				System.out.print("["+i+"]");
				itemList.get(i).printInfo();
			}
	
		}
	}
	
	// 장바구니에 item을 담는 메서드
	public void addBasket(int menu) {
		itemList.get(menu).itemNum++;
	}
	
	// 장바구니 출력 메서드
	public void printBasket() {
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).itemNum != 0) {
				System.out.println(itemList.get(i).name+": "+itemList.get(i).itemNum+"개");
			}
		}
	}
	
	// 유저 장바구니 저장 메서드
	public void saveUserBasket(int log) {
		for(int i=0;i<itemList.size();i++) {
			userBasket[log].set(i, itemList.get(i).itemNum);
		}
	}
	
	// 장바구니 초기화 메서드
	public void clearBasket() {
		for(int i=0;i<itemList.size();i++) {
			itemList.get(i).itemNum = 0;
		}
	}
	
	// 저장된 유저 장바구니 데이터로 장바구니 채우기
	public void fillBasket(int log) {
		for(int i=0;i<itemList.size();i++) {
			itemList.get(i).itemNum = userBasket[log].get(i);
		}
	}
}
