package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	
	public static void main(String[] args) {
		
		/*
		// 영문
		MessageBean_en messagebean_en = new MessageBean_en();
		messagebean_en.sayHello("hong");
		
		// 한글
		MessageBean_kr messagebean_kr = new MessageBean_kr();
		messagebean_kr.sayHello("hong");
		
		
		// MessageBean messagebean = new MessageBean_en();
		// messagebean.sayHello("hong");
		
		MessageBean messagebean = new MessageBean_kr();
		messagebean.sayHello("hong");
		
		// Interface >> 다형성 >> 바꿔끼우는 방식으로 활용
		*/
		
		/*
		Spring 통해 객체 생성하고 조립하는 작업
		1. 컨테이너 생성 (메모리)
		2. 컨테이너 안에서 생성될 객체 만들고 주입하는 작업 (xml) >> DI_03.xml
		*/
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		// "classpath:DI_03_Spring/DI_03.xml" >> 약속된 경로
		MessageBean message = context.getBean("messagebean", MessageBean.class);
		message.sayHello("hong");
		
		
	}

}
