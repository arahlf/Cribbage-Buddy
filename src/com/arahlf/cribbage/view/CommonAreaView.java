package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.RelativeLayout;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.CommonArea;

public class CommonAreaView extends RelativeLayout {

    public CommonAreaView(Context context, CommonArea commonArea) {
        super(context);
        
        setPadding(PADDING, PADDING, PADDING, PADDING);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 200));
        
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        
        _context = context;
        _commonArea = commonArea;
        _cutCardView = new CardView(context, commonArea.getCutCard());
        _cutCardView.setLayoutParams(params);
        _cutCardView.setFaceUp(false);
        
        addView(_cutCardView);
    }
    
    public void update() {
        for (CardView cardView : _playedCards) {
            removeView(cardView);
        }
        
        List<Card> playedCards = _commonArea.getPlayStack().getCards();
        
        for (int i = 0; i < playedCards.size(); i++) {
            CardView cardView = new CardView(_context, playedCards.get(i));
            
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            params.leftMargin = (int) ((int) i * (CardView.WIDTH / 2) + CardView.WIDTH * 1.5);
            
            cardView.setLayoutParams(params);
            
            _playedCards.add(cardView);
            this.addView(cardView);
        }
    }
    
    public void showCut() {
        _cutCardView.setFaceUp(true);
    }
    
    private final Context _context;
    private final CommonArea _commonArea;
    private final CardView _cutCardView;
    private final List<CardView> _playedCards = new ArrayList<CardView>();
    private static final int PADDING = 15;
}
