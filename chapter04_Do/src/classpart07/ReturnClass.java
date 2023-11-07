package classpart07;

public class ReturnClass {

	public void Retrunint() {
		int k =10;
	}

	public String ReturnString() {
		return "ÀÚ¹Ù";
	}
	public static void main(String[] args) {
		ReturnClass re = new ReturnClass();  
		re.Retrunint();
		String reS = re.ReturnString();
		System.out.println();
		System.out.println(reS);
	}

}
