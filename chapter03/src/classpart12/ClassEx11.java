package classpart12;

public class ClassEx11 {
   // static Ű���� : ����
	String name;
	static int atm = 0; 
	
	//������
	public ClassEx11(String name) {
		this.name = name;
	}
	
	// �޼��� = �Լ�
	public void sMoney(int money) {
		atm += money;
		System.out.println("atm : "+atm);
	}
	
	public void spendMoney(int money) {
		atm -= money ;
		System.out.println("atm :"+ atm);
	}
	public void getBankInfo() {
		System.out.println("name : "+this.name);
		System.out.println("atm :"+atm);
	}
}
