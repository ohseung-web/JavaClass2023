package datetest;
import java.util.Date;
public class DateClass01 {

	public static void main(String[] args) {
		/*
		* # Date 클래스의 활용
		 * . Date 클래스 객체에서 년, 월, 일, 시, 분, 초를 얻어오려면
		 * . get으로 시작하는 메소드를 사용한다.
		 * . 수정하려면 set으로 시작하는 메소드를 사용하면 된다.
		 * 
		 * . Date 클래스는 1900년을 기준으로 날짜를 처리한다.
		 * . 년을 얻어오려면 1900을 더해서 얻어와야 하고 넣어줄 때는 1900을 빼서 넣어줘야 한다.
		 * . 월을 얻어오려면 1을 더해서 얻어와야 하고 넣어줄 때는 1을 빼서 넣어줘야 한다.
		 */		
		
		Date date = new Date();	
		System.out.println("년 : " + date.getYear());
		System.out.println("년 : " + (date.getYear() + 1900));
		System.out.println("월 : " + (date.getMonth()));
		System.out.println("월 : " + (date.getMonth() + 1));
		System.out.println("일 : " + date.getDate());
		
		System.out.println("요일 : "+ date.getDay());			
		// 일요일(0), 월요일(1), ..., 토요일(6)
		
		System.out.println("시 : " + date.getHours());
		System.out.println("분 : " + date.getMinutes());
		System.out.println("초 : " + date.getSeconds());
	
		
	}

}
