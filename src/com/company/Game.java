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

    private static GameProfile[] profiles;
    private Money gamePot = new Money();
    private String gameType = null;

    public Game() {
        this.gameType = TEXAS_HOLDEM;
    }

    public Game(Player[] _players) {

        this.gameType = TEXAS_HOLDEM;
    }
}

