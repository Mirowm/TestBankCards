package org.testTask;


public class UltraDebitCard extends DebitCard{
   private Perk cashBack = new BonusMoney(5, 5000);

    public Perk getCashBack() {
        return cashBack;
    }

    private void setCashBack(BonusMoney cashBack ) {
        this.cashBack = cashBack;
    }

    @Override
    public boolean pay(String money) {
        boolean result = super.pay(money);
        if(result){
            fillUpBalance(cashBack.usePerk(money));
        }
        return result;
    }
}
