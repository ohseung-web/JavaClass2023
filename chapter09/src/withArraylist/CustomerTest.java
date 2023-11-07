package withArraylist;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();
        Customer customerLee = new Customer(10010,"�̼���");
        Customer customerShin = new Customer(10011,"�Ż��Ӵ�");
        GoldCustomer customerHong = new GoldCustomer(20010, "ȫ�浿");
        GoldCustomer customerYul = new GoldCustomer(20011, "������");
        VIPCustomer customerkim = new VIPCustomer(30010,"������",1234);
        
        customerList.add(customerLee);
        customerList.add(customerShin);
        customerList.add(customerHong);
        customerList.add(customerYul);
        customerList.add(customerkim);
        
        System.out.println("======= ������ ��� ========");
        for(int i=0;i<customerList.size();i++) {
        	System.out.println(customerList.get(i).ShowCustomerInfo());
        }
        
        System.out.println("=======���ʽ� ����Ʈ�� ������ ��� ========");
        int price = 10000;
        for(Customer customer : customerList) { 
        	int cost =  customer.calcprice(price);
        	System.out.println(customer.getCustomerName()+"���� "+cost+"�� �����ϼ̽��ϴ�.");
        	System.out.println(customer.ShowCustomerInfo());
        }
        
	}

}
