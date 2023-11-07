package innerClass02;

 interface Remocon {
	public void on();
	public void off();
}

 class Machine {
	Remocon tv = new Remocon() {
		@Override
		public void on() {
			System.out.println("TV�� �մϴ�");
		}
		@Override
		public void off() {
			System.out.println("TV�� ���ϴ�.");
		}
	};
	
	Remocon radio = new Remocon() {
		@Override
		public void on() {
			System.out.println("radio�� �մϴ�");
		}
		
		@Override
		public void off() {
			System.out.println("radio�� ���ϴ�.");
		}
	};
}
  
public class Main03 {

	public static void main(String[] args) {

		Machine machine = new Machine();
		machine.tv.on();   //TV�� �մϴ�.
		machine.tv.off();  //TV�� ���ϴ�. 
		machine.radio.on();
		machine.radio.off();
	}	
}
