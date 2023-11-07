package classpart14;

public class MainClass {

	public static void main(String[] args) {
		Product pr = new Product();
		pr.name = "°¨ÀÚ±ø";
		pr.price = 1000;
		// ¹è¿­ 		
		Product [] arr = new Product[3];
		arr[0] = new Product();
		arr[1] = new Product();
		arr[2] = new Product();
		arr[0].price = 10;
		arr[1].price = 20;
		arr[2].price = 30;
		arr[0].name = "ÀÌ¸¸¼ö";
		arr[1].name = "ÀÌ¿µÈñ";		
		arr[2].name = "±èÃ¶¹Î";
		System.out.println(arr[1].name);
		
		Product temp = arr[1];
		System.out.println(temp.name);	
		System.out.println(temp.price);
	}

}
