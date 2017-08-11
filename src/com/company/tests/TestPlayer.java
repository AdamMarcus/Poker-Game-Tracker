package com.company.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import com.company.Money;

import com.company.Player;

/**
 * Created by adamaustin on 7/4/17.
 *
 * This class tests the Player class
 */
public class TestPlayer {

    @Test
    public void testPlayerConstructor1() {
        Player newPlayer = new Player();
        assertEquals("Name is null when base constructor used:", null, newPlayer.getName());
        assertEquals("Activation date is null when base constructor used:", null, newPlayer.getActivationDate());
        assertEquals("Last game date is null when base constructor used:", null, newPlayer.getLastGame());
        assertEquals("Credit is null when base constructor used:", null, newPlayer.getCredit());
        assertEquals("Won is null when base constructor used:", null, newPlayer.getLastGame());
        assertEquals("Lost is null when base constructor used:", null, newPlayer.getLastGame());
        assertEquals("Total buy in is null when base constructor used:", null, newPlayer.getLastGame());
    }

    @Test
    public void testPlayerConstructor2() {
        Player newPlayer = new Player("Adam");
        assertEquals("Name is set when (String) constructor used:", "Adam", newPlayer.getName());
        assertNotEquals("Activation date is set when (String) constructor used:", null, newPlayer.getActivationDate());
        assertEquals("Last game date is null when (String) constructor used:", null, newPlayer.getLastGame());
        assertEquals("Credit is null when (String) constructor used:", null, newPlayer.getLastGame());
        assertEquals("Won is null when (String) constructor used:", null, newPlayer.getLastGame());
        assertEquals("Lost is null when (String) constructor used:", null, newPlayer.getLastGame());
        assertEquals("Total buy in is null when (String) constructor used:", null, newPlayer.getLastGame());
    }
}
