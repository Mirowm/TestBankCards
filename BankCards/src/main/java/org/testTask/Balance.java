package org.testTask;

import java.math.BigDecimal;
import java.util.Objects;

class Balance {
    private double balance = 0d;
    private double scale = Math.pow(10, 2);
    private double cashBack = 0.0d;

    public Balance(String value) {
        filingBalance(value);
    }
    public Balance() {
    }


    String getBalance(){
        return String.valueOf(balance);

    }
//-----------------------------------------------------------
    void filingBalance(String money){
        BigDecimal value = new BigDecimal(money);
        BigDecimal bigDecimalBalance = new BigDecimal(balance);
        balance = bigDecimalBalance.add(value).doubleValue();
        System.gc();
    }
    void filingBalance(Balance money){
        BigDecimal value = new BigDecimal(money.balance);
        BigDecimal bigDecimalBalance = new BigDecimal(balance);
        balance = bigDecimalBalance.add(value).doubleValue();
        System.gc();
    }
//-----------------------------------------------------------
    void reduceBalance(String money){
        BigDecimal value = new BigDecimal(money);
        BigDecimal bigDecimalBalance = new BigDecimal(balance);
        balance = bigDecimalBalance.subtract(value).doubleValue();
        System.gc();

    }
    void reduceBalance(Balance money){
        BigDecimal value = new BigDecimal(money.balance);
        BigDecimal bigDecimalBalance = new BigDecimal(balance);
        balance = bigDecimalBalance.subtract(value).doubleValue();
        System.gc();
    }
//-----------------------------------------------------------
    boolean isEnoughMoney(String money){
        //Balance value = new Balance(money);
        double value = Double.parseDouble(money);
        //if(this.balance.compareTo(value.balance) >= 0)
        if(balance - value >= 0)
            return true;
        else return false;
    }
    boolean isEnoughMoney(Balance money){
        if(balance - money.balance >= 0)
            return true;
        else return false;
    }
//-----------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Math.abs(balance - balance1.balance) <= 0.0000001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }


    @Override
    public String toString() {
        return  String.valueOf(balance);
    }
}
