package com.arahlf.cribbage.view;

import com.arahlf.cribbage.R;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.widget.Button;

public class CribbageButton extends Button {
    
    public CribbageButton(Context context) {
        super(context);
        
        setTextSize(16);
        
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[] { android.R.attr.state_pressed }, getResources().getDrawable(R.drawable.button_pressed));
        states.addState(new int[] { }, getResources().getDrawable(R.drawable.button_enabled));
        setBackgroundDrawable(states);
    }
    
}
