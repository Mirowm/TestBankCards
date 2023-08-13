package org.testTask;

public class DebitCard extends BankCard{


    @Override
    public void fillUpBalance(String money) {
        balance.filingBalance(money);
    }

    @Override
    public boolean pay(String money) {
        Balance interim  = new Balance(money);
        if(balance.isEnoughMoney(interim)){
       //     System.out.println("Покупка совершена");
            balance.reduceBalance(interim);
            return true;
        }else{
        //    System.out.println("На счете недостаточно средств");
            return false;
        }
    }

    @Override
    public String getAvailableMoney() {
        return String.format("баланс = %s", balance.toString());
    }

}
