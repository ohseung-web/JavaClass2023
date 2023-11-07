package innerClass02;

interface IAnimal {
	public String aa();
}

interface ICreature {
	public String bb();
}

abstract class myClass {
	int num = 20;
}


public class Main02 {

	public static void main(String[] args) {

		// �������̽� �ΰ��� ������ ��ȸ�� Ŭ���� (��ȸ�� �̶� ��¿�� ���� ���� ����)
		class useClass1 implements IAnimal, ICreature {
			@Override
			public String bb() {
				return "ȣ����";
			}
			@Override
			public String aa() {
				return "��縮";
			}
		}

			// Ŭ������ �������̽��� ���, ������ ��ȸ�� Ŭ���� (��ȸ�� �̶� ��¿�� ���� ���� ����)
			class useClass2 extends myClass implements IAnimal {
				@Override
				public String aa() {
					return "�̳�";
				}
			}
			
			//------------------------------------------------------------------------------------------
				useClass1 u1 = new useClass1() {

					@Override
					public String aa() {
						return super.aa();
					}
                      
				};
                  System.out.println(u1.aa());

				useClass2 u2 = new useClass2() {

					@Override
					public String aa() {
						return "�ڳ���";
					}
					
				};
				System.out.println(u2.aa());

			}
		}