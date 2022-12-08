package DI_01;

public class HelloApp {

	public static void main(String[] args) {

		MessageBean messagebean = new MessageBean();
		messagebean.sayHello("hong");

	}

}

/*
요구사항
1. 한글 버전 (hong) >> 안녕 hong!
2. 영문 버전 (hong) >> Hello hong!

MessageBean_kr >> 안녕 hong!
MessageBean_en >> Hello hong!

>> Interface로 다형성 적용 (MessageBean이라는 Interface 설계


*/
