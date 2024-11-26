package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount {

    public ClassicBankAccount(final AccountHolder accountHolder, final double balance) {
        super(accountHolder, balance);
    }

    protected double computeFees() {
        return MANAGEMENT_FEE;
    }

    protected boolean isWithdrawAllowed(final double amount) {
        return true;
    }

}
