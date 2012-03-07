package com.arahlf.cribbage.view;

import android.content.Context;
import android.widget.RelativeLayout;

import com.arahlf.cribbage.model.CommonArea;

public class CommonAreaView extends RelativeLayout {

    public CommonAreaView(Context context, CommonArea commonArea) {
        super(context);
        
        setPadding(PADDING, PADDING, PADDING, PADDING);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 200));
        
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        
        _cardView = new CardView(context, commonArea.getCutCard());
        _cardView.setLayoutParams(params);
        _cardView.setFaceUp(false);
        
        addView(_cardView);
    }
    
    public void showCut() {
        _cardView.setFaceUp(true);
    }
    
    private final CardView _cardView;
    private static final int PADDING = 15;
}
