package com.company;

import com.company.Game;
import java.util.Date;

/**
 * Created by adamaustin on 7/3/17.
 *
 * This class will be used to construct player objects.
 */
public class Player {


    private static String name = null;
    private static Date activationDate = null;
    private static Date lastGame = null;
    private static Money credit = null;
    private static Money won = null;
    private static Money lost = null;
    private static Money totalBuyIn = null;

    public Player() {

    }

    public Player(String _name) {
        this.name = _name;
        this.activationDate = new Date();
        this.credit = new Money(0.0);
        this.won = new Money(0.0);
        this.lost = new Money(0.0);
        this.totalBuyIn = new Money(0.0);
    }

    public static String getName() {
        return name;
    }

    public static Date getActivationDate() {
        return activationDate;
    }

    public static Date getLastGame() {
        return lastGame;
    }

    public static Money getCredit() {
        return credit;
    }

    public static Money getLost() {
        return lost;
    }

    public static Money getTotalBuyIn() {
        return totalBuyIn;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static void setActivationDate(Date activationDate) {
        Player.activationDate = activationDate;
    }

    public static void setLastGame(Date lastGame) {
        Player.lastGame = lastGame;
    }

    public static void setCredit(Money credit) {
        Player.credit = credit;
    }

    public static void setWon(Money won) {
        Player.won = won;
    }

    public static void setLost(Money lost) {
        Player.lost = lost;
    }
    public static void setTotalBuyIn(Money totalBuyIn) {
        Player.totalBuyIn = totalBuyIn;
    }

}
