package org.testTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UltraCreditCardTest {
    UltraCreditCard card = new UltraCreditCard("10000");
    @Test
    void testFillUpBalance() {
        card.fillUpBalance("5000");
        Assertions.assertEquals("5000.25", card.balance.getBalance());
        Assertions.assertEquals("10000.0", card.getCreditBalance());
    }
}