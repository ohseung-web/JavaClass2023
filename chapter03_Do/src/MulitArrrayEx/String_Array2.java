package MulitArrrayEx;
import java.util.*;
public class String_Array2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = "ȫ�浿";

		System.out.print("�̸��� �Է��ϼ��� : ");
		String myName = scan.next();
		System.out.println(myName);
		if(name == myName) {
			System.out.println("== ������ : ��ġ");
		}else {
			System.out.println("== ������ : ����ġ");
		}
		
		if(name.equals(myName)) {
			System.out.println("equals() �޼��� : ��ġ");
		}else {
			System.out.println("equals() �޼��� : ����ġ");
		}
		
	}

}
