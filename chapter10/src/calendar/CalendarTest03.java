package calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calendar mytoday = Calendar.getInstance();
		final String[] week= {"��","��","ȭ","��","��","��","��"};

		System.out.print("��  ��  �� �Է� :");
		int myYear = scan.nextInt();
		int myMonth= scan.nextInt()-1; // 0: 1�� �̹Ƿ� �Է��� �� -1�� �������� ���� ������ �ִ� 0~11���� ���� �����
		int myDay = scan.nextInt();

		mytoday.set(myYear, myMonth, myDay);
		System.out.print(mytoday.get(Calendar.YEAR)+"�� ");
		System.out.print((mytoday.get(Calendar.MONTH)+1)+"�� "); // �Է¹��� ���� get()���� ����� ���� +1�� �������� 1~12�� �����.
		System.out.print(mytoday.get(Calendar.DATE)+"�� ");
		System.out.println(week[mytoday.get(Calendar.DAY_OF_WEEK)-1]+"����");

	}

}
