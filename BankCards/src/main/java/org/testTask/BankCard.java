package org.testTask;

public abstract class BankCard {
    Balance balance = new Balance();
    public abstract void fillUpBalance(String money);
    public abstract boolean pay(String money);
    public Balance getBalance(){
        return balance;
    }
    public abstract String getAvailableMoney();
}
