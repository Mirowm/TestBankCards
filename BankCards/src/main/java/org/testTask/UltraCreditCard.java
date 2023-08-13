package org.testTask;

public class UltraCreditCard extends CreditCard{
    Perk fillingUpBonus = new BonusMoney(0.005d, 100);;
    public UltraCreditCard(String creditLimit, String money) {
        super(creditLimit, money);
    }

    public UltraCreditCard(String creditLimit) {
        super(creditLimit);
        fillingUpBonus = new BonusMoney(0.005f, 100);
    }

    @Override
    public void fillUpBalance(String money) {
        Double resultMoney = Double.parseDouble(money) + Double.parseDouble(fillingUpBonus.usePerk(money));
        super.fillUpBalance(String.valueOf(resultMoney));
    }
}
