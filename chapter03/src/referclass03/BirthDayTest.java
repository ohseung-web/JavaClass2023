package referclass03;

//정보 은닉
class BirthDay{
	// private 접근제어자는 같은 클래스에서만 사용가능
	private int month;
	private int day;
	private int year;
	
	// geter, setter 작업
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(month == 2) {
			if(day<1 || day>28) {
				System.out.println("날짜오류");
			}else {
				this.day = day;
			}
		}
			this.day = day;
		
	}
	
}
public class BirthDayTest {

	public static void main(String[] args) {
       BirthDay bi = new BirthDay();
       bi.setMonth(2);
       bi.setDay(28);
       bi.setYear(2021);
       
       System.out.println(bi.getYear()+"년 "+bi.getMonth()+"월 "+bi.getDay()+"일");
	}

}
