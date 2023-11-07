package leejunhun;
import java.util.*;
public class QnaManager {
	Scanner scn = new Scanner(System.in);
	private ArrayList<Qna> qnaList = new ArrayList<>();


	private int qnaAmount = 0;
	public QnaManager() {}
	
	// QNA 추가
	// 읽고, 답하고 삭제는 없다.
	// (int serialId, String usrId, String title, String contents)
	
	// QNA 추가
	public int addQna(User currentUser) {
		int serialId = qnaAmount++;
		System.out.print("title :");
		String title = scn.next();
		String usrId = currentUser.getId();
		System.out.print("문의사항을 입력하세요 (띄어쓰기금지, 엔터입력시 입력종료) : ");
		String contents = scn.next();
		
		qnaList.add(new Qna(serialId, usrId, title, contents));
		
		return 1;
	}
	
	public ArrayList<Qna> getQna(User currentUser) {
		ArrayList<Qna> list = new ArrayList<>();
		
		if(currentUser == null)	{
			System.out.println("로그인 후 이용해주세요");
			
			return list;
		}else if (currentUser.getClass().equals(Administrator.class)) {
			System.out.print("[1]. 전체보기 [2]. 미답변 질문보기 : ");
			int select = scn.nextInt();
			
			if(select == 1)	{
				list = qnaList;
			}else if(select == 2) {
				for(int i=0; i<qnaList.size(); i++)	{
					if(qnaList.get(i).getReplyId()==null) {
						list.add(qnaList.get(i));
					}
				}
			}
			
		}else if(currentUser.getClass().equals(User.class)) {
			for(int i=0; i<qnaList.size(); i++) {
				if(qnaList.get(i).getUsrId().equals(currentUser.getId())) {
					list.add(qnaList.get(i));
				}
			}
		}
		
		return list;
	}
	public void AnswerQna(Qna targetQna) {
		
	}
	public ArrayList<Qna> getQnaList() {
		return qnaList;
	}
}
