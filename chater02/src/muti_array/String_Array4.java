package muti_array;
import java.util.*;
public class String_Array4 {

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "ab";
		String str3 = "zyxvw";
		String str4 = "abcd";
		
		int rs1 = str1.compareTo(str2);
		System.out.println(rs1);			// 음수
		
		int rs2 = str2.compareTo(str1);
		System.out.println(rs2);			// 양수
		
		int rs3 = str1.compareTo(str3);
		System.out.println(rs3);			// 0
		
		int rs4 = str1.compareTo(str4);
		System.out.println(rs4);			// 0
		
	}

}
