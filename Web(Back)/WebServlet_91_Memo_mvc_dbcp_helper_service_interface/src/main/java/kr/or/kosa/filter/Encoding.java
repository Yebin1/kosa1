package kr.or.kosa.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

@WebFilter(

		description = "Annotation 활용하여 Filter 적용하기",
		urlPatterns = { "/*" },
		initParams = {@WebInitParam(name = "encoding", value = "UTF-8") }

)
public class Encoding extends HttpFilter implements Filter {

	// member field
	private String encoding;

	public Encoding() {
		super();
	}

	public void destroy() {
	}

	// 함수를 통해 요청, 응답시 필터링을 제어
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// request 요청에 대한 필터 실행 코드 영역
		if (request.getCharacterEncoding() == null) {
			System.out.println("before: " + request.getCharacterEncoding());
			// 한 줄 코드 (공통 관심, 보조 관심 AOP)
			request.setCharacterEncoding(this.encoding);
			System.out.println("after: " + request.getCharacterEncoding());
		}

		chain.doFilter(request, response);

		// response 응답에 대한 필터 실행 코드 영역
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 최초 요청시 컴파일되고 한 번만 실행
		// web.xml 설정되어 있는 초기값을 read 해서 사용 >> FilterConfig 통해서 사용
		// web.xml에 설정된 param-name을 주면 encoding에 설정된 utf-8 읽어옴
		this.encoding = fConfig.getInitParameter("encoding");
		System.out.println("Filter init 함수 실행: " + this.encoding);
	}

}
