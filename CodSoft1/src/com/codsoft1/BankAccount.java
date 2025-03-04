package com.codsoft1;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;  // Ensures balance is never negative
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf(" Successfully deposited ₹%.2f%n", amount);
        } else {
            System.out.println(" Invalid deposit amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf(" Successfully withdrawn ₹%.2f%n", amount);
            return true;
        } else if (amount > balance) {
            System.out.println(" Insufficient balance! Transaction failed.");
        } else {
            System.out.println(" Invalid withdrawal amount. Please enter a positive value.");
        }
        return false;
    }
}
