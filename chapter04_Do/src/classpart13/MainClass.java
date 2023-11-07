package classpart13;

public class MainClass {

	public static void main(String[] args) {
 
		Product pr = new Product();
		pr.name = "감자깡";
		pr.price = 1000;
	    System.out.println(pr.showInfo());
	
		// 배열 
		Product [] arr = new Product[3];
		arr[0] = new Product();
		arr[1] = new Product();
		arr[2] = new Product();
		arr[0].price = 2000;
		arr[1].price = 3500;
		arr[2].price = 5000;
		arr[0].name = "쵸코칩";
		arr[1].name = "양파링";
		arr[2].name = "빼뺴로";
		
		for(Product num : arr) { //확장 for문 이용
			System.out.println(num.showInfo());
		}
	}
}
