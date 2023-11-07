package polymorphism03;

public class Vehicle {
	  int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void displayInfo() {
		System.out.println("--- Vehicle Á¤º¸ ---");
		System.out.println("speed : " + speed);
	}
}
