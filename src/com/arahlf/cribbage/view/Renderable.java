package com.arahlf.cribbage.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public interface Renderable {
    
    public void render(View view, Canvas canvas, Paint paint);
    
}
