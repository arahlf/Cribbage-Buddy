package com.arahlf.cribbage.model;

public class Game {
    
    public Game(Player player1, Player player2) {
        _player1 = player1;
        _player2 = player2;
    }
    
    private final Player _player1;
    private final Player _player2;
}