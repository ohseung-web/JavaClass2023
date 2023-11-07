package interfaceEx02;

public class Chicken implements Animal {

	@Override
	public void eat(String bab) {
		System.out.println("´ßÀº "+bab+"À» ¸Ô¾î¿ä.");
	}

	@Override
	public void work(String move) {
		System.out.println("´ßÀº "+move+"°É¾î¿ä.");
	}

	@Override
	public void sleep(String zzz) {
		System.out.println("´ßÀº "+zzz+"ÀÚ¿ä.");
	}

}
