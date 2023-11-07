package template;

public class CarTest {

	public static void main(String[] args) {

		Car mycar = new ManualCar();
		mycar.run();
		System.out.println("==========");
		Car yourcar = new AiCar();
		yourcar.run();
	}

}
