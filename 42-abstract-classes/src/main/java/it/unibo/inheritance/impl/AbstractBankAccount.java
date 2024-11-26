package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;
import it.unibo.inheritance.api.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {

    public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;
    private final AccountHolder holder;
    private double balance;
    private int transactions;

    protected AbstractBankAccount(final AccountHolder accountHolder, final double balance) {
        this.holder = accountHolder;
        this.balance = balance;
        this.transactions = 0;
    }

    public final void chargeManagementFees(final int usrID) {
        final double feeAmount = computeFees();
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            balance -= feeAmount;
            resetTransactions();
        }
    }

    public final void deposit(final int usrID, final double amount) {
        this.transactionOp(usrID, amount);
    }

    public final void depositFromATM(final int usrID, final double amount) {
        this.deposit(usrID, amount - ATM_TRANSACTION_FEE);
    }

    @Override
    public final AccountHolder getAccountHolder() {
        return holder;
    }

    public final double getBalance() {
        return this.balance;
    }

    protected final void setBalance(final double amount) {
        this.balance = amount;
    }

    public final int getTransactionsCount() {
        return this.transactions;
    }

    public final void withdraw(final int usrID, final double amount) {
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(usrID, -amount);
        }
    }

    public final void withdrawFromATM(final int usrID, final double amount) {
        this.withdraw(usrID, amount + ATM_TRANSACTION_FEE);
    }

    protected boolean checkUser(final int id) {
        return this.holder.getUserID() == id;
    }

    protected abstract double computeFees();

    protected final void incrementTransactions() {
        this.transactions++;
    }

    protected abstract boolean isWithdrawAllowed(double amount);

    protected final void resetTransactions() {
        this.transactions = 0;
    }

    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incrementTransactions();
        }
    }

}
