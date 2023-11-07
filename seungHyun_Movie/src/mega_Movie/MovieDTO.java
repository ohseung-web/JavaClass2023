package mega_Movie;

import java.util.*;

public class MovieDTO {

	Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR)-1900;
    int month = cal.get(Calendar.MONTH)+1; // get()은 0~30까지 정수리턴
    int date = cal.get(Calendar.DATE);

	Date current = new Date();
	int day1 = current.getDate();
	int day2 = current.getDate()+1;
	int day3 = current.getDate()+2;
	
	private String[] movie= {"웅남이    ","소울메이트","패왕별희"};
	private Date[] day = {new Date(year,month-1,21), new Date(year,month-1,16), new Date(year,month-1,22)}; //개봉일
	private String local;  
	private String Theater; 
	private Date[] time = {new Date(year, month-1,day1,11,00), new Date(year, month-1,day1,14,30), new Date(year, month-1,day1,18,00)};
	private Date[] time2 = {new Date(year,month-1,day2,12,30), new Date(year,month-1,day2,15,00), new Date(year,month-1,day2,19,00)};
	private Date[] time3 = {new Date(year,month-1,day3,10,30), new Date(year,month-1,day3,16,30), new Date(year,month-1,day3,22,00)};
	int preview[][] = {{2, 26}, {2, 51}, {3, 4}}; //영화당 시간
	int num;
	String firstTheater;
	
	public String getFirstTheater() {
		return firstTheater;
	}
	public void setFirstTheater(String firstTheater) {
		this.firstTheater = firstTheater;
	}
	public MovieDTO() {}
	public MovieDTO(int num, String local, String Theater, String firstTheater) {
		this.num = num;
		this.local = local;
		this.Theater = Theater;
		this.firstTheater = firstTheater;
	}
	
	public String[] getMovie() {
		return movie;
	}
	public Date[] getDay() {
		return day;
	}
	public void setDay(Date[] day) {
		this.day = day;
	}
	public void setMovie(String[] movie) {
		this.movie = movie;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getTheater() {
		return Theater;
	}
	public void setTheater(String theater) {
		Theater = theater;
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
	public int[][] getPreview() {
		return preview;
	}
	public void setPreview(int[][] preview) {
		this.preview = preview;
	}
	
	
}
