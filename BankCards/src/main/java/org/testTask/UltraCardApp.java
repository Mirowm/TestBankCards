package org.testTask;

public class UltraCardApp {
    public static void main(String[] args) {
        System.out.println("------------------UltraCreditCard-fillingUpBonus-0.005%-replenishment-from-100--------------");
        BankCard creditCard = new UltraCreditCard("10000");
        System.out.println(creditCard.getAvailableMoney());

        System.out.println("--------------------------------------");

        creditCard.fillUpBalance("5000");
        System.out.println("После пополнения карты на 5 000:");
        System.out.println(creditCard.getAvailableMoney());

        System.out.println("--------------------------------------");

        creditCard.pay("5000");
        System.out.println("После оплаты на 5 000:");
        System.out.println(creditCard.getAvailableMoney());

        System.out.println("--------------------------------------");

        creditCard.pay("3000");
        System.out.println("После оплаты на 3 000:");
        System.out.println(creditCard.getAvailableMoney());

        System.out.println("--------------------------------------");

        creditCard.fillUpBalance("2000");
        System.out.println("После пополнения карты на 2 000:");
        System.out.println(creditCard.getAvailableMoney());

        System.out.println("--------------------------------------");

        creditCard.fillUpBalance("2000");
        System.out.println("После пополнения карты на 2 000:");
        System.out.println(creditCard.getAvailableMoney());

        System.out.println("------------------UltraDebitCard-CashBack-5%--spending-from-5000---------------");
        BankCard debitCard = new UltraDebitCard();
        System.out.println(debitCard.getAvailableMoney());

        System.out.println("--------------------------------------");

        debitCard.fillUpBalance("10000");
        System.out.println("После пополнения карты на 10 000:");
        System.out.println(debitCard.getAvailableMoney());

        System.out.println("--------------------------------------");

        debitCard.pay("5000");
        System.out.println("После оплаты на 5 000:");
        System.out.println(debitCard.getAvailableMoney());

        System.out.println("--------------------------------------");

        debitCard.pay("9000");
        System.out.println("После  попытки оплаты на 9 000:");
        System.out.println(debitCard.getAvailableMoney());
    }
}
