import java.util.ArrayList;

import kr.or.kosa.*;


public class Bank_Main {
	public static void main(String[] args) {
		
		Bank bank = new Bank();
        // ������ ���¸� ����Ѵ�.
        bank.addAcount("1111", "kim");
        bank.addAcount("2222", "lee");
        bank.addAcount("3333", "park");
        bank.addAcount("4444", "hong");
        bank.addAcount("5555", "hong");
        bank.addAcount("6666", "kim");
        bank.addAcount("7777", "lee");
        
        //������ ���¹�ȣ�� ���¸� ã�� �� �ִ�.
        System.out.println("***���¹�ȣ�� 2222�� ���� ��ȸ***");
        Account getAccount = bank.getAccount("2222");
        System.out.println(getAccount);
        
        //������ ������ �����ڸ����� ���¸� ã�� �� �ִ�.
        System.out.println("\n***�̸��� hong�� ����� ���� ��ȸ***");
        ArrayList<Account> findAccount = bank.findAccounts("hong");
        for(Account a : findAccount) {
            System.out.println(a);
        }
        
        //������ ��� ������ ����� �� �� �ִ�.
        System.out.println("\n***��� ���� ��� ��ȸ***");
        ArrayList<Account> accounts = bank.getAccounts();
        for(Account a : accounts) {
            System.out.println(a);
        }
        
        //���´� �Ա�, ��� ��ɰ� �ܰ� Ȯ�� ����� �ִ�.
        System.out.println("\n***���¹�ȣ�� 1111�� ���¿� 5���� �Ա�***");
        Account kim = bank.getAccount("1111");
        kim.deposit(50000);
        System.out.println(kim);
        
        System.out.println("\n***���¹�ȣ�� 1111�� ���¿� 2���� ���***");
        kim.withdraw(20000);
        System.out.println(kim);
        
        System.out.println("\n***���¹�ȣ�� 1111�� ���¿� 5000�� ���***");
        kim.withdraw(5000);
        System.out.println(kim);
        
        System.out.println("\n***���¹�ȣ�� 1111�� ������ �ܰ� Ȯ���ϱ�***");
        System.out.println("kim ���� \'1111\' ���� �ܾ�: " + kim.getBalance());
        
        
        //���¿��� �ܾ��� ��ȭ�� ���� �� ���� ����� ���� ��ϵȴ�.
        //����� ���� �ŷ�����, �ŷ��ð�, �Ա�/���, �ݾ�, �ܾ����� �����ȴ�.
        System.out.println("\n***���¹�ȣ�� 1111�� ������ �ŷ����� Ȯ���ϱ�***");
        ArrayList<Transaction> kimTransaction = kim.getTransactions();
        for(int i = 0; i < kimTransaction.size(); i++) {
            System.out.println(kimTransaction.get(i));
        }
        
	}
}


/*public class Bank_Main {

	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.addAccount("10071", "��");
		bank.addAccount("890113", "��");
		bank.addAccount("0113", "��");
		bank.addAccount("987654321", "����");
		
		System.out.println("= �ش� ���¹�ȣ�� �������� =");
		System.out.println(bank.getAccount("10071"));
		
		
	}

}
*/