package kr.or.kosa;

public class Bank_test {
	
	public String B_name;	        // ���� ���� ������
	public static int B_bank;   	// ���� ����
	public static boolean B_autho;	// ����

    public static int my_bank;      // �� ����
	
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
		System.out.printf("������: %s, ���� ���� �ܰ�: %d, ����: %s\n", B_name, B_bank, auth_P);
	}

    public void my_Data(int bank_my) {
		bank_my = my_bank;
	}

    public void my_Print() {
		if (B_autho == true) {
			auth_P = "O";
		} else {auth_P = "X";}
		System.out.printf("�� ���� �ܰ�: %d, ���� ���� ����: %s\n", my_bank, auth_P);
	}

public int money;

//////////////////////////////////////////////

public void dep_1(int money) { // ���� ���� �Ա�
		B_bank += money;
} 

public void witt_1(int money) { // ���� ���� ���
	if (B_autho == true)		
	{if (B_bank<money) {System.out.printf("�ܰ� �����մϴ�.\n");}
    else if (B_bank >= money) {B_bank -= money;}}
else { System.out.printf("��� ������ �����ϴ�.\n");}
}

public void dep_my(int money) { // �� ���� �Ա�
		my_bank += money;
} 

public void witt_my(int money) { // �� ���� ���
	if (my_bank<money) {System.out.printf("�ܰ� �����մϴ�.\n");}
    else if (B_bank >= money) {my_bank -= money;}
}
}