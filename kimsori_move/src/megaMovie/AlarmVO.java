package megaMovie;

import java.util.Date;

public class AlarmVO {

	private int log; //�α����� ��� �ε��� ��ȣ
	private Date day; //��ȭ �� �ð�
	private String alarm; //������ ��ȭ
	
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
