package myCalendar;

import java.util.Scanner;

public class CalendarMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);
		//����ڷκ��� ���� �Է¹���
		System.out.print("�⵵ �Է�: ");
		int year = scan.nextInt();
		System.out.print("�� �Է�: ");
		int month = scan.nextInt();

		//CalendarTest Ŭ���� ȣ��
		CalendarTest cal = new CalendarTest(year, month);
		//�޼ҵ� ȣ��
		cal.search();
		cal.calInfo();

	}

}
