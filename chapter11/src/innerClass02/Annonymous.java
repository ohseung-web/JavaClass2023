package innerClass02;

//�θ� Ŭ����
class Animal {

	public String bark() {
		return "������ ��ϴ�";
	}
}

public class Annonymous {

	public static void main(String[] args) {

		// �͸� Ŭ���� : Ŭ���� ���ǿ� ��üȭ�� ���ÿ�. ��ȸ������ ���
		Animal dog = new Animal() {
			@Override
			public String bark() {
				return "���� ¢���ϴ�";
			}
		}; // �� �͸� Ŭ������ ���� �����ݷ��� �ݵ�� �ٿ� �־�� �Ѵ�.

		Animal cat = new Animal() {

			@Override
			public String bark() {
				return "����̰� ��ϴ�.";
			}
		};
		
		// �͸� Ŭ���� ��ü ���
		System.out.println(dog.bark());
		System.out.println(cat.bark());
	}

}
