package referclass03;

//���� ����
class BirthDay{
	// private ���������ڴ� ���� Ŭ���������� ��밡��
	private int month;
	private int day;
	private int year;
	
	// geter, setter �۾�
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
				System.out.println("��¥����");
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
       
       System.out.println(bi.getYear()+"�� "+bi.getMonth()+"�� "+bi.getDay()+"��");
	}

}
