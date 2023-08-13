package org.testTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CashBackTest {
    BonusMoney cashBack = new BonusMoney(5, 5000);
    @Test
    void testTakeCashBack() {
//Test1
        String value1 = cashBack.usePerk("10000");
        Assertions.assertEquals("500.0",value1);
//Test2
        String value2 = cashBack.usePerk("13330.001");
        Assertions.assertEquals("666.5", value2);
//Test3
        String value3 = cashBack.usePerk("4000.1212");
        Assertions.assertEquals("0.0", value3);
//Test4
        String value4 = cashBack.usePerk("33333.111111");
        Assertions.assertEquals("1666.66", value4);
    }
}