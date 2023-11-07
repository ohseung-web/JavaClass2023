package megaMovie;

import java.util.Date;

public class PointVO {

	private String id; //포인트 적립한 회원
	private String use; //포인트 사용내역
	private int point; //사용한 포인트
	private Date day; //사용일자
	
	public PointVO() {}
	
	public PointVO(String id, String use, int point, Date day) {
		this.id = id;
		this.use = use;
		this.point = point;
		this.day = day;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
