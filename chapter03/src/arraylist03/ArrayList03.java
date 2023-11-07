package arraylist03;
import java.util.*;
public class ArrayList03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 스캐너 불러오기
        ArrayList<String> names = new ArrayList<>(); // ArrayList 생성
        int cnt = 0; // 몇 명인지 숫자 세기

        for(int i = 0 ; i <= 4 ; i++) { // 스캐너로 이름 5개 입력 받기
            System.out.println("이름을 입력해 주세요");
            names.add(scan.nextLine());
        }

        System.out.println("성이 '김'인 분의 이름을 모두 출력합니다.");

        for(int i = 0 ; i <= 4 ; i++) {
            String name = names.get(i); // 배열의 값(이름)을 변수에 저장
            if (name.startsWith("김")) { // 만약 "김"으로 시작한다면, 
            	cnt++; // 인덱스는 +1
                System.out.printf("[%s]\t",names.get(i)); // 이름이 출력됨
            }
        }
        System.out.println();
        System.out.println("김씨 성을 가진 분은 모두 " + cnt + " 명 입니다.");
      	// 몇 명인지도 인덱스를 통해 출력됨
        
        scan.close();
	}

}
