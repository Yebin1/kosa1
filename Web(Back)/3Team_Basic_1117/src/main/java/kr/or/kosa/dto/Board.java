package kr.or.kosa.dto;

import java.util.Date;

public class Board {

	private int idx;
	private String userId;
	private String boardName ="FREE";
	private String title;
	private String content;
	private Date writeDate;
	private int readNum;
	private int referNum;
	private int boardStatus;

	public Board() {
		super();
	}

	public Board(int idx, String userId, String boardName, String title, String content, Date writeDate, int readNum,
			int referNum, int boardStatus) {
		super();
		this.idx = idx;
		this.userId = userId;
		this.boardName = boardName;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.readNum = readNum;
		this.referNum = referNum;
		this.boardStatus = boardStatus;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

	public int getReferNum() {
		return referNum;
	}

	public void setReferNum(int referNum) {
		this.referNum = referNum;
	}

	public int getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(int boardStatus) {
		this.boardStatus = boardStatus;
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", userId=" + userId + ", boardName=" + boardName + ", title=" + title
				+ ", content=" + content + ", writeDate=" + writeDate + ", readNum=" + readNum + ", referNum="
				+ referNum + ", boardStatus=" + boardStatus + "]";
	}

}
