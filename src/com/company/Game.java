package com.company;
import com.company.GameProfile;
import com.company.Game;

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

    public Game() {
        this.gameType = TEXAS_HOLDEM;
    }

    public Game(Player[] _players) {

        this.gameType = TEXAS_HOLDEM;
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

