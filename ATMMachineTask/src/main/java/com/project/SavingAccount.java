package com.project;

public class SavingAccount extends BankAccount {
    static final int WITHDRAW_LIMIT = 30000;
    static final int NO_OF_TRANSACTIONS = 4;

    public SavingAccount(String accNum, String accHolders, double accBalance) {
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
