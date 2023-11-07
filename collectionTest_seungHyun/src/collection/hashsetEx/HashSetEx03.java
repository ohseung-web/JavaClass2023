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
		 
        // HashSet�� ��ü�� �����ϱ����� ������ ���� ��ü�� �ִ��� Ȯ���Ѵ�.
        // ���� ��ü�� ������ �����ϰ�, ������ �������� �ʴ´�.
        //set.add("abc");
        //set.add("abc");
 
        // boolean add(Object o)�� ������ ��ü�� equals()�� hashCode()�� ȣ��
        // equals()�� hashCode()�� �������̵� �Ǿ� �־�� �Ѵ�.
        set.add(new Person("ȫ�浿",33));
        set.add(new Person("�̼���",35));
        set.add(new Person("ȫ�浿",33));
 
        System.out.println(set);
 
        // Iterator : �÷��ǿ� ����� ��ҵ��� �о���� ����� ǥ��ȭ�� ��
        Iterator iterator = set.iterator(); // ���� ������ �޼ҵ带 �̿��Ѵ�.
        while (iterator.hasNext()) { // �о�� ��Ұ� ���� �ִ°�?
            System.out.println(iterator.next()); // ���� ��Ҹ� �о�´�.
        }
        // HashSet�� �����Ϳ� ������ ���� ������ �����͸� ������� �о���ų�,
        // Ư�� ��ġ�� �����͸� �о�� �� �ִ� ����� ���� ������
        // "Iterator" �޼ҵ带 Ȱ���ؼ� ���տ� �ִ� "��ü" �����͸� �ҷ��� �� �ִ�.
    }
	     
	}


