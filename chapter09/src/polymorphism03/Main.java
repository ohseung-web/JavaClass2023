package polymorphism03;

public class Main {

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle();
		Car c1 = new Car();
		HybridCar h1 = new HybridCar();

		v1.displayInfo();
		System.out.println();
		c1.displayInfo();
		System.out.println();
		h1.displayInfo();

		System.out.println();
		System.out.println();

		Vehicle car1 = new Car();
		Vehicle car2 = new HybridCar();
		Car car3 = new HybridCar();

		car1.displayInfo();
		System.out.println();
		car2.displayInfo();
		System.out.println();
		car3.displayInfo();
	}

}
