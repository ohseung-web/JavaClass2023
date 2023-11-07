package file;

import java.io.File;

public class FileEx {

	public static void listDirectory(File dir) {
		// getPath() : 전체경로 리턴
		System.out.println("-----"+ dir.getPath()+"서브 리스트 입니다.");
		
		File[] subFiles = dir.listFiles();//디렉토리에 포함된 파일과 디렉토리 이름의 리스트 얻기
		
		for(int i=0; i<subFiles.length; i++) { // subFiles 배열의 각 File에 대해 루프
			File f = subFiles[i];
			long t = f.lastModified(); //마지막으로 수정된 시간
			System.out.print(f.getName());
			System.out.print("\t파일 크기 :"+f.length()); //파일크기
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t,t,t,t); //포맷출력
		}
	}
	
	public static void main(String[] args) {
       
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath()+","+f1.getParent()+","+f1.getName());
		
		String res ="";
	
		
	}

}
