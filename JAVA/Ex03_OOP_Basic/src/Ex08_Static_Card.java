// 0826

import kr.or.kosa.Card;

public class Ex08_Static_Card {

	public static void main(String[] args) {

		// ī�� 53�� �����
		// Heap �޸�
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
		
		// ���赵 ����X
		// �� ���� ī�� ũ�⸦ ���� > ��� ī�忡 ����
		
		Card c1 = new Card();
		c1.makeCard(1, "heart");
		c1.h = 40;	// static (class area�� ����� ���� ����)
		c1.w = 10;	// c2, c3�� ���� class area�� ����Ű�Ƿ� �ѹ��� ���� ����ȴ�
		c1.cardDisplay();
		
		Card c2 = new Card();
		c2.makeCard(2, "heart");
		c2.cardDisplay();
		
		Card c3 = new Card();
		c3.makeCard(3, "heart");
		c3.cardDisplay();
				
		
	}

}
