package string;

public class StringBuilderTest {

	public static void main(String[] args) {
   
		String str1 = new String("java");
		System.out.println("str1�� ���ڿ� �ּ� : "+System.identityHashCode(str1));
		
		StringBuilder buffer = new StringBuilder(str1);
		System.out.println("buffer�� ���ڿ� �ּ� : "+System.identityHashCode(buffer));
		
		buffer.append(" and"); // append StringBuilder�� �߰� �޼���
		buffer.append(" android");
		buffer.append(" programming is fun!1");
		System.out.println("���ڿ����� ���� : "+System.identityHashCode(buffer));
		
		String str2 = buffer.toString();
		System.out.println(str2);
		System.out.println(System.identityHashCode(str2));
		
		Integer in = 100;
				
	}

}
