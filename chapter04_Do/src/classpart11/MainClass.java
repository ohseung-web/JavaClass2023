package classpart11;

public class MainClass {

	public static void main(String[] args) {
		ClassEx11 parkbank = new ClassEx11("����ȣ");
        parkbank.depositMoney(100);
        parkbank.getBankInfo();
        System.out.println("--------------");
        
        ClassEx11 leebank = new ClassEx11("�̽¿�");
        leebank.depositMoney(200);
        leebank.getBankInfo();
        
        
	}

}
