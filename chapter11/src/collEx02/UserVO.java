package collEx02;


public class UserVO {

	private String name; 
	private int age;  

	public UserVO() {}
	public UserVO(String name, int age){ 	
	this.name = name; 	this.age = age; 
	} 

	public String getName() { 	
	return name; 
	} 

	public void setName(String name) { 	
	this.name = name; 
	}

	 public int getAge() { 	
	 return age; 
	 } 
	 
	 public void setAge(int age) { 	
	 this.age = age; 
	 }
	
	/*
	@Override
	public int compareTo(UserVO uservo) {
		
		//return (this.age - uservo.age);
		
		if(this.age == uservo.age) {
			return this.name.compareTo(uservo.name);
		}
		return (this.age - uservo.age);
		
	}
    */
	 
	@Override
    public String toString() {
        return String.format("%s(%s)", this.name, this.age);
    }
	
}
