package string;

public class StringTest {

	public static void main(String[] args) {
		String str1 = new String("java");
		String str2 = new String("android");
		
		System.out.println("처음 문자열 주소 값: "+System.identityHashCode(str1));
		
		// concat() 는 두 문자열을 연결해주는 String 메서드이다.
		str1 = str1.concat(str2);
		System.out.println(str1);
		System.out.println(System.identityHashCode(str1));
	}

}
