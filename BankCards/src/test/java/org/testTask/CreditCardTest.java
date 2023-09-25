package org.testTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreditCardTest {
    CreditCard card1 = new CreditCard("10000");

    @Test

    void testFillUpBalance() {
        card1.fillUpBalance("5000");
        Assertions.assertEquals("5000", card1.balance.getBalance());
        Assertions.assertEquals("10000", card1.getCreditBalance());

    }
    @Test

    void testPay(){
//test1
        card1.fillUpBalance("5000");
        card1.pay("16000"); //not enough money
        Assertions.assertEquals("5000", card1.balance.getBalance());
        Assertions.assertEquals("10000", card1.getCreditBalance());
//test2
        card1.pay("10000"); // balance + creditBalance >= price
        Assertions.assertEquals("0", card1.balance.getBalance());
        Assertions.assertEquals("5000", card1.getCreditBalance());
//test3
        card1.pay("10000"); //not enough money
        Assertions.assertEquals("0", card1.balance.getBalance());
        Assertions.assertEquals("5000", card1.getCreditBalance());
//test4
        card1.pay("5000");
        Assertions.assertEquals("0", card1.balance.getBalance());
        Assertions.assertEquals("0", card1.getCreditBalance());
    }

    @Test
    void testPayAndFillUp() {
        card1.fillUpBalance("5000");
//test1
        card1.pay("5000");
        Assertions.assertEquals("0", card1.balance.getBalance());
        Assertions.assertEquals("10000", card1.getCreditBalance());
//test2
        card1.pay("3000");
        Assertions.assertEquals("0", card1.balance.getBalance());
        Assertions.assertEquals("7000", card1.getCreditBalance());
//test3
        card1.fillUpBalance("2000");
        Assertions.assertEquals("0", card1.balance.getBalance());
        Assertions.assertEquals("9000", card1.getCreditBalance());
//test4
        card1.fillUpBalance("2000");
        Assertions.assertEquals("1000", card1.balance.getBalance());
        Assertions.assertEquals("10000", card1.getCreditBalance());
    }

}