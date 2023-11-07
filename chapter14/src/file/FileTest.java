package file;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileTest {

	public static void main(String[] args) throws Exception{
		
		File dir = new File("D:/Temp2/images");
		File file1 = new File("D:/Temp2/file1.txt");
		File file2 = new File("D:/Temp2/file2.txt");
		File file3 = new File("D:/Temp2/file3.txt"); // File��ü ����

		if(dir.exists() == false) {	dir.mkdirs(); }
		if(file1.exists() == false) { file1.createNewFile(); }
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }// ���϶Ǵ� ������ �������� ������ ���� ��������� ���ϸ����

		File temp = new File("D:/Temp2");
		File[] contents = temp.listFiles(); //D:Temp2 ������ ���� ����� File �迭�� ����

		System.out.println("�ð�\t\t\t����\t\tũ��\t�̸�");
		System.out.println("---------------------------------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		for(File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());// ���� �Ǵ� ���� ������ ���
			}
			System.out.println(); 
		}
		
	}
}
