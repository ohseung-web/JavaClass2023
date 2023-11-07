package megaMovie;

import java.util.Date;

public class TicketingVO {

//	��ٱ���
	private String id; //��ȭ������ ȸ��
	private String name; //��ȭ�̸�
	private String local; //����
	private String Theater; //��ȭ��
	private Date dath; //������
	private Date time; //��ȭ �� �ð�
	private String ticket; //������ ��
	private int cnt; //������ ��ȭ ����
	private int price; //��ȭ�ݾ�
	private int point; //����Ʈ ���
	
	public TicketingVO() {}
	
	public TicketingVO(String id, String name, String local, String Theater, Date dath, Date time, String ticket, int cnt, int price, int point) {
		this.id = id;
		this.name = name;
		this.local = local;
		this.Theater = Theater;
		this.dath = dath;
		this.time = time;
		this.ticket = ticket;
		this.cnt = cnt;
		this.price = price;
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getDath() {
		return dath;
	}

	public void setDath(Date dath) {
		this.dath = dath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
