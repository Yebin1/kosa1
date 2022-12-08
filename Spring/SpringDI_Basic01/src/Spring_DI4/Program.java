package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {

		/*
		// NewRecordView view = new NewRecordView(100, 50, 40);
		// view.print();

		NewRecordView view = new NewRecordView();
		// NewRecord 객체가 필요해지면
		NewRecord record = new NewRecord();
		view.setRecord(record); // 의존 객체 주입 (setter 함수)
		
		view.input();
		view.print();
		*/
		
		  /*
	       (스프링은 자신만의 메모리 공간이 필요)
	       1. SpringFramework 가 제공하는 컨테이너에 객체 생성 (메모리 생성 :  IOC(제어의 역전)) 컨테이너)
	       >>ApplicationContext context = new ClassPathXmlApplicationContext
	       2. 컨테이너를 만들고 그 메모리에 필요한 객체를 생성하고 조립(주입) ... 자동 소멸
	             컨테이너가 생성되고 DIConfig.xml read 하고 컴파일 해요 ....
	          DIConfig.xml 컴파일하면 bean 객체를 생성하고 필요한 객체를 주입받고 .... 작업이 끝남.
	       */

		
		// spring이 사용할 수 있는 메모리 공간 만든 후
		// 생성된 메모리에 DIConfig.xml을 read하여 객체 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		
		// 타입이 Object >> 다운캐스팅
		//getBean 메모리에 있는 필요한 객체를 끄집어낸다.
	    //컨테이너 안에 필요한 객체가 생성되어있고
		RecordView view = (RecordView) context.getBean("view");
		
		view.input();
		view.print();
		
		// Caused by: java.lang.ClassNotFountException: org.apache.commons.logging.LogFactory
		// C:\Spring\Framework\spring-framework-3.0.2.RELEASE-dependencies\org.apache.commons\com.springsource.org.apache.commons.logging\1.1.1
		// com.springsource.org.apache.commons.logging-1.1.1 >> java build path에 add external jars 추가하기

	}

}
