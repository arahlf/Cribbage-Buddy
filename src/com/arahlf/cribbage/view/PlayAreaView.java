package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.GameListener;
import com.arahlf.cribbage.model.PlayArea;

public class PlayAreaView extends RelativeLayout implements GameListener, PlayArea.Listener, OnClickListener {

    public PlayAreaView(Context context, PlayArea playArea, CardSelectionListener listener) {
        super(context);
        
        _context = context;
        _playArea = playArea;
        _playerTextView = new CribbageTextView(context);
        _scoreTextView = new CribbageTextView(context);
        _listener = listener;
        
        _playerTextView.setText(_playArea.getPlayer().getName());
        _updateScoreText();
        
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        
        _scoreTextView.setLayoutParams(params);
        
        setPadding(PADDING, PADDING, PADDING, PADDING);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 215));
        
        addView(_playerTextView);
        addView(_scoreTextView);
        
        _playArea.getGame().addListener(this);
        _playArea.addListener(this);
        
        _update();
    }
    
    @Override
    public void onScoreChange() {
        _updateScoreText();
    }
    
    @Override
    public void onPlayAreaUpdate(PlayArea playArea) {
        _update();
    }
    
    @Override
    public void onClick(View v) {
        if (_listener != null) {
            CardView cardView = (CardView) v;
            
            _listener.onCardSelected(cardView.getCard());
        }
    }
    
    public void showCards() {
        for (CardView cardView : _views) {
            cardView.setFaceUp(true);
        }
        
        _showCards = true;
    }
    
    private void _update() {
        for (CardView cardView : _views) {
            removeView(cardView);
        }
        
        _views.clear();
        
        List<Card> cards = _playArea.getCards();
        List<Card> selections = _playArea.getSelectedCards();
        
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            CardView cardView = new CardView(_context, card);
            
            LayoutParams cardParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            cardParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            cardParams.leftMargin = i * (CardView.WIDTH / 2);
            
            if (selections.contains(card)) {
                cardParams.bottomMargin = 20;
            }
            
            cardView.setLayoutParams(cardParams);
            cardView.setOnClickListener(this);
            cardView.setFaceUp(_showCards);
            
            _views.add(cardView);
            
            addView(cardView);
        }
    }
    
    private void _updateScoreText() {
        _scoreTextView.setText("Score: " + _playArea.getGame().getPlayerScore(_playArea.getPlayer()));
    }
    
    private boolean _showCards;
    
    private final Context _context;
    private final PlayArea _playArea;
    private final TextView _playerTextView;
    private final TextView _scoreTextView;
    private final CardSelectionListener _listener;
    private final List<CardView> _views = new ArrayList<CardView>();
    
    private static final int PADDING = 15;
}
