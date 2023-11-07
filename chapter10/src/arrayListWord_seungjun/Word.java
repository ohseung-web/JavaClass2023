package arrayListWord_seungjun;

public class Word {
	private String engWord; //���� �ܾ�
	private String korWord; //�ѱ� �ܾ�
	
	public Word() {}
	public Word(String engWord, String korWord) {
		this.engWord = engWord;
		this.korWord = korWord;
	}
	
	public String getEngWord() {
		return engWord;
	}
	public void setEngWord(String engWord) {
		this.engWord = engWord;
	}
	public String getKorWord() {
		return korWord;
	}
	public void setKorWord(String korWord) {
		this.korWord = korWord;
	}
	
	@Override
	public int hashCode() {
		return (this.engWord+this.korWord).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Word) {
			Word word = (Word)obj; // �ٿ�ĳ����
			if(this.engWord.equals(word.engWord) && this.korWord.equals(word.korWord)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}	
	}
}
