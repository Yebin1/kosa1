package kr.or.kosa;

/*
Tv 설계도 요구사항 정의
Tv는 채널 정보를 가지고 있다 (1~200)				// public
Tv는 브랜드 이름을 가지고 있다 (엘지, 삼성)			// public
Tv는 채널 전환 기능을 가지고 있다 (한 채널씩 이동 가능)
>> 채널을 증가시키는 기능
>> 채널을 감소시키는 기능
Tv는 채널 정보, 브랜드 이름 출력 기능을 가지고 있다

*/


public class Tv {
	
	public int channel;	// default: 0
	public String name;	// default: null

	
	public void ch_Up() {
		channel++;
	}
	public void ch_Down() {
		channel--;
	}
	public void info_Tv() {
		System.out.printf("%s, %d \n", name, channel);
	}
	
	

}
