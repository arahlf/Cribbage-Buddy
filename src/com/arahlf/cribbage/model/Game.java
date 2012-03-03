package com.arahlf.cribbage.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    
    public Game(Player player1, Player player2) {
        _player1 = player1;
        _player2 = player2;
    }
    
    public Player getPlayer1() {
        return _player1;
    }
    
    public Player getPlayer2() {
        return _player2;
    }
    
    public void setDealer(Player player) {
        _dealer = player;
    }
    
    public boolean isDealer(Player player) {
        return player.equals(_dealer);
    }
    
    public int getPlayer1Score() {
        return _player1Score;
    }
    
    public int getPlayer2Score() {
        return _player2Score;
    }
    
    public void addPoints(Player player, int points) {
        if (player == _player1) {
            _player1Score += points;
        }
        else if (player == _player2) {
            _player2Score += points;
        }
        else {
            throw new IllegalArgumentException("Unknown player specified.");
        }
        
        for (GameListener listener : _listeners) {
            listener.onScoreChange();
        }
    }
    
    public void addListener(GameListener listener) {
        _listeners.add(listener);
    }
    
    public void removeListener(GameListener listener) {
        _listeners.remove(listener);
    }
    
    private Player _dealer;
    private int _player1Score;
    private int _player2Score;
    private final Player _player1;
    private final Player _player2;
    private final List<GameListener> _listeners = new ArrayList<GameListener>();
}