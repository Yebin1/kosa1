// 0826

import kr.or.kosa.Card;

public class Ex08_Static_Card {

	public static void main(String[] args) {

		// 카드 53장 만들기
		// Heap 메모리
		/*
		Card c1 = new Card();
		c1.makeCard(1, "heart");
		c1.cardDisplay();
		
		Card c2 = new Card();
		c2.makeCard(2, "heart");
		c2.cardDisplay();
		
		Card c3 = new Card();
		c3.makeCard(3, "heart");
		c3.cardDisplay();
		*/
		
		// 설계도 변경X
		// 한 장의 카드 크기를 변경 > 모든 카드에 영향
		
		Card c1 = new Card();
		c1.makeCard(1, "heart");
		c1.h = 40;	// static (class area에 저장된 값을 변경)
		c1.w = 10;	// c2, c3도 같은 class area를 가리키므로 한번에 값이 변경된다
		c1.cardDisplay();
		
		Card c2 = new Card();
		c2.makeCard(2, "heart");
		c2.cardDisplay();
		
		Card c3 = new Card();
		c3.makeCard(3, "heart");
		c3.cardDisplay();
				
		
	}

}
