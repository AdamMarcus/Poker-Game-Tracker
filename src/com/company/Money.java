package com.company;

import java.lang.Math;

/**
 * Created by adamaustin on 7/3/17.
 */
public class Money {
    private int dollars = 0;
    private int cents = 0;

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

    public void setDollars(int _dollars) {
        this.dollars = _dollars;
    }

    public void setCents(int _cents) {
        this.cents = _cents;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    public Money add(Money amount1) {
        int cents2 = amount1.getCents();
        int totalCents =  cents + cents2;
        int xtraDollar = ((totalCents - (totalCents % 100)))/100;
        totalCents %= 100;
        int dollars2 = amount1.getDollars();
        int totalDollars = dollars + dollars2 + xtraDollar;
        return new Money(totalDollars, totalCents);
    }

    public Money subtract(Money amount1) {
        int totalCents =  Math.abs(cents - amount1.getCents());
        int xtraCents = Math.abs((dollars * 100) - (amount1.getDollars()*100))%100;
        totalCents += xtraCents;
        int xtraDollar = (totalCents - (totalCents % 100));
        totalCents %= 100;
        int totalDollars = Math.abs(dollars - amount1.getDollars() + xtraDollar);
        return new Money(totalDollars, totalCents);
    }

    public int compare(Money amount1) {
        if (dollars < amount1.getDollars()) {
            return -1;
        } else if (dollars == amount1.getDollars()) {
            if (cents < amount1.getCents()) {
                return -1;
            } else if (cents == amount1.getCents()) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
