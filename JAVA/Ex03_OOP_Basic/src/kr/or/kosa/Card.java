// 0826

package kr.or.kosa;

/*
우리는 카드를 만들어 판매하는 회사입니다
고객의 요청에 따라 카드 53장을 제작하게 되었습니다

요구 사항
1. 카드는 카드의 번호와 모양을 가지고 있다
2. 카드는 크기를 가지고 있으며, 크기는 높이와 넓이를 가지고 있다
3. 카드의 크기는 h = 50, w = 20

---------------------------------------------------

고객: 카드가 너무 커 다시 만들어 주세요

설계도를 변경하지 않고 53장 카드의 높이와 너비를 변경할 수 있도록


*/


public class Card {
	
	private int number;
	private String kind;
	
	public static int h = 50;
	public static int w = 20;
	
	public void makeCard(int num, String name) {
		number = num;
		kind = name;
	}
	
	public void cardDisplay() {
		System.out.printf("번호: %d, 카드 모양: %s, 높이: %d, 너비: %d\n", number, kind, h, w);
	}
		
		

}
