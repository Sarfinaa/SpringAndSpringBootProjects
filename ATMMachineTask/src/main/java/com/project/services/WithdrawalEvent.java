package com.project.services;

import org.springframework.context.ApplicationEvent;
import com.project.BankAccount;

public class WithdrawalEvent extends ApplicationEvent {
    int amount;
    BankAccount acc;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        acc = bankAccount;
    }

    public WithdrawalEvent(Object source) {
        super(source);
    }

    public void message() {
        System.out.println("Amount Withdrawn: " + amount);
        System.out.println("current Balance: " + acc.getAccBalance());
    }
}