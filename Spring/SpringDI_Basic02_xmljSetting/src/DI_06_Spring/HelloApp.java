package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {

		/*
		// java 구현
		OracleArticleDao articledao = new OracleArticleDao();
		// MysqlArticleDao articledao = new MysqlArticleDao();
		ArticleService articleservice = new ArticleService(articledao);

		Article article = new Article();
		articleservice.write(article);
		
		// ArticleService 생성자 호출
		// Oracle insert 구문 실행
		*/
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
		ArticleService articleservice = context.getBean("articleservice", ArticleService.class);
		Article article = context.getBean("article", Article.class);
		
		articleservice.write(article);

	}

}
