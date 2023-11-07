package string;

public class StringBuilderTest {

	public static void main(String[] args) {
   
		String str1 = new String("java");
		System.out.println("str1의 문자열 주소 : "+System.identityHashCode(str1));
		
		StringBuilder buffer = new StringBuilder(str1);
		System.out.println("buffer의 문자열 주소 : "+System.identityHashCode(buffer));
		
		buffer.append(" and"); // append StringBuilder의 추가 메서드
		buffer.append(" android");
		buffer.append(" programming is fun!1");
		System.out.println("문자연결한 상태 : "+System.identityHashCode(buffer));
		
		String str2 = buffer.toString();
		System.out.println(str2);
		System.out.println(System.identityHashCode(str2));
		
		Integer in = 100;
				
	}

}
