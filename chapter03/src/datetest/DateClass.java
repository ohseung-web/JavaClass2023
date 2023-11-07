package datetest;
import java.util.Date;//��,��,��,����
import java.text.SimpleDateFormat;
// �� Ŭ������ ��¥�� ���ϴ� ����(=����)���� �Ľ̽��� �ִ� ��Ȱ�� �Ѵ�.
// y=>��, M=>��, d=>��, E=>����, a=>����/����
// H=>�ð�(24�ð���), h(12�ð��� am/pm), m=>��, s=>��

public class DateClass {

	public static void main(String[] args) {
		// ���� ��ǻ�� �ý����� ��¥�� �ð��� ���´�.
		Date date = new Date();	
		// Fri Jan 07 13:55:03 KST 2022
		// KST (Korea Standard Time)����
		// KST�� �츮���� �ð��븦 �ǹ��ϴ� ǥ��� KST �� UTC +9 �� �ش��Ѵ�. ����ð��� 9�ð� ���� �ð�
		// ���� ����ø� ����� �ϸ� Coordinated Universal Time �̸� UTC�� �Ѵ�.
		System.out.println(date);

		/*
		    [1] ��¥ �� �ð� ��� ���� ���� ���
		 *  	. ��¥ �� �ð� ���Ŀ� ���Ǵ� �����ڸ� ������ ������ ���ڴ� �Է��ϴ� �״�� ��µȴ�.
		 *  	. Date date = new Date();
		 *  	. SimpleDateFormat sdf = new SimpleDateFormat("��¥ �� �ð� ����");
		 *  [2] ��¥ �� �ð� ���� ���� ���
		 *  	. sdf.format(date);
		 *  [3] ��¥ �� ���� ��� ���� ������ ����
		 *  	. ���ۿ��� "simpledateformat ��¥ ����" ��� �˻��ϱ�
		 */
		SimpleDateFormat sd = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
		System.out.println(sd.format(date));
		SimpleDateFormat sd2 = new SimpleDateFormat("yyyy.MM.dd(E) HH:mm");
		System.out.println(sd2.format(date));

		/*
		     System.currentTimeMillis()
		 * . 1970�� 1�� 1�� ���� ���� �� �޼ҵ尡 ����Ǵ� �������� ������ �ð��� �и���(1/1000��) ������ ���´�.
		 * . 13�ڸ��� ���ڸ� ������ ������ int�� ó���ϸ� ������ �߻��ǹǷ� long�� ó���ؾ� �Ѵ�.
		 */

		 // int time = System.currentTimeMillis();		// ���� �߻�

		long time = System.currentTimeMillis();
		System.out.println(time);
		System.out.println(sd2.format(time));


	}

}
