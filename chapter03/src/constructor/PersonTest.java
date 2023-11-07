package constructor;

class Person{
	
	String name;
	float height;
	float weight;
	
	public Person() {}
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, float height, float weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
}

public class PersonTest {

	public static void main(String[] args) {
         Person personLee = new Person();
	}

}
