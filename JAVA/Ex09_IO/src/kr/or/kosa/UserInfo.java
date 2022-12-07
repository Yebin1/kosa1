// 0916

package kr.or.kosa;

import java.io.Serializable;

/*
객체 통신
객체 (Car, Tv, Tank) 네트워크, 파일 간(txt 파일 객체 write, 객체 read)
프로세스 간에 통신

직렬화: 객체를 분해, 줄을 세워 보내는 일련의 과정
역직렬화: 객체를 다시 조립하는 과정

실습) 파일
객체 write(파일): 직렬화
객체 read(파일): 역직렬화

모든 자원 (class) 직렬화 > 불가능
직렬화 가능 제품을 만들어 사용 ...
implements Serializable (레고 블럭처럼)

*/

public class UserInfo implements Serializable {	// 직렬화 가능

	private String name;
	private String pwd;
	private int age;
	
	public UserInfo() {}

	public UserInfo(String name, String pwd, int age) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
	}
}
