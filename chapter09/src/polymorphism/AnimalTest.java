package polymorphism;

import java.util.ArrayList;

class Animal {
	public void move() {
		System.out.println("������ �����Դϴ�.");
	}
}

class Hauman extends Animal{
	public void move() {
		System.out.println("����� �ι߷� �Ƚ��ϴ�.");
	}
	public void readbook() {
		System.out.println("����� å�� �н��ϴ�.");
	}
}

class Tiger extends Animal{
	public void move() {
		System.out.println("ȣ���̰� �׹߷� �ݴϴ�.");
	}
	public void hunting() {
		System.out.println("ȣ���̰� ����� �մϴ�.");
	}
}

class Eagle extends Animal{
	public void move() {
		System.out.println("�������� �ϴ��� �����ϴ�.");
	}
	public void flying() {
		System.out.println("�ϴ��� ���� ���ϴ�.");
	}
}
public class AnimalTest {

	public static void main(String[] args) {
		 
		AnimalTest  atest = new AnimalTest();
            atest.moveAnimal(new Hauman());
            atest.moveAnimal(new Tiger());
            atest.moveAnimal(new Eagle());
		
		/*
		Animal[] animalList = new Animal[3];
		animalList[0]  = new Hauman();
		animalList[1]  = new Tiger();
		animalList[2]  = new Eagle();

		for(int i=0;i<animalList.length;i++) {
			animalList[i].move();
		}

		ArrayList<Animal> animalList2 = new ArrayList<>();
		animalList2.add(new Hauman());
		
		for(int i=0;i<animalList2.size();i++) {
			animalList2.get(i).move();
		}
  */
	}

	public void moveAnimal(Animal animal) {
		animal.move();
	
		// �ٿ�ĳ���� 
		
		if(animal instanceof Hauman) { // animal �ν��Ͻ� �ڷ����� Hauman �� �̶��
			Hauman hauman = (Hauman)animal; // �ν��Ͻ� animal�� Hauman���� �ٿ�ĳ����
			hauman.readbook();
		}else if(animal instanceof Tiger){
			Tiger tiger = (Tiger)animal;
			tiger.hunting();
		}else if(animal instanceof Eagle){
			Eagle eagle = (Eagle)animal;
			eagle.flying();
		}else {
			System.out.println("�������� �ʴ� ����Դϴ�.");
		}
		
	}

}
