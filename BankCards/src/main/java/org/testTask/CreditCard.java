package org.testTask;

public class CreditCard extends BankCard{

    private final String CREDIT_LIMIT;
    private Balance creditBalance;

    public CreditCard(String creditLimit, String money) {
        CREDIT_LIMIT = creditLimit;
        creditBalance = new Balance(CREDIT_LIMIT);
        this.balance = new Balance(money);
    }
    public CreditCard(String creditLimit) {
        CREDIT_LIMIT = creditLimit;
        creditBalance = new Balance(CREDIT_LIMIT);
        this.balance = new Balance();
    }

    @Override
    public void fillUpBalance(String money) {
        Balance entered = new Balance(money);
        if(!creditBalance.getBalance().equals(CREDIT_LIMIT)){
            Balance diffBalance = new Balance(CREDIT_LIMIT);
            diffBalance.reduceBalance(creditBalance);
            if(entered.isEnoughMoney(diffBalance)){ //(money >= (CREDIT_LIMIT - creditBalance))?
                entered.reduceBalance(diffBalance); // money = enteredMoney - (CREDIT_LIMIT - creditBalance)
                balance.filingBalance(entered); //balance += money
                creditBalance = new Balance(CREDIT_LIMIT);
            }else {
                creditBalance.filingBalance(entered);
            }
        }else
            balance.filingBalance(entered); // creditBalance == CREDIT_LIMIT -> balance += money
    }

    @Override
    public boolean pay(String price) {
        Balance interim  = new Balance(price);
        if(balance.isEnoughMoney(interim)){ // balance >= price?
            balance.reduceBalance(interim);
            return true; //money is enough
        } else if (balance.getBalance().equals("0")) { // balance == 0?
            if(creditBalance.isEnoughMoney(interim)){ // creditBalance >= price?
                creditBalance.reduceBalance(interim);
                return true; //credit money
            }else return false; //not enough money
        }else if(getTotalBalance().isEnoughMoney(interim)){ // balance + creditBalance >= price?
//            Balance interim  = new Balance(price);
            interim .reduceBalance(balance);
            balance = new Balance();
            creditBalance.reduceBalance(interim );
            return true;
        }
        return false; //not enough money
    }

    Balance getTotalBalance(){
        Balance totalBalance = new Balance();
        totalBalance.filingBalance(balance);
        totalBalance.filingBalance(creditBalance);
        return totalBalance;
    }
    @Override
    public String getAvailableMoney() {
        return String.format("Общий баланс: %s\nКредитные средства: %s\nСобственные средства: %s\n", getTotalBalance(),getCreditBalance(), getBalance() );
    }


    public String getCreditBalance() {
        return creditBalance.getBalance();
    }
}
