package myCalendar;

import java.util.Calendar;

public class CalendarTest {

	private int year;  //사용자 입력 "년"
	private int month;  //사용자 입력 "달"
	private int lastDay;   //month의 마지막 일
	private int startWeek;  //month의 시작 요일

	Calendar day = Calendar.getInstance();
	String[] week = {"일","월","화","수","목","금","토"};
	int [][] calDisplay = new int[5][7];  // 달력 출력할 방

	CalendarTest(int year, int month){  //생성자를 통해 년, 월 받기
		this.year=year;
		this.month=month;
	}

	// 필드에 설정해놓은 lastDay와 startWeek 값을 찾아주는 메소드
	public void search(){
		//사용자 지정요일 값을 입력함
		day.set(year, month-1,1);
		//입력받은 달의 마지막 일 수 계산(30일, 31일 등)
		lastDay = day.getActualMaximum(day.DAY_OF_MONTH);
		//1이면 일요일, 2이면 월요일 ...순으로 입력 월의 시작 요일값 저장
		startWeek = day.get(day.DAY_OF_WEEK);
	}

	public void calInfo() {

		System.out.println();
		System.out.print("\t\t");
		System.out.print(day.get(Calendar.YEAR)+"年  ");
		System.out.println(day.get(Calendar.MONTH)+1+ "月");

		// 월화수목금토일 요일 출력
		System.out.println("---------------------------------------");
		for(int i=0;i<week.length; i++) {
			System.out.print(week[i]+"\t");
		}
		System.out.println();
		System.out.println("---------------------------------------");

		// 스타트 위치 지정
		// 일(1) ~ 토(7)
		int day = 1;
		int countDay=startWeek; // 시작요일

		// 시작요일전까지 tab으로 띄우기 
		for(int i=0; i<startWeek-1; i++) {
			System.out.print("\t");
		}
		// calDisaplay[5][7]에 달력 출력
		for(int i=0; i<calDisplay.length; i++) {
			for(int j=0; j<calDisplay[0].length; j++) {

				if(day <= lastDay) {
					calDisplay[i][j] = day++;
				}
				if(calDisplay[i][j] == 0) {
					break;
				}
				System.out.print(calDisplay[i][j]+"\t");

				if( countDay % 7==0 ){  // 7일까지 출력이후 다음줄로 개행
					System.out.println();
				}
				countDay++; 
			}
		}
	}


	/*
		// 필드의 값들을 활용하여 달력형태로 출력해주는 display()메소드
		public void display(){
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			//출력할 일 수
			int day=1;
			switch(startWeek){
			case 7:System.out.print(" \t");
			case 6: System.out.print(" \t");
			case 5: System.out.print(" \t");
			case 4: System.out.print(" \t");
			case 3: System.out.print(" \t");
			case 2: System.out.print(" \t");
			}
			//스타트 위치 지정
			int countDay=startWeek;
			for(int i=1;i<=lastDay;i++){
				System.out.print(i+"\t");
				if(countDay%7==0){
					System.out.println();
				}
				countDay++;
			}
		}

	 */

}


