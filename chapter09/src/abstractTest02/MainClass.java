package abstractTest02;

public class MainClass {

	public static void main(String[] args) {

       Bank myBank = new MyBank("����ȣ","1234-123",10000);
		
		myBank.deposit();				// ����
		myBank.withdraw();				// ���
		myBank.installmentSavings();	// ����
		myBank.cancellation();			// �ؾ�
		
		System.out.println();
		myBank.getInfo();
	}

}
