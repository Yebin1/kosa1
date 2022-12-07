package kr.or.kosa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Account {
	private String accountNo; //계좌 번호
	private String name; //소유자명
	private long balance; //잔고
	private ArrayList<Transaction> transactions; //거래내역(0개이상)
	
	@Override
	public String toString() {
		return "[계좌번호: " + accountNo + ", 소유자명: " + name + ", 잔액: " + balance + "]";
	}
	
	//////////////////////////////////////////
	public String getAccountNo() {
		return accountNo;
	}


	public String getName() {
		return name;
	}

	//////////////////////////////////////////
	
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		balance = 0;
		transactions = new ArrayList<Transaction>();
	}

	public void deposit(long amount) { //입금
		balance += amount;
		
		Calendar time = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String strDate = sdf.format(time.getTime());
		String strDate1 = sdf1.format(time.getTime());
		
		transactions.add(new Transaction(strDate, strDate1, "입금", amount, balance));
	}
	
	public void withdraw(long amount) { //출금
		if(balance < amount) {
			System.out.println("잔고가 부족합니다.");
		}else {
			balance -= amount;
			
			Calendar time = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
			String strDate = sdf.format(time.getTime());
			String strDate1 = sdf1.format(time.getTime());
			
			transactions.add(new Transaction(strDate, strDate1, "출금", amount, balance));
		}
		
	}
	public long getBalance() { //잔고 확인
		return balance;
	}
	
	public ArrayList<Transaction> getTransactions(){ //거래내역을 본다
		
		return this.transactions;
	}

}
