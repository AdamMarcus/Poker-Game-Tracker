package com.company;

import com.company.Game;
import java.util.Date;

/**
 * Created by adamaustin on 7/3/17.
 *
 * This class will be used to construct player objects.
 */
public class Player {


    private String name = null;
    private Date activationDate = null;
    private Date lastGame = null;
    private Money credit = null;
    private Money won = null;
    private Money lost = null;
    private Money totalBuyIn = null;

    public Player() {

    }

    public Player(String _name) {
        name = _name;
        activationDate = new Date();
        credit = new Money(0.0);
        won = new Money(0.0);
        lost = new Money(0.0);
        totalBuyIn = new Money(0.0);
    }

    public String getName() {
        return name;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public Date getLastGame() {
        return lastGame;
    }

    public Money getCredit() {
        return credit;
    }

    public Money getLost() {
        return lost;
    }

    public Money getTotalBuyIn() {
        return totalBuyIn;
    }

    public void setName(String _name) {
        name = _name;
    }

    public void setLastGame(Date _lastGame) {
        lastGame = _lastGame;
    }

    public void setCredit(Money _credit) {

        credit = _credit;
    }

}
