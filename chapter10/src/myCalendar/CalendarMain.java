package myCalendar;

import java.util.Scanner;

public class CalendarMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);
		//사용자로부터 값을 입력받음
		System.out.print("년도 입력: ");
		int year = scan.nextInt();
		System.out.print("월 입력: ");
		int month = scan.nextInt();

		//CalendarTest 클래스 호출
		CalendarTest cal = new CalendarTest(year, month);
		//메소드 호출
		cal.search();
		cal.calInfo();

	}

}
