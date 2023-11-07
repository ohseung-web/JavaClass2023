package hiding;

public class Birthday {
	// private : 값을 숨긴다.
	private int day; 
	private int month;
	private int year;
	
	// geter():출력, seter():입력 로  public 메서드를 open해준다.
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(month == 2) {
			if(day<1 || day>28) {
				System.out.println("날짜오류");
			}
		}else {
			this.day = day;
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
