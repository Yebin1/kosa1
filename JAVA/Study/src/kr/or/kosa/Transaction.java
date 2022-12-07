package kr.or.kosa;

public class Transaction {
	private String transactionDate; //거래일
	private String transactionTime; //거래 시간
	private String kind; //구분(입금 or 출금)
	private long amount; //거래 금액
	private long balance; //잔고
	
	public Transaction(String strDate, String strDate1, String kind, long amount, long balance) {
		this.transactionDate = strDate;
		this.transactionTime = strDate1;
		this.kind = kind;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "[거래일자=" + transactionDate + ", 거래시간=" + transactionTime + ", "
				+ kind + ", 금액=" + amount + ", 잔액=" + balance + "]";
	}

}