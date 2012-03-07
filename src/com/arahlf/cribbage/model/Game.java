package com.arahlf.cribbage.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    
    public Game(Player player1, Player player2) {
        _player1 = player1;
        _player2 = player2;
        
        Deck deck = new Deck();
        deck.shuffle();
        
        _commonArea = new CommonArea(deck.dealCard());
        _playArea1 = new PlayArea(this, _player1);
        _playArea2 = new PlayArea(this, _player2);
        
        
        
        for (int i = 0; i < 6; i++) {
            _playArea1.dealCard(deck.dealCard());
            _playArea2.dealCard(deck.dealCard());
        }
    }
    
    public Player getPlayer1() {
        return _player1;
    }
    
    public Player getPlayer2() {
        return _player2;
    }
    
    public CommonArea getCommonArea() {
        return _commonArea;
    }
    
    public PlayArea getPlayArea1() {
        return _playArea1;
    }
    
    public PlayArea getPlayArea2() {
        return _playArea2;
    }
    
    public int getPlayerScore(Player player) {
        return player == _player1 ? _player1Score : _player2Score;
    }
    
    public void addPoints(Player player, int points) {
        if (player == _player1) {
            _player1Score += points;
        }
        else {
            _player2Score += points;
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
    
    private int _player1Score;
    private int _player2Score;
    private CommonArea _commonArea;
    private PlayArea _playArea1;
    private PlayArea _playArea2;
    private final Player _player1;
    private final Player _player2;
    private final List<GameListener> _listeners = new ArrayList<GameListener>();
}