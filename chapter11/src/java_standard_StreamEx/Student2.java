package java_standard_StreamEx;

public class Student2 {
   String name;//이름
   boolean isMale; //성별
   int hak; //학년
   int ban; //반
   int score;
   
   public Student2(String name, boolean ismale, int hak, int ban, int score) {
	   this.name = name;
	   this.isMale = ismale;
	   this.hak = hak;
	   this.ban = ban;
	   this.score = score;
   }

public String getName() {return name;}
public void setName(String name) {this.name = name;}
public boolean isMale() {return isMale;}
public void setMale(boolean isMale) {this.isMale = isMale;}
public int getHak() {return hak;}
public void setHak(int hak) {this.hak = hak;}
public int getBan() {return ban;}
public void setBan(int ban) {this.ban = ban;}
public int getScore() {return score;}
public void setScore(int score) {this.score = score;}

@Override
public String toString() {
	return String.format("[%s, %s, %d학년 %d반,%3d점]",
			              name, isMale ? "남":"여",hak,ban,score);
}

//groupingBy()에서 사용
 enum Level {
	HIGH, MID, LOW //성적을 상,중,하 세단계로 분류
}


}
