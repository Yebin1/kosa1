package kr.or.kosa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Account {
	private String accountNo; //���� ��ȣ
	private String name; //�����ڸ�
	private long balance; //�ܰ�
	private ArrayList<Transaction> transactions; //�ŷ�����(0���̻�)
	
	@Override
	public String toString() {
		return "[���¹�ȣ: " + accountNo + ", �����ڸ�: " + name + ", �ܾ�: " + balance + "]";
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

	public void deposit(long amount) { //�Ա�
		balance += amount;
		
		Calendar time = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String strDate = sdf.format(time.getTime());
		String strDate1 = sdf1.format(time.getTime());
		
		transactions.add(new Transaction(strDate, strDate1, "�Ա�", amount, balance));
	}
	
	public void withdraw(long amount) { //���
		if(balance < amount) {
			System.out.println("�ܰ� �����մϴ�.");
		}else {
			balance -= amount;
			
			Calendar time = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
			String strDate = sdf.format(time.getTime());
			String strDate1 = sdf1.format(time.getTime());
			
			transactions.add(new Transaction(strDate, strDate1, "���", amount, balance));
		}
		
	}
	public long getBalance() { //�ܰ� Ȯ��
		return balance;
	}
	
	public ArrayList<Transaction> getTransactions(){ //�ŷ������� ����
		
		return this.transactions;
	}

}
