package org.testTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UltraDebitCardTest {
    UltraDebitCard card1 = new UltraDebitCard();
    UltraDebitCard card2 = new UltraDebitCard();
    @Test
    void testPay() {
        card1.fillUpBalance("10000");
        card2.fillUpBalance("10000");
//Test1
        Assertions.assertEquals(true, card2.pay("5000"));
        Assertions.assertEquals("5250.00000", card2.balance.getBalance());
//Test2
        Assertions.assertEquals(true, card1.pay("1000"));
        Assertions.assertEquals("9000", card1.balance.getBalance());
//Test3
        Assertions.assertEquals(false, card1.pay("33333.111"));
        Assertions.assertEquals("9000", card1.balance.getBalance());
    }
}