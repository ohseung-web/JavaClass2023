package interfaceEx02;

public class UserMain {

	public static void main(String[] args) {
		Animal cat = new Cat();
		Animal mo = new Monkey();
		Animal ch = new Chicken();

		cat.eat("����");
		mo.eat("����");
		ch.eat("���");
		System.out.println();

		cat.work("�׹߷�");
		mo.work("�׹� �Ǵ� �ι߷�");
		ch.work("�ι߷�");

		System.out.println();
		cat.sleep("�������");
		mo.sleep("������");
		ch.sleep("����");
	}

}
