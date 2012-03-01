package com.arahlf.cribbage.model;

public class Game {
    
    public Game(Player player1, Player player2) {
        _player1 = player1;
        _player2 = player2;
        
        _deck = new Deck();
        //_deck.shuffle();
    }
    
    public Player getPlayer1() {
        return _player1;
    }
    
    public Player getPlayer2() {
        return _player2;
    }
    
    public Deck getDeck() {
        return _deck;
    }
    
    public GameState getState() {
        return _state;
    }
    
    public void lockCards() {
        _state = GameState.CHOOSING;
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
    
    // public for prototyping purposes until GameStates are separated out
    public Card player1CutCard;
    public  Card player2CutCard;
    
    private Deck _deck;
    private GameState _state = GameState.CUTTING;
    private Player _dealer;
    private int _player1Score;
    private int _player2Score;
    private final Player _player1;
    private final Player _player2;
}