package omokgame;

public   class Best {
	
	int log = -1;

	int []ranking = new int [30];
	int []score = new int [30];
	private String ID;
	private String PW;
	private String NAME;
	
	public String getNAME() {
		return NAME;
	}
	public Best() {};
	public Best(String NAME,String ID,String PW) {
		this.ID=ID;
		this.PW = PW;
		this.NAME = NAME;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getPW() {
		return PW;
	}

	
	

	
}