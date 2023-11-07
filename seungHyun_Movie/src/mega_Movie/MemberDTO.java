package mega_Movie;

public class MemberDTO {

	private String id;
	private String pw;
	private String phone;
	private String birdate;
	private String email;
	private int point=0;
	
	
	public MemberDTO() {}
	public MemberDTO(String id, String pw, String phone, String birdate, String email, int point) {
		this.id =id;
		this.pw =pw;
		this.phone = phone;
        this.birdate = birdate;
        this.email = email;
        this.point = point + 1000;
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getBirdate() {return birdate;}
	public void setBirdate(String birdate) {this.birdate = birdate;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public int getPoint() {return point;}
	public void setPoint(int point) {this.point = point;}
	
}
