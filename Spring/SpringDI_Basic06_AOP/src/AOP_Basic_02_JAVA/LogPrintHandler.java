package AOP_Basic_02_JAVA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// 보조 업무 (공통 관심) 클래스
// 실제 함수를 대신해 처리할 수 있는 기능 (대리 함수): invoke
// invoke 함수는 여러 개의 다른 함수를 대리한다

public class LogPrintHandler implements InvocationHandler{

	private Object target; // 진짜 객체의 주소값을 담을 변수
	
	public LogPrintHandler(Object target) { // target 객체의 주소를 받아서
		System.out.println("logPrintHandler 생성자 호출");
		this.target = target;
	}
	
	
	// invoke 함수가 (ADD, MUL, SUB) 함수를 대리
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 보조 업무를 가지고 있음
		System.out.println("invoke 함수 호출");
		System.out.println("method 함수명: " + method);
		System.out.println("method parameter 값: " + Arrays.toString(args));
		
		// 결국 invoke가 보조 기능 (공통 관심)을 가지고 있으면 된다
		// 보조 기능 (공통 관심)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		// 주업무(실 객체의 함수 호출): 주객체의 주함수를 호출 (ADD, MUL, SUB)
		// Object 타입 다운캐스팅
		int result = (int)method.invoke(this.target, args);
		
		// 보조 기능 (공통 관심)
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Tmie Log Method: MUL]");
		log.info("[Tmie Log Method: " + sw.getTotalTimeMillis() + "]");
		
		return result;
	}

}
