package decorater;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		// ���۸� ����� �����ϴ� ��Ʈ��
		// a.exe ������ b.exe ���Ϸ� 1byte�� ����
		// System.currentTimeMillis() : 1970��1��1�Ϻ��� ����� �ð��� long ������ �����ϸ�
		//                              �и����� 1/1000�� ���� �����Ѵ�.
		long millisconds = 0; // ���� �ð�üũ
		int len = 0; // ����Ʈ üũ
		try(FileInputStream fis = new FileInputStream("KScreenPen.exe"); 
			FileOutputStream fos = new FileOutputStream("scopy.exe");
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
		
			millisconds = System.currentTimeMillis();
			int i= 0;
			while((i=bis.read()) != -1) { // end of ������ retrun ���� -1 �̴�.
				bos.write(i);
				len++;
			}
					
			millisconds = (System.currentTimeMillis() - millisconds)/1000;
		}catch(IOException e) {
			System.out.println(e);
		}
         System.out.println("����Ʈ :"+len);
         System.out.println("���� ����ð� :"+millisconds+"��");
	}

}
