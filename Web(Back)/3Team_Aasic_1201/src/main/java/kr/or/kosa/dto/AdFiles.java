package kr.or.kosa.dto;

public class AdFiles {
	private int adfilenum;
	private String adfilename;
	private int adfilesize;

//	public AdFiles() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	public AdFiles() {}

	public AdFiles(int adfilenum, String adfilename, int adfilesize) {
		super();
		this.adfilenum = adfilenum;
		this.adfilename = adfilename;
		this.adfilesize = adfilesize;
	}

	public int getAdfilenum() {
		return adfilenum;
	}

	public void setAdfilenum(int adfilenum) {
		this.adfilenum = adfilenum;
	}

	public String getAdfilename() {
		return adfilename;
	}

	public void setAdfilename(String adfilename) {
		this.adfilename = adfilename;
	}

	public int getAdfilesize() {
		return adfilesize;
	}

	public void setAdfilesize(int adfilesize) {
		this.adfilesize = adfilesize;
	}

	@Override
	public String toString() {
		return "AdFiles [adfilenum=" + adfilenum + ", adfilename=" + adfilename + ", adfilesize=" + adfilesize + "]";
	}
	
	
}