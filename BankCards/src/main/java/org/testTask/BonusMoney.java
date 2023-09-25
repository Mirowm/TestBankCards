package org.testTask;


import java.math.BigDecimal;
//import java.math.MathContext;
import java.math.RoundingMode;

public class BonusMoney implements Perk{
    private BigDecimal percent;
    private BigDecimal borderBonus;
    //private MathContext mathContext = new MathContext(5, RoundingMode.HALF_EVEN);

    public BonusMoney(double percent, int borderBonus){
        setPercent(percent);
        setBorderBonus(borderBonus);
    }

    public BigDecimal getPercent() {
        return percent;
    }
    //----------------------------setPercent------------------------------------------------
    public <N extends Number> void setPercent(N percent) {
//        this.percent = new BigDecimal(String.valueOf(percent)).multiply(new BigDecimal("0.01"));
        setPercent(String.valueOf(percent));
    }
    public void setPercent(String percent) {
//        this.percent = new BigDecimal(percent).multiply(new BigDecimal("0.01"));
        setPercent(new BigDecimal(percent));

    }
    public void setPercent(BigDecimal percent) {
        this.percent = percent.multiply(new BigDecimal("0.01"));
        System.gc();
    }

    public BigDecimal getBorderBonus() {
        return borderBonus;
    }
//----------------------------setBorderBonus------------------------------------------------
    public <N extends Number> void setBorderBonus(N borderBonus) {
//        this.borderBonus = new BigDecimal(String.valueOf(borderBonus));
        setBorderBonus(new BigDecimal(String.valueOf(borderBonus)));
    }
    public void setBorderBonus(String borderBonus) {
//        this.borderBonus = new BigDecimal(borderBonus);
        setBorderBonus(new BigDecimal(borderBonus));
    }
    public void setBorderBonus(BigDecimal borderBonus) {
        this.borderBonus = borderBonus;
        System.gc();
    }
//---------------------------------------------------------------------------
    @Override
    public String usePerk(String money){
        BigDecimal moneyValue = new BigDecimal(money);

        if(moneyValue.compareTo(borderBonus) >= 0){
            moneyValue = moneyValue.multiply(percent).setScale(5, RoundingMode.HALF_EVEN);
            String cashBack = moneyValue.toPlainString();
            return cashBack;

        }
        return "0";

    }

}
