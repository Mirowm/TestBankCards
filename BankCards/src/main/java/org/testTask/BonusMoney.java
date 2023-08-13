package org.testTask;


public class BonusMoney implements Perk{
    private double percent;
    private double borderBonus;

    public BonusMoney(double percent, int borderBonus){
        this.percent = percent;
        this.borderBonus = (double) borderBonus;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public double getBorderBonus() {
        return borderBonus;
    }

    public void setBorderBonus(double borderBonus) {
        this.borderBonus = borderBonus;
    }

    @Override
    public String usePerk(String money){
        double scale = Math.pow(10, 2);
        double cashBack = 0.0d;
        double moneyValue = Double.parseDouble(money);
        if(moneyValue >= borderBonus){
            cashBack = Math.round(((double) moneyValue * percent * 0.01d)*scale)/scale;
      //      System.out.printf("cash back %s \n", cashBack);

        }
        return String.valueOf(cashBack);

    }

}
