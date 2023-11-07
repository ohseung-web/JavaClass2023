package java_standard_StreamEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
  
		// StudentŬ������ stream���� ����
		/*
		Stream<Student> studentStream = Stream.of(
				new Student("���ڹ�",3,300),
				new Student("���ڹ�",1,200),
				new Student("���ڹ�",2,100),
		    	new Student("���ڹ�",2,150),
				new Student("���ڹ�",1,200),
				new Student("���ڹ�",3,290),
				new Student("���ڹ�",3,100)
				);
	    */
        List<Student> studentStream = Arrays.asList(
        		new Student("���ڹ�",3,300),
				new Student("���ڹ�",1,200),
				new Student("���ڹ�",2,100),
				new Student("���ڹ�",2,150),
				new Student("���ڹ�",1,200),
				new Student("���ڹ�",3,290),
				new Student("���ڹ�",3,100)
				);
        		      
		
//		studentStream.sorted(Comparator.comparing((Student s)->s.getBan())//�ݺ��� ����
//				     .thenComparing(Comparator.naturalOrder())) // �⺻����
//				     .forEach(i->System.out.println(i));
	
       
        List<Student> stStream = studentStream.stream()
        		     .sorted(Comparator.comparing((Student s)->s.getBan()).reversed()//�ݺ��� ��������
				     .thenComparing((Student s)->s.getName()) // ���� ������ �̸����� ����
				     .thenComparing((Student s)->s.getTotalScore())) // �������� ����
        		     .collect(Collectors.toList());
        //System.out.println(stStream);
        
        Object[] obj = stStream.toArray();
        for(Object student : obj) {
        	System.out.println(student.toString());
        }
		
        // 3�г��� ��� ����
        List<Student> stStream2 = studentStream.stream()
        		       .filter((Student s)->s.getBan()==3)
        		       .collect(Collectors.toList());
        System.out.println(stStream2);
		
        
        // ������ 200�̻��� ������ ��� ����
        List<Student> stStream3 = studentStream.stream()
        		      .filter((Student s)->s.getTotalScore()>=200)
        		      .collect(Collectors.toList());
        
        Object[] obj2 = stStream3.toArray();        
        for(Object score : obj2) {
        	System.out.println(score);
        }
        
    
//		studentStream.sorted(Comparator.comparing((Student s)->s.getBan()).reversed()//�ݺ��� ��������
//				     .thenComparing((Student s)->s.getName()) // ���� ������ �̸����� ����
//				     .thenComparing((Student s)->s.getTotalScore())) // �������� ����
//				     .forEach(i->System.out.println(i));
				     
		        
		        
		         
		         
		
		
	}

	

}
