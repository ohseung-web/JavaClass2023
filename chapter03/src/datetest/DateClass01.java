package datetest;
import java.util.Date;
public class DateClass01 {

	public static void main(String[] args) {
		/*
		* # Date Ŭ������ Ȱ��
		 * . Date Ŭ���� ��ü���� ��, ��, ��, ��, ��, �ʸ� ��������
		 * . get���� �����ϴ� �޼ҵ带 ����Ѵ�.
		 * . �����Ϸ��� set���� �����ϴ� �޼ҵ带 ����ϸ� �ȴ�.
		 * 
		 * . Date Ŭ������ 1900���� �������� ��¥�� ó���Ѵ�.
		 * . ���� �������� 1900�� ���ؼ� ���;� �ϰ� �־��� ���� 1900�� ���� �־���� �Ѵ�.
		 * . ���� �������� 1�� ���ؼ� ���;� �ϰ� �־��� ���� 1�� ���� �־���� �Ѵ�.
		 */		
		
		Date date = new Date();	
		System.out.println("�� : " + date.getYear());
		System.out.println("�� : " + (date.getYear() + 1900));
		System.out.println("�� : " + (date.getMonth()));
		System.out.println("�� : " + (date.getMonth() + 1));
		System.out.println("�� : " + date.getDate());
		
		System.out.println("���� : "+ date.getDay());			
		// �Ͽ���(0), ������(1), ..., �����(6)
		
		System.out.println("�� : " + date.getHours());
		System.out.println("�� : " + date.getMinutes());
		System.out.println("�� : " + date.getSeconds());
	
		
	}

}
