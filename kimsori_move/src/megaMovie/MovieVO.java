package megaMovie;
import java.util.Calendar;
import java.util.Date;

public class MovieVO {

//	private String movie; //영화이름
//	private double advance; //예매율: A(예매관객수) / B(전체 예매관객수) * 100
//	private Date day; //개봉일
	
	Calendar cal = Calendar.getInstance();
	Date current = new Date();
	int day1 = current.getDate();
	int day2 = current.getDate()+1;
	int day3 = current.getDate()+2;
	
	private String[] movie = {"레미제라블", "패왕별희", "버터플라이"}; //영화이름
	private int[] price = {12000, 13000, 11000};
	private int[] people = {0, 0, 0};
	double[] advance = {0, 0, 0}; //예매율: A(예매관객수) / B(전체 예매관객수) * 100
	private Date[] day = {new Date(2020,05,21), new Date(2020,05,16), new Date(2020,05,22)}; //개봉일
	private String[] local = {"서울", "경기도", "인천"};
	private String[] sTheater = {"동대문", "목동", "성수"};
	private String[] gTheater = {"남양주", "동탄", "백석"};
	private String[] iTheater = {"검단", "성도", "청라"};
	private int[] dath = {day1,day2,day3};
//	영화별, 극장별 시간이 다 다르게 넣어주기!(고칠거)
	private Date[] time = {new Date(2020,05,day1,11,00), new Date(2020,05,day1,14,30), new Date(2020,05,day1,18,00)};
	private Date[] time2 = {new Date(2020,05,day2,12,30), new Date(2020,05,day2,15,00), new Date(2020,05,day2,19,00)};
	private Date[] time3 = {new Date(2020,05,day3,10,30), new Date(2020,05,day3,16,30), new Date(2020,05,day3,22,00)};
	int preview[][] = {{2, 26}, {2, 51}, {3, 4}}; //영화당 시간
	
	private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
	
	public MovieVO() {}
	
	public int[] getPrice() {
		return price;
	}

	public void setPrice(int[] price) {
		this.price = price;
	}

	public int[] getPeople() {
		return people;
	}

	public void setPeople(int[] people) {
		this.people = people;
	}

	public String[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String[] alphabet) {
		this.alphabet = alphabet;
	}

	public int[] getDath() {
		return dath;
	}

	public void setDath(int[] dath) {
		this.dath = dath;
	}

	public Date[] getTime() {
		return time;
	}

	public void setTime(Date[] time) {
		this.time = time;
	}

	public Date[] getTime2() {
		return time2;
	}

	public void setTime2(Date[] time2) {
		this.time2 = time2;
	}

	public Date[] getTime3() {
		return time3;
	}

	public void setTime3(Date[] time3) {
		this.time3 = time3;
	}

	public String[] getLocal() {
		return local;
	}

	public void setLocal(String[] local) {
		this.local = local;
	}

	public String[] getsTheater() {
		return sTheater;
	}

	public void setsTheater(String[] sTheater) {
		this.sTheater = sTheater;
	}

	public String[] getgTheater() {
		return gTheater;
	}

	public void setgTheater(String[] gTheater) {
		this.gTheater = gTheater;
	}
	
	public String[] getiTheater() {
		return iTheater;
	}
	
	public void setiTheater(String[] iTheater) {
		this.iTheater = iTheater;
	}

	public String[] getMovie() {
		return movie;
	}

	public void setMovie(String[] movie) {
		this.movie = movie;
	}

	public Date[] getDay() {
		return day;
	}

	public void setDay(Date[] day) {
		
		this.day = day;
	}
	
	
	
}