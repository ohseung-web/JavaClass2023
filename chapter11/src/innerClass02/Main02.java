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

		// 인터페이스 두개를 구현한 일회용 클래스 (일회용 이라도 어쩔수 없이 따로 선언)
		class useClass1 implements IAnimal, ICreature {
			@Override
			public String bb() {
				return "호랑이";
			}
			@Override
			public String aa() {
				return "고사리";
			}
		}

			// 클래스와 인터페이스를 상속, 구현한 일회용 클래스 (일회용 이라도 어쩔수 없이 따로 선언)
			class useClass2 extends myClass implements IAnimal {
				@Override
				public String aa() {
					return "이끼";
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
						return "코끼리";
					}
					
				};
				System.out.println(u2.aa());

			}
		}