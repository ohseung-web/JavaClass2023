package megaMovie;

import java.util.Date;

public class TicketingVO {

//	장바구니
	private String id; //영화구매한 회원
	private String name; //영화이름
	private String local; //지역
	private String Theater; //영화관
	private Date dath; //예매일
	private Date time; //영화 볼 시간
	private String ticket; //예매한 열
	private int cnt; //구매한 영화 갯수
	private int price; //영화금액
	private int point; //포인트 사용
	
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
