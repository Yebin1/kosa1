package kr.or.kosa;

public class Rectangle {
	
	private String rname;
	private int width, height;

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void r_data(String name, int w, int h) {
		width = w;
		height = h;
		rname = name;
		recDisplay();
	}
	
	public void recDisplay() {
		System.out.printf("¿Ã∏ß: %s, w: %d, h: %d, ≥–¿Ã: %d", rname, width, height, (width*height));
	}
	
}
