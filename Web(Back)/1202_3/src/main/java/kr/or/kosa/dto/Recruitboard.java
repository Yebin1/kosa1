package kr.or.kosa.dto;

import java.util.Date;

public class Recruitboard {
	private int idx;
	private Date startdate;
	private Date enddate;
	private double latitudemap;
	private double logitudemap;
	private String apply;
	private String placename;
	
	
	public Recruitboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Recruitboard(int idx, Date startdate, Date enddate, double latitudemap, double logitudemap, String apply,
			String placename) {
		super();
		this.idx = idx;
		this.startdate = startdate;
		this.enddate = enddate;
		this.latitudemap = latitudemap;
		this.logitudemap = logitudemap;
		this.apply = apply;
		this.placename = placename;
	}




	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	public double getLatitudemap() {
		return latitudemap;
	}


	public void setLatitudemap(double latitudemap) {
		this.latitudemap = latitudemap;
	}


	public double getLogitudemap() {
		return logitudemap;
	}


	public void setLogitudemap(double logitudemap) {
		this.logitudemap = logitudemap;
	}


	public String getApply() {
		return apply;
	}


	public void setApply(String apply) {
		this.apply = apply;
	}


	public String getPlacename() {
		return placename;
	}


	public void setPlacename(String placename) {
		this.placename = placename;
	}


	@Override
	public String toString() {
		return "Recruitboard [idx=" + idx + ", startdate=" + startdate + ", enddate=" + enddate + ", latitudemap="
				+ latitudemap + ", logitudemap=" + logitudemap + ", apply=" + apply + ", placename=" + placename + "]";
	}

	
}
