package gameLevel;

public  abstract class PlayerLevel {

	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void ShowLevelMassge();
	
	//템플릿 메서드(=시나리오) 작성
	final public void go(int count) {
		run();
		for(int i=0; i<count; i++) {
			jump();
		}
		turn();
	}
	
}
