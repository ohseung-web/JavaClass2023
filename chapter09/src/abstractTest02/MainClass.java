package abstractTest02;

public class MainClass {

	public static void main(String[] args) {

       Bank myBank = new MyBank("박찬호","1234-123",10000);
		
		myBank.deposit();				// 예금
		myBank.withdraw();				// 출금
		myBank.installmentSavings();	// 적금
		myBank.cancellation();			// 해약
		
		System.out.println();
		myBank.getInfo();
	}

}
