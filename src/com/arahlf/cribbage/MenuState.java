package com.arahlf.cribbage;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.arahlf.cribbage.view.CribbageButton;

public class MenuState extends GameState {
    
    public MenuState(Context context) {
        _layout = new RelativeLayout(context);
        
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 200;
        
        Button startButton = new CribbageButton(context);
        startButton.setText("Start");
        startButton.setLayoutParams(params);
        
        _layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.felt_bg));
        _layout.addView(startButton);
    }
    
    @Override
    public View getView() {
        return _layout;
    }
    
    private final RelativeLayout _layout;
}
