package com.codsoft1;

public class ATMSystem {

	public static void main(String[] args) {
		
		BankAccount userAccount = new BankAccount(5000); 
        ATM atm = new ATM(userAccount);
        atm.start();
	}

}
