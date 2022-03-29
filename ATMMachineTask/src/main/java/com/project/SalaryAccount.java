package com.project;

public class SalaryAccount extends BankAccount {

    static final int WITHDRAW_LIMIT = 1000000;
    static final int NO_OF_TRANSACTIONS = 8;

    public SalaryAccount(String accNum, String accHolders, double accBalance) {
        super(accNum, accHolders, accBalance);
    }

    double withdraw(double amount) {
        double accountBalance = getAccBalance();
        if (amount > WITHDRAW_LIMIT) {
            throw new IllegalArgumentException("Withdraw less amount than" + amount);
        } else if (accountBalance < amount) {
            throw new IllegalArgumentException("Account Balance is Low!!!");
        } else {
            setAccBalance(accountBalance - amount);
        }
        return amount;
    }

    double deposit(double amount) {
        return amount;
    }
}
