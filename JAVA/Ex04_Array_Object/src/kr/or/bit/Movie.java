package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

public class Movie {
	
	Scanner scan = new Scanner(System.in);
	
	private String[][] movieArr1;
	private String[][] movieArr2;
	
	public Movie() {	// 생성자
		movieArr1 = new String[4][5];
		movieArr2 = new String[5][5];
		
		for (int i = 0; i < movieArr1.length; i++) {
			for (int j = 0; j < movieArr1[i].length; j++) {
				movieArr1[i][j] = "__";	// arr1 문자열로 초기화
			}
		}
		
		for (int i = 0; i < movieArr2.length; i++) {
			for (int j = 0; j < movieArr2[i].length; j++) {
				movieArr2[i][j] = "__";	// arr2 문자열로 초기화
			}
		}
		
	}
	
	private int row, col;		// 입력 받은 좌석 위치
	private int cinema;
	
	public void mySeat() {
		row = 0;
		col = 0;
	}
		
	
	
 	private void printSeat(String[][] movieArr) {	// 좌석 현황 출력
		for (int i = 0; i < movieArr.length; i++) {
			for (int j = 0; j < movieArr[i].length; j++) {
				System.out.printf("[%s]", movieArr[i][j].equals("__") ? "좌석" : "예매");
			}
			System.out.println();
		}
	}
	
	public void print() {
	
		System.out.println();
		System.out.println("----------------------");
		System.out.println("-----영화 예매 시스템-----");
		System.out.println("----------------------");
		movieMenu3();
		}
	
	private void movieMenu() {	// 예매, 조회, 취소
		System.out.println("\n1. 예매하기\n2. 예매 조회\n3. 예매 취소\n4. 종료\n");
		System.out.println("원하는 번호를 선택해주세요.");
		
	}
	
	private void movieMenu2() {	// 무슨 영화일지 고르는 기능
		System.out.println("\n예매할 영화를 선택해주세요.");
		System.out.println("1. 한산\n2. 탑건");
		
		cinema = Integer.parseInt(scan.nextLine());
		switch (cinema) {
		case 1: // 한산
			printSeat(movieArr1);
			ticketCheck(movieArr1);
			printCheck();
		
		case 2: // 탑건
			printSeat(movieArr2);
			ticketCheck(movieArr2);
			printCheck();
		default:
			System.out.println("다시 입력해주세요.");
	
		}
		
	}
		
	
	private void movieMenu3() {
		
		movieMenu();
		
		while (true) {
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case 1: // 예매하기
				movieMenu2();
				break;
			case 2: // 예매 조회
				viewmySeat();
				

			case 3: // 예매 취소
				System.out.println("예매를 취소합니다.");
				movieMenu2();
				break;
			case 4: // 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	
	private void printCheck() { // 예매 가능한 경우
		
		System.out.println("\n1. 예매\n2. 예매 취소\n3. 초기 화면으로 돌아가기\n");
		System.out.println("번호를 선택해주세요.");
		
		while (true) {
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case 1: // 네
				ticketing(); // 예매 여부를 배열에 넣는 기능
				System.out.println("예매가 완료되었습니다.");
				myMovienumber();
				// System.out.printf("예매한 좌석 번호: [%s],/t 예매 번호: [%d]", 좌석번호, 예매번호);
				movieMenu3();
				break;
			case 2: // 아니오
				System.out.println("예매를 취소합니다.");
				movieMenu3();
				break;
			case 3: movieMenu(); // 초기 화면으로 돌아가기
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	
	
	private void possibleSeat(int seat, int seat2) {
		seat = Integer.parseInt(scan.nextLine());
		seat2 = Integer.parseInt(scan.nextLine());
		row = seat;
		col = seat2;
	}
	
	private void ticketCheck(String arr[][]) {	// 예매 가능 여부만 확인
		
		System.out.println("예매할 좌석을 입력해주세요.");
		possibleSeat(row, col);
		
		if (arr[row][col].equals("__")) {
			System.out.println("예약 가능한 좌석입니다.");
		} else {System.out.println("이미 예약 완료된 좌석입니다.");}
	}
	
	
	private void ticketing() {	// 예매 여부를 배열에 넣는 기능
		
		if (cinema == 1 && movieArr1[row][col].equals("예매")) {
			System.out.println("이미 예매된 좌석입니다.");
			
		} else if (cinema == 1 && movieArr1[row][col].equals("__"))
		{
			movieArr1[row][col] = "예매";
		}
		
		if (cinema == 2 && movieArr2[row][col].equals("예매")) {
			System.out.println("이미 예매된 좌석입니다.");
			
		} else if (cinema == 2 && movieArr2[row][col].equals("__"))
		{
			movieArr2[row][col] = "예매";
		}
				
	}
	
	
	/////////////////////////////////////////////////////////////////////
	
	// 예매번호
	
	Random random = new Random();
	
	public int[] myNumber = new int[4];
	
	private void myMovienumber() {
		for (int i = 0; i < myNumber.length; i++) {
			myNumber[i] = random.nextInt(10);
		}
		for (int i = 0; i < myNumber.length; i++) {
			System.out.printf("%d", myNumber[i]);
		}
		
	}
	

	//예매 조회 기능
	private void viewmySeat() {
		System.out.println("예매 번호를 입력해주세요.");
		int num11 = Integer.parseInt(scan.nextLine());
		/*
		for (int i = 3; i >= 0; i--) {
			int temp = num11 % 10;
			if (temp == myNumber[i]) {
				temp = num11 / 10;
			} else if (temp != myNumber[i]) { 
				System.out.println("예매 번호를 다시 확인해주세요."); 
				break;
			}
		}*/
		
		
		if (cinema == 1) { printSeat(movieArr1); }
		if (cinema == 2) { printSeat(movieArr2); }
		movieMenu3();
	}
	
	
	

}
