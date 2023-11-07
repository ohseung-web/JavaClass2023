package megaMovie;

public class UserVO {

	private String id;
	private String pw;
	private String nickName;
	private int birth;
	private String tel;
	private String email;
	private int point;
	
	public UserVO() {}
	
	public UserVO(String id, String pw, String nickName, int birth, String tel, String email) {
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
		point = point + 1000;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point =  this.point + point;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}
	
}
