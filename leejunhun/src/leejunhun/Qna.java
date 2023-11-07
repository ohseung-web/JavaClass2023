package leejunhun;

import java.util.*;

public class Qna {	
	private int serialId;
	private String usrId;
	private String title;
	private String contents;
	private String answer;


	private Date date;
	private String replyId;
	
	public Qna(int serialId, String usrId, String title, String contents) {
		this.serialId = serialId;
		this.usrId = usrId;
		this.title = title;
		this.contents = contents;
		this.answer = null;
		this.date = new Date();
		this.replyId = null;
	}


	public int getSerialId() {
		return serialId;
	}


	public String getReplyId() {
		return replyId;
	}


	public String getUsrId() {
		return usrId;
	}


	public String getTitle() {
		return title;
	}


	public String getContents() {
		return contents;
	}


	public String getAnswer() {
		return answer;
	}


	public Date getDate() {
		return date;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

}
