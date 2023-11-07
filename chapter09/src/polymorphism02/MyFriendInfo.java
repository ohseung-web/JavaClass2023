package polymorphism02;

public class MyFriendInfo {
	private String name;
	int age;
	
   public MyFriendInfo() {}
	public MyFriendInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void ShowMyFriendInfo() {
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
	}
}
