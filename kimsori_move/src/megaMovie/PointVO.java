package megaMovie;

import java.util.Date;

public class PointVO {

	private String id; //����Ʈ ������ ȸ��
	private String use; //����Ʈ ��볻��
	private int point; //����� ����Ʈ
	private Date day; //�������
	
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
