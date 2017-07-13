package com.company;



/**
 * Created by adamaustin on 7/3/17.
 *
 * This class will manage the profile of a player who plays in a game and their stats for that game.
 */
public class GameProfile {
    private static Player player;
    private static Money cashBuyIn;
    private static Money creditBuyIn;
    private static Money totalBuyIn;
    private static Money payOut = new Money(0.00);

    public GameProfile() {

    }

    public GameProfile(Player _player) {
        this.player = _player;
    }

    GameProfile(Player _player, Money _cashBuyIn, Money _creditBuyIn) {
        this.player = _player;
        this.cashBuyIn = _cashBuyIn;
        this.creditBuyIn = _creditBuyIn;
        this.totalBuyIn = _cashBuyIn.add(_creditBuyIn);
    }
}
