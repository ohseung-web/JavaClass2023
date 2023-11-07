package polymorphism03;

public class HybridCar extends Car {
	int electricity;

	public int getElectricity() {
		return electricity;
	}

	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}

	@Override
	public void displayInfo() {
		System.out.println("--- HybridCar ���� ---");
		System.out.println("speed : " + getSpeed());
		System.out.println("oil : " + getOil());
		System.out.println("electricity : " + electricity);
	}
}
