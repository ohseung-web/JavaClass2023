package arrylist04;
import java.util.*;
public class ArrayList04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 스캐너
		ArrayList<String > nicknames = new ArrayList<>(); // ArrayList 생성
		int[] lengthArr = new int[5]; // 별명 문자열 길이를 저장할 배열
		int max = lengthArr[0]; // 최대값을 저장할 인스턴스

		for (int i = 0 ; i <= 4 ; i++) { // 5개의 별명을 입력 받는다
			System.out.println("별명을 입력 해 주세요!");
			nicknames.add(sc.nextLine());
		}

		for (int i = 0 ; i <= 4 ; i++) {
			// ArrayList에 저장된 각 별명들의 길이를 lengthArr에 저장한다
			lengthArr[i] = nicknames.get(i).length();
			if (max < lengthArr[i]) { // 최대값을 찾아 max에 저장한다
				max = lengthArr[i];
			}
		}

		for (int i = 0 ; i <= 4 ; i++) { // i번째 배열의 길이가 max와 같다면 출력한다
			if (max == nicknames.get(i).length()) {
				System.out.println("가장 길이가 긴 별명은 > " + nicknames.get(i));
			}
		}
		
		sc.close();
	}

}
