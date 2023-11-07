package leejunhun;
import java.util.*;
public class QnaManager {
	Scanner scn = new Scanner(System.in);
	private ArrayList<Qna> qnaList = new ArrayList<>();


	private int qnaAmount = 0;
	public QnaManager() {}
	
	// QNA �߰�
	// �а�, ���ϰ� ������ ����.
	// (int serialId, String usrId, String title, String contents)
	
	// QNA �߰�
	public int addQna(User currentUser) {
		int serialId = qnaAmount++;
		System.out.print("title :");
		String title = scn.next();
		String usrId = currentUser.getId();
		System.out.print("���ǻ����� �Է��ϼ��� (�������, �����Է½� �Է�����) : ");
		String contents = scn.next();
		
		qnaList.add(new Qna(serialId, usrId, title, contents));
		
		return 1;
	}
	
	public ArrayList<Qna> getQna(User currentUser) {
		ArrayList<Qna> list = new ArrayList<>();
		
		if(currentUser == null)	{
			System.out.println("�α��� �� �̿����ּ���");
			
			return list;
		}else if (currentUser.getClass().equals(Administrator.class)) {
			System.out.print("[1]. ��ü���� [2]. �̴亯 �������� : ");
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
