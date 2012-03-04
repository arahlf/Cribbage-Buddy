package com.arahlf.cribbage.model;

import static com.arahlf.cribbage.CribbageUtils.CRIBBAGE_CARD_COMPARATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PlayArea {
    
    public PlayArea(Game game, Player player) {
        _game = game;
        _player = player;
    }
    
    public Game getGame() {
        return _game;
    }
    
    public Player getPlayer() {
        return _player;
    }
    
    public List<Card> getCards() {
        return new ArrayList<Card>(_cards);
    }
    
    public List<Card> getSelectedCards() {
        return _selectedCards;
    }
    
    public void dealCard(Card card) {
        _cards.add(card);
        
        _notifyListeners();
    }
    
    public void selectCard(Card card) {
        _selectedCards.add(card);
        
        _notifyListeners();
    }
    
    public void unselectCard(Card card) {
        _selectedCards.remove(card);
        
        _notifyListeners();
    }
    
    public void addListener(Listener listener) {
        _listeners.add(listener);
    }
    
    public void removeListener(Listener listener) {
        _listeners.remove(listener);
    }
    
    public void removeSelectedCards() {
        _cards.removeAll(_selectedCards);
        
        _notifyListeners();
    }
    
    private void _notifyListeners() {
        for (Listener listener : _listeners) {
            listener.onPlayAreaUpdate(this);
        }
    }
    
    private final Game _game;
    private final Player _player;
    private final Set<Card> _cards = new TreeSet<Card>(CRIBBAGE_CARD_COMPARATOR);
    private final List<Card> _selectedCards = new ArrayList<Card>();
    private final List<Listener> _listeners = new ArrayList<Listener>();
    
    public static interface Listener {
        
        void onPlayAreaUpdate(PlayArea playArea);
        
    }
}
