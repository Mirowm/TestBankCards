package org.testTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BalanceTest {
    public Balance balance1 = new Balance("1000");
    public Balance balance2 = new Balance("1000");
    public Balance balance3 = new Balance("3000");
    public Balance balance4 = new Balance();

    @Test
    void testFilingBalance() {
//test1
        balance1.filingBalance("100");
        Assertions.assertEquals("1100.0", balance1.getBalance());
//test2
        balance4.filingBalance("500");
        Assertions.assertEquals("500.0", balance4.getBalance());

    }
    @Test
    void testGetBalance() {
        Assertions.assertEquals("1000.0", balance1.getBalance());
    }
    @Test
    void testReduceBalance() {
        balance3.reduceBalance("100");
        Assertions.assertEquals("2900.0", balance3.getBalance());

    }
    @Test
    void testBalanceEquals() {
//test1
        Assertions.assertEquals(true, balance1.equals(balance2));
//test2
        Assertions.assertEquals(false, balance1.equals(balance3) );
    }
    @Test
    void testBalanceHashCode() {
//test1
        Assertions.assertEquals(true, balance1.hashCode() == balance2.hashCode());
//test2
        Assertions.assertEquals(false, balance1.hashCode() == balance3.hashCode());
    }
    @Test
    void testIsEnoughMoney() {
//test1
        Assertions.assertEquals(true, balance3.isEnoughMoney("1000"));
//test2
        Assertions.assertEquals(true, balance3.isEnoughMoney("3000"));
//test3
        Assertions.assertEquals(false, balance1.isEnoughMoney("3000"));
    }
}