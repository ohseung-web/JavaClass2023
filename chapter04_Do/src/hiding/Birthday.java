package hiding;

public class Birthday {
	// private : ���� �����.
	private int day; 
	private int month;
	private int year;
	
	// geter():���, seter():�Է� ��  public �޼��带 open���ش�.
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(month == 2) {
			if(day<1 || day>28) {
				System.out.println("��¥����");
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
