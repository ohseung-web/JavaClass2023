package java_standard_StreamEx;

public class Student2 {
   String name;//�̸�
   boolean isMale; //����
   int hak; //�г�
   int ban; //��
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
	return String.format("[%s, %s, %d�г� %d��,%3d��]",
			              name, isMale ? "��":"��",hak,ban,score);
}

//groupingBy()���� ���
 enum Level {
	HIGH, MID, LOW //������ ��,��,�� ���ܰ�� �з�
}


}
