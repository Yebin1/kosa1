package DI_06_Spring;

public class MysqlArticleDao implements ArticleDao {

	@Override
	public void insert(Article article) {

		System.out.println("MySql insert 구문 실행");

	}

}