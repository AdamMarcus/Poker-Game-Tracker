package com.company.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.company.Player;
import com.company.RecurringGame;
import org.junit.Test;

/**
 * Created by adamaustin on 7/11/17.
 *
 * This class tests the RecurringGame class
 */
public class TestRecurringGame {

    @Test
    public void testConstructor1() {
        RecurringGame newGame = new RecurringGame();
        assertEquals(null, newGame.getAllGames());
        assertEquals(null, newGame.getPlayers());
    }

    @Test
    public void testConstructor2() {
        Player[] players = {new Player("Adam")};
        RecurringGame newGame = new RecurringGame("Test Game", players);
        assertEquals(null, newGame.getAllGames());
        assertEquals(players.length, newGame.getPlayers().length);
    }

    @Test
    public void testConstructor3() {
        Player[] players = {new Player("Adam"), new Player("Claire"), new Player("Sam"), new Player("Sarah"), new Player("Jenn")};
        RecurringGame newGame = new RecurringGame("Test Game", players);
        assertEquals(null, newGame.getAllGames());
        assertEquals(players.length, newGame.getPlayers().length);
    }
}
