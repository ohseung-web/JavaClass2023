package megaMovie;

import java.util.Date;

public class AlarmVO {

	private int log; //로그인한 사람 인덱스 번호
	private Date day; //영화 볼 시간
	private String alarm; //예매한 영화
	
	public AlarmVO() {}
	
	public AlarmVO(int log, Date day, String alarm) {
		this.log = log;
		this.day = day;
		this.alarm = alarm;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getLog() {
		return log;
	}

	public void setLog(int log) {
		this.log = log;
	}

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}
	
}
