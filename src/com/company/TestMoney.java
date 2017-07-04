package com.company;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.company.Money;

/**
 * Created by adamaustin on 7/3/17.
 */
public class TestMoney {

    // Tests
    @Test
    public void testMoneyConstructor1() {
        Money amount = new Money();
        assertEquals("Default dollars = 0", 0, amount.getDollars());
        assertEquals("Default cents = 0", 0, amount.getCents());
    }

    @Test
    public void testMoneyConstructor2() {
        Money amount = new Money(0.0);
        assertEquals("\"(0.0)\" dollars = 0", 0, amount.getDollars());
        assertEquals("\"(0.0)\" cents = 0", 0, amount.getCents());
    }

    @Test
    public void testMoneyConstructor3() {
        Money amount = new Money(1.0);
        assertEquals("\"(1.0)\" dollars = 1", 1, amount.getDollars());
        assertEquals("\"(1.0)\" cents = 0", 0, amount.getCents());
    }

    @Test
    public void testMoneyConstructor4() {
        Money amount = new Money(0.10);
        assertEquals("\"(0.10)\" dollars = 0", 0, amount.getDollars());
        assertEquals("\"(0.10)\" cents = 10", 10, amount.getCents());
    }

    @Test
    public void testMoneyConstructor5() {
        Money amount = new Money(1.01);
        assertEquals("\"(1.01)\" dollars = 1", 1, amount.getDollars());
        assertEquals("\"(1.01)\" cents = 1", 1, amount.getCents());
    }

    @Test
    public void testMoneyConstructor6() {
        Money amount = new Money(0, 0);
        assertEquals("\"(0, 0)\" dollars = 1", 0, amount.getDollars());
        assertEquals("\"(0, 0)\" cents = 1", 0, amount.getCents());
    }

    @Test
    public void testMoneyConstructor7() {
        Money amount = new Money(1, 0);
        assertEquals("\"(1, 0)\" dollars = 1", 1, amount.getDollars());
        assertEquals("\"(1, 0)\" cents = 1", 0, amount.getCents());
    }

    @Test
    public void testMoneyConstructor8() {
        Money amount = new Money(0, 10);
        assertEquals("\"(0, 10)\" dollars = 1", 0, amount.getDollars());
        assertEquals("\"(0, 10)\" cents = 1", 10, amount.getCents());
    }

    @Test
    public void testMoneyConstructor9() {
        Money amount = new Money(1, 1);
        assertEquals("\"(1, 1)\" dollars = 1", 1, amount.getDollars());
        assertEquals("\"(1, 1)\" cents = 1", 1, amount.getCents());
    }

    @Test
    public void testAdd1() {
        Money ammount1 = new Money(0.50);
        Money ammount2 = new Money (0.50);
        Money sum = ammount1.add(ammount2);
        assertEquals("$0.50 + $0.50 = $1.xx", 1, sum.getDollars());
        assertEquals("$0.50 + $0.50 = $x.00", 0, sum.getCents());
    }

    @Test
    public void testAdd2() {
        Money ammount1 = new Money(1.0);
        Money ammount2 = new Money(0.10);
        Money sum = ammount1.add(ammount2);
        assertEquals("$1.00 + $0.10 = $1.xx", 1, sum.getDollars());
        assertEquals("$1.00 + $0.10= $x.10", 10, sum.getCents());
    }

    @Test
    public void testAdd3() {
        Money ammount1 = new Money(1.50);
        Money ammount2 = new Money(1.51);
        Money sum = ammount1.add(ammount2);
        assertEquals("$1.50 + $1.51 = $3.xx", 3, sum.getDollars());
        assertEquals("$1.50 + $1.51 = $x.01", 1, sum.getCents());
    }

    @Test
    public void testAdd4() {
        Money ammount1 = new Money(1.50);
        Money ammount2 = new Money(1.50);
        Money sum = ammount1.add(ammount2);
        assertEquals("$1.50 + $1.50 = $1.xx", 3, sum.getDollars());
        assertEquals("$1.50 + $1.50 = $x.00", 0, sum.getCents());
    }
}
