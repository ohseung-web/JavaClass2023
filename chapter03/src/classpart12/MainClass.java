package classpart12;

public class MainClass {

	public static void main(String[] args) {
         ClassEx11 parkbank = new ClassEx11("����ȣ");
         parkbank.sMoney(100);
 		
         ClassEx11 leebank = new ClassEx11("�̽¿�");
 		leebank.sMoney(200);
 		
 		leebank.getBankInfo();
 		parkbank.sMoney(400);
 		leebank.getBankInfo();
	}

}
