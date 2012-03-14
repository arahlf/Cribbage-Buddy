package com.arahlf.cribbage;


public final class GameEngine {
    
    public void changeState(GameState gameState) {
        _gameState = gameState;
    }
    
    public GameState getGameState() {
        return _gameState;
    }
    
    private GameState _gameState;
}
