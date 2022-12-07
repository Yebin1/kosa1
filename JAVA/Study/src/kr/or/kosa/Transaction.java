package kr.or.kosa;

public class Transaction {
	private String transactionDate; //�ŷ���
	private String transactionTime; //�ŷ� �ð�
	private String kind; //����(�Ա� or ���)
	private long amount; //�ŷ� �ݾ�
	private long balance; //�ܰ�
	
	public Transaction(String strDate, String strDate1, String kind, long amount, long balance) {
		this.transactionDate = strDate;
		this.transactionTime = strDate1;
		this.kind = kind;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "[�ŷ�����=" + transactionDate + ", �ŷ��ð�=" + transactionTime + ", "
				+ kind + ", �ݾ�=" + amount + ", �ܾ�=" + balance + "]";
	}

}