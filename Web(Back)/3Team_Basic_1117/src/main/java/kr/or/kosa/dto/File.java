package kr.or.kosa.dto;

public class File {

	private int fileNum;
	private int idx;
	private String fileName;
	private int fileSize;

	public File() {
		super();
	}

	public File(int fileNum, int idx, String fileName, int fileSize) {
		super();
		this.fileNum = fileNum;
		this.idx = idx;
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "File [fileNum=" + fileNum + ", idx=" + idx + ", fileName=" + fileName + ", fileSize=" + fileSize + "]";
	}

}
