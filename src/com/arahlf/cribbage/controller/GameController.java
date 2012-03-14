package com.arahlf.cribbage.controller;

import static com.arahlf.cribbage.CribbageUtils.getTotalPoints;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import com.arahlf.cribbage.ai.Difficulty;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayArea;
import com.arahlf.cribbage.rules.hand.CribbagHandScoringRules;
import com.arahlf.cribbage.view.CardSelectionListener;
import com.arahlf.cribbage.view.GameView;

public class GameController implements CardSelectionListener {
    
    public GameController(Context context, Game game, Difficulty difficulty) {
        _game = game;
        _difficulty = difficulty;
        _gameView = new GameView(context, _game, this);
        
        ((Activity) context).setContentView(_gameView);
        
        _gameView.getPlayAreaView1().showCards();
        
        _gameView.setButtonListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_game.getPlayArea1().getSelectedCards().size() == 2) {
                    _game.getPlayArea1().removeSelectedCards();
                    _gameView.getPlayAreaView2().showCards(); // move this into the model
                    _gameView.getCommonAreaView().showCut();
                    
                    // remove a few cards from the computer's hand
                    PlayArea playArea = _game.getPlayArea2();
                    List<Card> cards = playArea.getCards();
                    playArea.selectCard(cards.get(0));
                    playArea.selectCard(cards.get(1));
                    _game.getPlayArea2().removeSelectedCards();
                    
                    // score ze hands!
                    Card cut = _game.getCommonArea().getCutCard();
                    List<Card> cards1 = _game.getPlayArea1().getCards();
                    List<Card> cards2 = _game.getPlayArea2().getCards();
                    
                    Hand hand1 = new Hand(cut, cards1.get(0), cards1.get(1), cards1.get(2), cards1.get(3));
                    Hand hand2 = new Hand(cut, cards2.get(0), cards2.get(1), cards2.get(2), cards2.get(3));
                    
                    CribbagHandScoringRules rules = new CribbagHandScoringRules();
                    
                    _game.addPoints(_game.getPlayer1(), getTotalPoints(rules.scoreHand(hand1)));
                    _game.addPoints(_game.getPlayer2(), getTotalPoints(rules.scoreHand(hand2)));
                }
            }
        });
    }
    
    @Override
    public void onCardSelected(Card card) {
        PlayArea playArea = _game.getPlayArea1();
        
        List<Card> selectedCards = playArea.getSelectedCards();
        
        if (selectedCards.contains(card)) {
            playArea.unselectCard(card);
        }
        else if (selectedCards.size() < 2) {
            playArea.selectCard(card);
        }
    }
    
    private final Difficulty _difficulty;
    private final Game _game;
    private final GameView _gameView;
}
