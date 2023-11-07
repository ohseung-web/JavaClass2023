package polymorphism;

import java.util.ArrayList;

class Animal {
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Hauman extends Animal{
	public void move() {
		System.out.println("사람은 두발로 걷습니다.");
	}
	public void readbook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}

class Tiger extends Animal{
	public void move() {
		System.out.println("호랑이가 네발로 뜁니다.");
	}
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

class Eagle extends Animal{
	public void move() {
		System.out.println("독수리가 하늘을 날읍니다.");
	}
	public void flying() {
		System.out.println("하늘을 날아 갑니다.");
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
	
		// 다운캐스팅 
		
		if(animal instanceof Hauman) { // animal 인스턴스 자료형이 Hauman 형 이라면
			Hauman hauman = (Hauman)animal; // 인스턴스 animal을 Hauman으로 다운캐스팅
			hauman.readbook();
		}else if(animal instanceof Tiger){
			Tiger tiger = (Tiger)animal;
			tiger.hunting();
		}else if(animal instanceof Eagle){
			Eagle eagle = (Eagle)animal;
			eagle.flying();
		}else {
			System.out.println("지원되지 않는 기능입니다.");
		}
		
	}

}
