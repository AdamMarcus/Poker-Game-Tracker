package com.company;

import java.lang.Math;

/**
 * Created by adamaustin on 7/3/17.
 */
public class Money {
    private static int dollars = 0;
    private static int cents = 0;

    public Money() {
        this.dollars = 0;
        this.cents = 0;
    }

    public Money(Double fullMoney) {
        this.dollars = fullMoney.intValue();
        this.cents = (int)((fullMoney % 1)*100);
    }

    public Money(int _dollars, int _cents) {
        this.dollars = _dollars;
        this.cents = _cents;
    }

    public static void setDollars(int _dollars) {
        dollars = _dollars;
    }

    public static void setCents(int _cents) {
        cents = _cents;
    }

    public static int getDollars() {
        return dollars;
    }

    public static int getCents() {
        return cents;
    }

    public static Money add(Money ammount1) {
        int cents2 = ammount1.getCents();
        int totalCents =  cents + cents2;
        int xtraDollar = ((totalCents - (totalCents % 100)))/100;
        totalCents %= 100;
        int dollars2 = ammount1.getDollars();
        int totalDollars = dollars + dollars2 + xtraDollar;
        return new Money(totalDollars, totalCents);
    }

    public static Money subtract(Money ammount1) {
        int totalCents =  Math.abs(cents - ammount1.getCents());
        int xtraCents = Math.abs((dollars * 100) - (ammount1.getDollars()*100))%100;
        totalCents += xtraCents;
        int xtraDollar = (totalCents - (totalCents % 100));
        totalCents %= 100;
        int totalDollars = Math.abs(dollars - ammount1.getDollars() + xtraDollar);
        return new Money(totalDollars, totalCents);
    }
}
