package leejunhun;

// abstract도 상속의 일종임.
// private는 변수 자체가 상속이 안됌.
// Administrator Full inspection 통과
public class Administrator extends User{
	private String id;
	private String pw;
	
	private String acctype;
	
	private String name;
	private String tel;
	private String email;
	private int validate;
	
	private int adminlevel;
	public Administrator() {}
	public Administrator(String id, String pw, String name, String tel, String email, int adminlevel) {
		this.id = id;
		this.pw = pw;
		this.acctype = "Administrator";
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.validate = 1;
		this.adminlevel = adminlevel;
	}
	
	
	public int getValidate() {
		return validate;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getEmail() {
		return email;
	}
	public int getAdminlevel() {
		return adminlevel;
	}

}
