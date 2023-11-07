package collection.hashsetEx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


class Person{
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }
    
    @Override
    public String toString() {
        return String.format("%s(%s)",this.name,this.age);
        
    }
    
    @Override
    public int hashCode() {
        return (this.name+this.age).hashCode();
        // return Objects.hash(name,age);
    }
    
    @Override
    public boolean equals(Object obj) {
        //p1.equals(p2)
        if(obj instanceof Person) {
            Person p = (Person)obj;
            return this.hashCode()==p.hashCode(); 
            // return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }
}
//----------------------------------------------------------------------------------
public class HashSetEx03 {

	public static void main(String[] args) {
		
		HashSet<Person> set = new HashSet<>();
		 
        // HashSet은 객체를 저장하기전에 기존에 같은 객체가 있는지 확인한다.
        // 같은 객체가 없으면 저장하고, 있으면 저장하지 않는다.
        //set.add("abc");
        //set.add("abc");
 
        // boolean add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출
        // equals()와 hashCode()가 오버라이딩 되어 있어야 한다.
        set.add(new Person("홍길동",33));
        set.add(new Person("이순신",35));
        set.add(new Person("홍길동",33));
 
        System.out.println(set);
 
        // Iterator : 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 것
        Iterator iterator = set.iterator(); // 값을 꺼내는 메소드를 이용한다.
        while (iterator.hasNext()) { // 읽어올 요소가 남아 있는가?
            System.out.println(iterator.next()); // 다음 요소를 읽어온다.
        }
        // HashSet는 데이터에 순서가 없기 때문에 데이터를 순서대로 읽어오거나,
        // 특정 위치의 데이터를 읽어올 수 있는 방법이 없기 때문에
        // "Iterator" 메소드를 활용해서 집합에 있는 "전체" 데이터를 불러올 수 있다.
    }
	     
	}


