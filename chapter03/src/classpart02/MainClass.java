package classpart02;

import classpart02.Grandeur;
import classpart02.Bicycle;

public class MainClass {

	public static void main(String[] args) {
		Grandeur myCar = new Grandeur();
		myCar.color ="red";
		myCar.gear ="auto";
		myCar.price =30000000;

		myCar.run();
		myCar.stop();
		myCar.info();

		System.out.println();

		Grandeur myCar2 = new Grandeur();
		myCar2.color = "blue";
		myCar2.gear = "manual";
		myCar2.price = 25000000;

		myCar2.run();
		myCar2.stop();
		myCar2.info();

		System.out.println();

		Bicycle myBicycle1 = new Bicycle();
		myBicycle1.info();

		System.out.println();

		Bicycle myBicycle2 = new Bicycle("red", 100000);
		myBicycle2.info();

			
	}
	
}
