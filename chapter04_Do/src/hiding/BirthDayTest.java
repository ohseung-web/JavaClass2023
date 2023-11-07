package hiding;

public class BirthDayTest {

	public static void main(String[] args) {

		Birthday bir = new Birthday();
        // 2월달은 28일까지이므로 이런경우 코드오류는 아니지만 로직오류가 된다.
		bir.setMonth(3); 
		bir.setYear(2023);
		bir.setDay(30);
		
		System.out.println(bir.getYear()+"년 "+bir.getMonth()+"월 "+bir.getDay()+"일");
	}

}
