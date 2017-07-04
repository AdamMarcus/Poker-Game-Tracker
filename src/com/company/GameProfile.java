package com.company;



/**
 * Created by adamaustin on 7/3/17.
 */
public class GameProfile {
    private static Player player;
    private static Money cashBuyIn;
    private static Money creditBuyIn;
    private static Money totalBuyIn;
    private static Money payOut = new Money(0.00);

    GameProfile(Player _player, Money _cashBuyIn, Money _creditBuyIn) {
        player = _player;
        cashBuyIn = _cashBuyIn;
        creditBuyIn = _creditBuyIn;
        totalBuyIn = _cashBuyIn.add(_creditBuyIn);
    }
}
