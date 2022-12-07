// 0901

package kr.or.kosa;

import java.io.IOException;

/*
설계도 작성
설계도를 사용하는 개발자에게 어떤 상황에 대해 반드시 예외를 처리하도록 강제
생성자 혹은 함수를 만들었을 때 반드시 예외를 처리하는 코드를 생성
*/

public class ExClass {

	public ExClass(String path) throws IOException, NullPointerException {
		System.out.println(path);
	}
}
