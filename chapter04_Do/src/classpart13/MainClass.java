package classpart13;

public class MainClass {

	public static void main(String[] args) {
 
		Product pr = new Product();
		pr.name = "���ڱ�";
		pr.price = 1000;
	    System.out.println(pr.showInfo());
	
		// �迭 
		Product [] arr = new Product[3];
		arr[0] = new Product();
		arr[1] = new Product();
		arr[2] = new Product();
		arr[0].price = 2000;
		arr[1].price = 3500;
		arr[2].price = 5000;
		arr[0].name = "����Ĩ";
		arr[1].name = "���ĸ�";
		arr[2].name = "������";
		
		for(Product num : arr) { //Ȯ�� for�� �̿�
			System.out.println(num.showInfo());
		}
	}
}
