package lambdaEx;

import java.util.Scanner;

public class Calc {

	public static MyMath calculator(String oper) {//MyMath 타입 리턴
		MyMath math = null;
		switch (oper) {
		case "+":
			math = (num1, num2) -> num1 + num2;
			break;
		case "-":
			math = (num1, num2) -> num1 - num2;
			break;
		}
		return math;
	}
	
	public static void main(String[] args) {

		String msg = "정수의 덧셈과 뺄셈에 대한 완성된 연산식을 작성하세요.";
		String exampleMsg = "예)7+35-9";
		Scanner sc = new Scanner(System.in);
		String[] nums = null;
		String[] opers = null;
		
		//익명클래스
		OperCheck operCheck = (expression) -> {
			String temp = "";

			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if (c == 43 || c == 45) { ////43: "+"   45: "-"
					temp += c;
				}
			}
			return temp.split("");
		};
		
		String temp = null;
		int num1 = 0, num2 = 0;

		System.out.println(msg);
		System.out.println(exampleMsg);
		//		      temp = "0" + sc.next();
		temp = sc.next();

		nums = temp.split("\\+|\\-");
		opers = operCheck.getOper(temp);
		num1 = Integer.parseInt(nums[0].equals("") ? opers[0] + nums[1] : nums[0]);
		for (int i = 0; i < opers.length; i++) {
			if (num1 < 0 && i == 0) {
				continue;
			}
			num2 = Integer.parseInt(nums[i + 1]);
			num1 = calculator(opers[i]).calc(num1, num2);
		}
		System.out.println(num1);



	}
}
