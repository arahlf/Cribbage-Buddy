package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.CommonArea;
import com.arahlf.cribbage.model.PlayStack;
import com.arahlf.cribbage.model.PlayStack.PlayStackListener;

public class CommonAreaView extends RelativeLayout implements PlayStackListener {

    public CommonAreaView(Context context, CommonArea commonArea) {
        super(context);
        
        setPadding(PADDING, PADDING, PADDING, PADDING);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 215));
        
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        
        _countTextView = new CribbageTextView(context);
        _dealerTextView = new CribbageTextView(context);
        
        _context = context;
        _commonArea = commonArea;
        _cutCardView = new CardView(context, commonArea.getCutCard());
        _cutCardView.setLayoutParams(params);
        _cutCardView.setFaceUp(false);
        
        commonArea.getPlayStack().addListener(this);
        
        params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        
        _countTextView.setLayoutParams(params);
        
        _countTextView.setText("Count: 0");
        _dealerTextView.setText("Alan's Crib");
        
        addView(_countTextView);
        addView(_cutCardView);
        addView(_dealerTextView);
    }
    
    public void update() {
        for (CardView cardView : _playedCards) {
            removeView(cardView);
        }
        
        List<Card> playedCards = _commonArea.getPlayStack().getCards();
        
        for (int i = 0; i < playedCards.size(); i++) {
            CardView cardView = new CardView(_context, playedCards.get(i));
            
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.leftMargin = (int) ((int) i * (CardView.WIDTH / 2) + CardView.WIDTH * 1.5);
            
            cardView.setLayoutParams(params);
            
            _playedCards.add(cardView);
            addView(cardView);
        }
    }
    
    @Override
    public void onPlayStackUpdate(PlayStack playStack) {
        _countTextView.setText("Count: " + playStack.getPipCount());
    }
    
    public void showCut() {
        _cutCardView.setFaceUp(true);
    }
    
    private final Context _context;
    private final CommonArea _commonArea;
    private final CardView _cutCardView;
    private final List<CardView> _playedCards = new ArrayList<CardView>();
    private final TextView _countTextView;
    private final TextView _dealerTextView;
    private static final int PADDING = 15;
}
