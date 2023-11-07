package inheritance02;

public class CustomerMain {

	public static void main(String[] args) {

		Customer cusomerLee = new Customer();
		cusomerLee.setCustomerID(0100);
		cusomerLee.setCustomerName("Lee");
		 
		VIPCustomer cusomerKim = new VIPCustomer(0200,"kim");
		
		System.out.println(cusomerLee.ShowCustomerInfo());
		System.out.println(cusomerKim.ShowCustomerInfo());
		
	}

}
