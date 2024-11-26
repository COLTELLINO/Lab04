package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount {

    public static final double TRANSACTION_FEE = 0.1;

    public RestrictedBankAccount(final AccountHolder accountHolder, final double balance) {
        super(accountHolder, balance);
    }

    protected double computeFees() {
        return MANAGEMENT_FEE + (getTransactionsCount() * TRANSACTION_FEE);
    }

    protected boolean isWithdrawAllowed(final double amount) {
        return getBalance() >= amount;
    }
}
