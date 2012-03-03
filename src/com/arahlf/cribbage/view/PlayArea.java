package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arahlf.cribbage.R;
import com.arahlf.cribbage.model.Deck;
import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.model.GameListener;
import com.arahlf.cribbage.model.Player;

public class PlayArea extends RelativeLayout implements GameListener {

    public PlayArea(Context context, Game game, Player player) {
        super(context);
        
        _game = game;
        _player = player;
        _button = new CribbageButton(context);
        _playerTextView = new CribbageTextView(context);
        _scoreTextView = new CribbageTextView(context);
        
        _button.setText("Play");
        _playerTextView.setText(_player.getName());
        _updateScoreText();
        
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        
        LayoutParams params2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        
        _button.setLayoutParams(params2);
        _scoreTextView.setLayoutParams(params);
        
        setPadding(PADDING, PADDING, PADDING, PADDING);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.felt_bg));
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 250));
        
        addView(_button);
        addView(_playerTextView);
        addView(_scoreTextView);
        
        _button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                _locked = true;
                
                _removeSelections();
                
                for (CardView cardView : _views) {
                    cardView.setFaceUp(true);
                }
            }
        });
        
        _game.addListener(this);
        
        
        
        Deck deck = new Deck();
        deck.shuffle();
        
        for (int i = 0; i < 6; i++) {
            CardView cardView = new CardView(context, deck.dealCard());
            
            LayoutParams cardParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            cardParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            cardParams.leftMargin = i * (CardView.WIDTH / 2);
            
            cardView.setLayoutParams(cardParams);
            cardView.setFaceUp(false);
            
            _views.add(cardView);
            
            cardView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!_locked) {
                        CardView selectedCardView = (CardView) v;
                        
                        if (_selections.contains(selectedCardView)) {
                            _selections.remove(selectedCardView);
                        }
                        else if (_selections.size() < 2) {
                            _selections.add(selectedCardView);
                        }
                        
                        _updateMargins();
                    }
                }
            });
            
            addView(cardView);
        }
    }
    
    @Override
    public void onScoreChange() {
        _updateScoreText();
    }
    
    private void _updateScoreText() {
        _scoreTextView.setText("Score: " + _game.getPlayer1Score());
    }
    
    private void _updateMargins() {
        for (int i = 0; i < _views.size(); i++) {
            CardView cardView = _views.get(i);
            
            LayoutParams params = (LayoutParams) cardView.getLayoutParams();
            
            params.leftMargin = i * (CardView.WIDTH / 2);
            
            if (_selections.contains(cardView)) {
                params.bottomMargin = 20;
            }
            else {
                params.bottomMargin = 0;
            }
            
            cardView.setLayoutParams(params);
        }
        
        invalidate();
    }
    
    private void _removeSelections() {
        for (CardView selection : _selections) {
            _views.remove(selection);
            removeView(selection);
        }
        
        _selections.clear();
        _updateMargins();
    }
    
    private boolean _locked = false;
    private final Game _game;
    private final Player _player;
    private final CribbageButton _button;
    private final TextView _playerTextView;
    private final TextView _scoreTextView;
    
    private final List<CardView> _selections = new ArrayList<CardView>();
    private final List<CardView> _views = new ArrayList<CardView>();
    
    private static final int PADDING = 15;
}
