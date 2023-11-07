package polymorphism02;

public class MyFriendDetailInfo extends MyFriendInfo{
	private String addr;
  	private String phone;
  	
  	public MyFriendDetailInfo(String name, int age, String addr, String phone) {
  		super(name, age);
  		this.addr = addr;
  		this.phone = phone;
  	}
 
	public void ShowMyFriendDetailInfo()
	{
		ShowMyFriendInfo();
		System.out.println("주소: "+ addr);
		System.out.println("전화: "+ phone);
	}
}
