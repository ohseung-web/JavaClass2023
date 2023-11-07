package classpart11;

public class MainClass {

	public static void main(String[] args) {
		ClassEx11 parkbank = new ClassEx11("¹ÚÂùÈ£");
        parkbank.depositMoney(100);
        parkbank.getBankInfo();
        System.out.println("--------------");
        
        ClassEx11 leebank = new ClassEx11("ÀÌ½Â¿±");
        leebank.depositMoney(200);
        leebank.getBankInfo();
        
        
	}

}
