package innerClass02;

 interface Remocon {
	public void on();
	public void off();
}

 class Machine {
	Remocon tv = new Remocon() {
		@Override
		public void on() {
			System.out.println("TVÀ» ÄÕ´Ï´Ù");
		}
		@Override
		public void off() {
			System.out.println("TVÀ» ²ü´Ï´Ù.");
		}
	};
	
	Remocon radio = new Remocon() {
		@Override
		public void on() {
			System.out.println("radio¸¦ ÄÕ´Ï´Ù");
		}
		
		@Override
		public void off() {
			System.out.println("radio¸¦ ²ü´Ï´Ù.");
		}
	};
}
  
public class Main03 {

	public static void main(String[] args) {

		Machine machine = new Machine();
		machine.tv.on();   //TV¸¦ ÄÕ´Ï´Ù.
		machine.tv.off();  //TV¸¦ ²ü´Ï´Ù. 
		machine.radio.on();
		machine.radio.off();
	}	
}
