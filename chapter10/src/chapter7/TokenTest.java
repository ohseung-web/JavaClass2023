package chapter7;

import java.util.StringTokenizer;

public class TokenTest {
	public static void main(String[] args) {
		
        // StringTokenizer ������� 3����
		String str = "java android";
		String str1 = "java!android ";
		String str2 = "java!android-fun";
		
		StringTokenizer st1 = new StringTokenizer(str);
		// nextToken() : ��ü���� ������ū�� ��ȯ 
		System.out.println(st1.nextToken()); 
		System.out.println(st1.nextToken());
		
		StringTokenizer st3 = new StringTokenizer(str1,"!");
		for(int i=0;i<2;i++) {
			System.out.println(st3.nextToken());
		}
		// ������ �����ڸ� �ڸ���
		StringTokenizer st4 = new StringTokenizer(str2,"!-");
		for(int i=0;i<3;i++) {
			// st4.nextToken().trim() : Ȥ�� �� ������ ����
			System.out.println(st4.nextToken().trim());
			
		}
		// true�� �Է��ϸ� �����ڷ� ������ ! ���� ��ū���� �־��ش�.
		StringTokenizer st5 = new StringTokenizer(str1,"!",true);
		for(int i=0;i<3;i++) {
			System.out.println(st5.nextToken());
		}
	}

}
