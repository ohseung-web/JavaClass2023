package generic;

public class Plastic extends Material {
	@Override
	public String toString() {
		return "재료는 Plastic 입니다.";
	}

	@Override
	public void doprinting() {
		System.out.println("Plastic 재료로 출력중 입니다.");
	}
}
