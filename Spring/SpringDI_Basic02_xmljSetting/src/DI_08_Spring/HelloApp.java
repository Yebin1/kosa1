package DI_08_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import DI_07_Spring.ProtocolHandler;

public class HelloApp {

	public static void main(String[] args) {
		
		/*
		// 알아서 타입에 맞는 생성자 호출
		JobExecute jobexecute = new JobExecute("hong", 100); // String, int
		JobExecute jobexecute2 = new JobExecute("lim", 1000L); // String, long
		JobExecute jobexecute3 = new JobExecute("lim", "hong"); // String, String
		
		ArticleDao articledao = new ArticleDao();
		jobexecute.setArticledao(articledao); // setArticledao: DI_08_Spring.ArticleDao@3cda1055
		jobexecute.setData(500); // setData: 500
		*/
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_08_Spring/DI_08.xml");
		/*
		String, long
		setArticledao: DI_08_Spring.ArticleDao@55b53d44
		setData: 500
		*/
		
	}

}
