package com.company;
import com.company.GameProfile;
import com.company.Game;

import java.util.Date;

/**
 * Created by adamaustin on 7/3/17.
 *
 * This class will be used to store information about individual games that have been played.
 */

public class Game {
    static final String TEXAS_HOLDEM = "Texas Hold'em";

    private GameProfile[] profiles;
    private Money gamePot = new Money();
    private String gameType = null;
    private boolean active = true;
    private Date date = null;

    public Game() {
        this.gameType = TEXAS_HOLDEM;
        date = new Date();
    }

    public Game(Player[] _players) {
        this.gameType = TEXAS_HOLDEM;

        GameProfile[] profiles = new GameProfile[_players.length];
        for (int i = 0; i < profiles.length; i++) {
            profiles[i] = new GameProfile(_players[i]);
        }
        date = new Date();
    }

    public void endgame() {
        active = false;
    }

    public GameProfile[] getProfiles() {
        return profiles;
    }

    public void setProfiles(GameProfile[] _profiles) {
        profiles = _profiles;
    }

    public Money getGamePot() {
        return gamePot;
    }

    public void addToPot(Money addAmount) {
        gamePot = gamePot.add(addAmount);
    }

    public String getGameType() {
        return gameType;
    }

    public Date getDate() {
        return date;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public boolean isActive() {
        return active;
    }

    public void setInactive() {
        active = false;
    }
}

