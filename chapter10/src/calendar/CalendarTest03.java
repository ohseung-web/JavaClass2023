package calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calendar mytoday = Calendar.getInstance();
		final String[] week= {"일","월","화","수","목","금","토"};

		System.out.print("년  월  일 입력 :");
		int myYear = scan.nextInt();
		int myMonth= scan.nextInt()-1; // 0: 1월 이므로 입력할 때 -1을 해줌으로 원래 가지고 있던 0~11까지 값을 만든다
		int myDay = scan.nextInt();

		mytoday.set(myYear, myMonth, myDay);
		System.out.print(mytoday.get(Calendar.YEAR)+"년 ");
		System.out.print((mytoday.get(Calendar.MONTH)+1)+"월 "); // 입력받은 값을 get()으로 출력할 때는 +1을 해줌으로 1~12를 만든다.
		System.out.print(mytoday.get(Calendar.DATE)+"일 ");
		System.out.println(week[mytoday.get(Calendar.DAY_OF_WEEK)-1]+"요일");

	}

}
