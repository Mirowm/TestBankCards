package org.testTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DebitCardTest {
    DebitCard card1 = new DebitCard();
    DebitCard card2 = new DebitCard();
    @Test
    public void testFillUpBalance() {
        card1.fillUpBalance("100");
        Assertions.assertEquals("100", card1.getBalance().toString());
        card1.fillUpBalance("100.01");
        Assertions.assertEquals("200.01", card1.getBalance().toString());

    }
    @Test
    public void testPay() {
        card1.fillUpBalance("100");
        card2.fillUpBalance("2000");
        Assertions.assertEquals(true, card2.pay("500"));
        Assertions.assertEquals(true, card2.pay("1000"));
        Assertions.assertEquals(false, card1.pay("500"));
    }
}