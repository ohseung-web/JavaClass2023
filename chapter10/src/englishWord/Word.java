package englishWord;

public class Word {
      
	private String english;
	private String korea;
	
    public Word() {}
	public Word(String english, String korea) {
		this.english = english;
		this.korea = korea;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKorea() {
		return korea;
	}
	public void setKorea(String korea) {
		this.korea = korea;
	}

	
	
}
