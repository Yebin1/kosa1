package kr.or.kosa;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank{
	
		private ArrayList<Account> accounts;
		private int totalAccount;
		
		public Bank() {
			this.accounts = new ArrayList<Account>();
			this.totalAccount = 0;
		}

		//계좌를 생성한다.
		public void addAcount(String accountNo, String name) {
			accounts.add(new Account(accountNo, name));
		}
		
		//계좌를 찾는다.(계좌번호로)
		public Account getAccount(String accountNo) {
			Account t = null;
			System.out.println("= 해당 계좌번호의 계좌정보 =");
			for(int i=0; i<accounts.size(); i++) {
				if(accounts.get(i).getAccountNo().equals(accountNo)) {
					t = accounts.get(i);
					break;
				}
			}
			return t;
		}
		
		//계좌를 찾는다(소유자 명으로)
		public ArrayList<Account> findAccounts(String name){
			System.out.println("= 해당 소유자명의 계좌정보 =");
			ArrayList<Account> t = new ArrayList<Account>();
			
			for(int i=0; i<accounts.size(); i++) {
				if(accounts.get(i).getName().equals(name)) {
					t.add(accounts.get(i));
				}
			}
			
			return t;
		}
		
		//계좌 목록을 본다***********
		public ArrayList<Account> getAccounts(){
			return accounts;
		}
		
		//총계좌수를 반환
		public int getTotalAccount() {
			totalAccount = accounts.size();
			return totalAccount;
		}
	}
	
	
	/*private ArrayList<Account> accounts;
	private int totalAccount;
	
	public Bank() {
		this.accounts = new ArrayList<Account>();
		this.totalAccount = 0;
	}
	
	
	public void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
	}

	public Account getAccount(String accountNo) {
		System.out.println(accounts.contains(accountNo));
		
		
		
		/*for (int i = 0; i < accounts.size(); i++) {
			if (accountNo.equals(this.accountNo)) {
				System.out.println(accounts.get(i));
			} break;
		}
		
		System.out.println();
	}
	
	public ArrayList<Account> findAccounts(String name){
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.equals(name)) {
				System.out.println(accounts.get(i));
			} break;
		}
	}
	
	public ArrayList<Account> getAccounts(){
		for (Account a: accounts) {
			System.out.println(a.get(i));
		}
		
	}
	
	public int getTotalAccount() {
		return accounts.size();
	}*/
