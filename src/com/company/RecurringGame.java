package com.company;

import java.util.Vector;
import com.company.Money;
import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;

/**
 * Created by adamaustin on 7/3/17.
 *
 * This class will track the growth of the pot for a game being played regularly with
 * a set group of people.
 */
public class RecurringGame {
    private String name;
    private Player[] players = null;
    private Vector<Game> games = null;
    private Money totalPot = new Money();

    public RecurringGame() {

    }

    public RecurringGame(String _name) {
        name = _name;
    }

    public RecurringGame(String _name, Player[] _players) {
        name = _name;
        players = new Player[_players.length];
        for (int i = 0; i < _players.length; i++) {
            players[i] = _players[i];
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public Money getTotalPot() {
        return totalPot;
    }

    public Vector<Game> getAllGames() {
        return games;
    }

    public void setPlayers(Player[] _players) {
        players = new Player[_players.length];
        for (int i = 0; i < _players.length; i++) {
            players[i] = _players[i];
        }
    }

    public String getName() {
        return name;
    }
}
