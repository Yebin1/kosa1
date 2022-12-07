package kr.or.kosa;

public class Bank_test {
	
	public String B_name;	        // 모임 통장 소유주
	public static int B_bank;   	// 모임 통장
	public static boolean B_autho;	// 권한

    public static int my_bank;      // 내 통장
	
	public String auth_P;
	
	public void accountData(String name, int bank, boolean autho) {
		B_name = name;
		B_bank = bank;
		B_autho = autho;
	}
	
	public void BankPrint() {
		if (B_autho == true) {
			auth_P = "O";
		} else {auth_P = "X";}
		System.out.printf("소유주: %s, 모임 통장 잔고: %d, 권한: %s\n", B_name, B_bank, auth_P);
	}

    public void my_Data(int bank_my) {
		bank_my = my_bank;
	}

    public void my_Print() {
		if (B_autho == true) {
			auth_P = "O";
		} else {auth_P = "X";}
		System.out.printf("내 통장 잔고: %d, 모임 통장 권한: %s\n", my_bank, auth_P);
	}

public int money;

//////////////////////////////////////////////

public void dep_1(int money) { // 모임 통장 입금
		B_bank += money;
} 

public void witt_1(int money) { // 모임 통장 출금
	if (B_autho == true)		
	{if (B_bank<money) {System.out.printf("잔고가 부족합니다.\n");}
    else if (B_bank >= money) {B_bank -= money;}}
else { System.out.printf("출금 권한이 없습니다.\n");}
}

public void dep_my(int money) { // 내 통장 입금
		my_bank += money;
} 

public void witt_my(int money) { // 내 통장 출금
	if (my_bank<money) {System.out.printf("잔고가 부족합니다.\n");}
    else if (B_bank >= money) {my_bank -= money;}
}
}