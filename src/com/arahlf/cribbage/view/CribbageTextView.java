package com.arahlf.cribbage.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

public class CribbageTextView extends TextView {

    public CribbageTextView(Context context) {
        super(context);
        
        setTextColor(Color.WHITE);
        setTextSize(16);
    }

}
