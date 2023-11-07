package classPart02;

public class MainClass {

	public static void main(String[] args) {

		Grandeur myCar = new Grandeur();
		myCar.color ="blue";
		myCar.price = 200000;
		myCar.gear = "auto";
		myCar.run();
		myCar.info();
		System.out.println();
		
		Grandeur myCar2 = new Grandeur();
		myCar2.color ="black";
		myCar2.price = 300000;
		myCar2.gear = "manual";
		myCar2.run();
		myCar2.info();
		
		System.out.println();
		Bicycle myCycle = new Bicycle();
		myCycle.info();
		System.out.println();
		
		Bicycle myCycle2 = new Bicycle("red",250000);
		myCycle2.info();
		
	
	}

}
