package gameLevel;

public class Player  {

	private PlayerLevel level;

	//»ý¼ºÀÚ
	public Player() {
		level = new BeginnerLevel();
		level.ShowLevelMassge();
		
	}
	
	public PlayerLevel getLevel() {
		return level;
	}

	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.ShowLevelMassge();
	}

	public void play(int count) {
		level.go(count);
	}
	
	
	
}
