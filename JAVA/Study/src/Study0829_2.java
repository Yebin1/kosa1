// Study0829_2

import kr.or.kosa.Bank_test;

public class Study0829_2 {

	public static void main(String[] args) {
		Bank_test bank = new Bank_test();
		bank.my_Data(0);
    bank.my_Print();
    bank.dep_my(2000);
    bank.my_Print();
    bank.witt_my(3000);
    bank.witt_my(1000);
    bank.my_Print();
		bank.accountData("¹Ú¿¹ºó", 0, true);
		bank.BankPrint();
    bank.dep_1(1000);
    bank.BankPrint();
    bank.witt_1(5000);
    bank.BankPrint();
	}

}
