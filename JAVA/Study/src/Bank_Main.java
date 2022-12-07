import java.util.ArrayList;

import kr.or.kosa.*;


public class Bank_Main {
	public static void main(String[] args) {
		
		Bank bank = new Bank();
        // 은행은 계좌를 등록한다.
        bank.addAcount("1111", "kim");
        bank.addAcount("2222", "lee");
        bank.addAcount("3333", "park");
        bank.addAcount("4444", "hong");
        bank.addAcount("5555", "hong");
        bank.addAcount("6666", "kim");
        bank.addAcount("7777", "lee");
        
        //은행은 계좌번호로 계좌를 찾을 수 있다.
        System.out.println("***계좌번호가 2222인 계좌 조회***");
        Account getAccount = bank.getAccount("2222");
        System.out.println(getAccount);
        
        //은행읜 계좌의 소유자명으로 계좌를 찾을 수 있다.
        System.out.println("\n***이름이 hong인 사람의 계좌 조회***");
        ArrayList<Account> findAccount = bank.findAccounts("hong");
        for(Account a : findAccount) {
            System.out.println(a);
        }
        
        //은행은 모든 계좌의 목록을 볼 수 있다.
        System.out.println("\n***모든 계좌 목록 조회***");
        ArrayList<Account> accounts = bank.getAccounts();
        for(Account a : accounts) {
            System.out.println(a);
        }
        
        //계좌는 입금, 출금 기능과 잔고 확인 기능이 있다.
        System.out.println("\n***계좌번호가 1111인 계좌에 5만원 입금***");
        Account kim = bank.getAccount("1111");
        kim.deposit(50000);
        System.out.println(kim);
        
        System.out.println("\n***계좌번호가 1111인 계좌에 2만원 출금***");
        kim.withdraw(20000);
        System.out.println(kim);
        
        System.out.println("\n***계좌번호가 1111인 계좌에 5000원 출금***");
        kim.withdraw(5000);
        System.out.println(kim);
        
        System.out.println("\n***계좌번호가 1111인 계좌의 잔고 확인하기***");
        System.out.println("kim 님의 \'1111\' 계좌 잔액: " + kim.getBalance());
        
        
        //계좌에서 잔액의 변화가 있을 때 마다 입출금 명세에 기록된다.
        //입출금 명세는 거래일자, 거래시간, 입금/출금, 금액, 잔액으로 구성된다.
        System.out.println("\n***계좌번호가 1111인 계좌의 거래내역 확인하기***");
        ArrayList<Transaction> kimTransaction = kim.getTransactions();
        for(int i = 0; i < kimTransaction.size(); i++) {
            System.out.println(kimTransaction.get(i));
        }
        
	}
}


/*public class Bank_Main {

	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.addAccount("10071", "백");
		bank.addAccount("890113", "택");
		bank.addAccount("0113", "택");
		bank.addAccount("987654321", "두팔");
		
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println(bank.getAccount("10071"));
		
		
	}

}
*/