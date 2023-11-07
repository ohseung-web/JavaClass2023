package muti_array;
import java.util.*;
public class Muti_Array8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] arr ={
				{101, 102, 103, 104},
				{201, 202, 203, 204},
				{301, 302, 303, 304}
			}; 

		int[] garo = new int[3];
		int[] sero = new int[4];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				garo[i] += arr[i][j];
				sero[j] += arr[i][j];
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println("가로의 합:"+garo[i]);
		}
		System.out.println();
		for(int i=0;i<arr[0].length;i++) {
			System.out.println("세로의 합:"+sero[i]);
		}
		
		scan.close();
	}

}
