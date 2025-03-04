package com.codsoft1;

import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n Welcome to the ATM ");
            System.out.println("1️ Withdraw");
            System.out.println("2️ Deposit");
            System.out.println("3️ Check Balance");
            System.out.println("4️ Exit");
            System.out.print("Select an option: ");

            int choice = getValidIntegerInput();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    System.out.printf(" Current Balance: ₹%.2f%n", userAccount.getBalance());
                    break;
                case 4:
                    System.out.println(" Exiting ATM. Thank you for using our service!");
                    return;
                default:
                    System.out.println(" Invalid option! Please choose between 1 and 4.");
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = getValidDoubleInput();
        userAccount.withdraw(amount);
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = getValidDoubleInput();
        userAccount.deposit(amount);
    }

    private int getValidIntegerInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.print(" Invalid input! Please enter a valid number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private double getValidDoubleInput() {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.print(" Invalid input! Please enter a valid amount: ");
                scanner.next(); // Clear invalid input
            }
        }
    }
}