package java_standard_StreamEx;

public class Student implements Comparable<Student> {
   String name;
   int ban;
   int totalScore;
   
   public Student(String name, int ban, int totalScore) {
	   this.name = name;
	   this.ban = ban;
	   this.totalScore = totalScore;
   }

public String getName() {return name;}
public void setName(String name) {this.name = name;}
public int getBan() {return ban;}

public void setBan(int ban) {this.ban = ban;}
public int getTotalScore() {return totalScore;}
public void setTotalScore(int totalScore) {this.totalScore = totalScore;}

@Override
public String toString() {
	return String.format("[%s, %d, %d]", name,ban,totalScore);
}

@Override
public int compareTo(Student s) {
	return  this.totalScore-s.totalScore; //오름차순
}




}
