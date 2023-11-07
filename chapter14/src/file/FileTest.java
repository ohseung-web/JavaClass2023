package file;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileTest {

	public static void main(String[] args) throws Exception{
		
		File dir = new File("D:/Temp2/images");
		File file1 = new File("D:/Temp2/file1.txt");
		File file2 = new File("D:/Temp2/file2.txt");
		File file3 = new File("D:/Temp2/file3.txt"); // File객체 생성

		if(dir.exists() == false) {	dir.mkdirs(); }
		if(file1.exists() == false) { file1.createNewFile(); }
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }// 파일또는 폴더가 존재하지 않으면 생성 폴더만들고 파일만들기

		File temp = new File("D:/Temp2");
		File[] contents = temp.listFiles(); //D:Temp2 폴더의 내용 목록을 File 배열로 받음

		System.out.println("시간\t\t\t형태\t\t크기\t이름");
		System.out.println("---------------------------------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		for(File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());// 파일 또는 폴더 정보를 출력
			}
			System.out.println(); 
		}
		
	}
}
