package AOP_Basic_02_JAVA;

import java.lang.reflect.Proxy;

public class Program {
	
	public static void main(String[] args) {
		
		// 1. 실객체의 주소
		Calc calc = new NewCalc();
		
		// 2. 가짜 생성
		Calc cal = (Calc)Proxy.newProxyInstance(
				calc.getClass().getClassLoader(), // cacl >> 실제 객체의 메타 정보 (내부 정보)
				calc.getClass().getInterfaces(),  // 행위 정보 (Interface)
				new LogPrintHandler(calc)); // 보조 객체 (공통 관심 객체) 정보
		
		// 사용자가 사용
		// ADD를 사용하는 순간 프록시로 가서 보조 업무 실행
		int result = cal.ADD(555, 555);
		System.out.println("result: " +  result);
	}

}
