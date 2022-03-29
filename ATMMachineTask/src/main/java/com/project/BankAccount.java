package com.project;

public abstract class BankAccount {
    private String accNum;
    private String accHolders;
    private double accBalance;

    void showBalance() {
        System.out.println("Balance:" + accBalance);
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getAccHolders() {
        return accHolders;
    }

    public BankAccount(String accNum, String accHolders, double accBalance) {
        this.accNum = accNum;
        this.accHolders = accHolders;
        this.accBalance = accBalance;
    }

    public void setAccHolders(String accHolders) {
        this.accHolders = accHolders;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double d) {
        this.accBalance = d;
    }

    abstract double withdraw(double amount);

    abstract double deposit(double amount);

    @Override
    public String toString() {
        return "BankAccount [accBalance=" + accBalance + ", accHolders=" + accHolders + ", accNum=" + accNum + "]";
    }

}
