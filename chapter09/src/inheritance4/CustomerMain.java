package inheritance4;
import java.text.*;
public class CustomerMain {

	public static void main(String[] args) {
		
		DecimalFormat de = new DecimalFormat("#,###��");
		
		Customer vc = new VIPCustomer(0200, "��浿", 1010);
		int price = vc.calcprice(10000);
		System.out.println("���� �ݾ��� "+de.format(price)+"�̰�,"+vc.ShowCustomerInfo());
		
		
		/*
		Customer cusomerLee = new Customer(0100,"�̼���");
		//cusomerLee.setCustomerID(0100);
		//cusomerLee.setCustomerName("�̼���");
		//cusomerLee.bounsPoint = 1000;
		int price = cusomerLee.calcprice(10000);
		System.out.println("���� �ݾ��� "+de.format(price)+"�̰�,"+cusomerLee.ShowCustomerInfo());
		
	*/
		
		//cusomerKim.bounsPoint =1000;
		
		
		
		
		
	}

}
