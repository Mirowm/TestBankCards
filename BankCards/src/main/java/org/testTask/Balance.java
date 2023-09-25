package org.testTask;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

class Balance {
    private BigDecimal balance = BigDecimal.ZERO;
    //private MathContext mathContext = new MathContext(5, RoundingMode.HALF_EVEN);
    private BigDecimal cashBack = BigDecimal.ZERO;

    public Balance(String value) {
        filingBalance(value);
    }
    public Balance() {
    }


    String getBalance(){
        return String.valueOf(balance);

    }
//-----------------------filingBalance------------------------------------
    void filingBalance(String money){
        BigDecimal value = new BigDecimal(money);
        filingBalance(value);
    }
    void filingBalance(Balance money){
        BigDecimal value = money.balance;
        filingBalance(value);
    }
    void filingBalance(BigDecimal money){
        BigDecimal value = money;
        balance = balance.add(value);
        System.gc();
    }
//------------------------reduceBalance-----------------------------------
    void reduceBalance(String money){
        BigDecimal value = new BigDecimal(money);
        reduceBalance(value);

    }
    void reduceBalance(Balance money){
        BigDecimal value = money.balance;
        reduceBalance(value);
    }
    void reduceBalance(BigDecimal money){
        balance = balance.subtract(money);
        System.gc();
    }
//---------------------isEnoughMoney--------------------------------------
    boolean isEnoughMoney(String money){
//        Balance value = new Balance(money);
//        if(this.balance.compareTo(value.balance) >= 0)
//            return true;
//        else return false;
        return isEnoughMoney(new Balance(money));
    }
    boolean isEnoughMoney(Balance money){

        if(balance.compareTo(money.balance) >= 0)
            return true;
        else return false;
    }
//-----------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Objects.equals(getBalance(), balance1.getBalance()) && Objects.equals(cashBack, balance1.cashBack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBalance(), cashBack);
    }

    @Override
    public String toString() {
        return  String.valueOf(balance);
    }
}
