package com.arahlf.cribbage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.arahlf.cribbage.model.Deck;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.view.HandView;

public class CribbageBuddyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Create a LinearLayout in which to add the ImageView
        LinearLayout mLinearLayout = new LinearLayout(this);
        
        Bitmap cardImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.cards);
        Images.setCardImage(cardImage);
        
        // Add the ImageView to the layout and set the layout as the content view
        mLinearLayout.addView(new CribbageView(this));
        setContentView(mLinearLayout);
    }
}

class CribbageView extends View {
    public CribbageView(Context context) {
        super(context);
        
        Deck deck = new Deck();
        deck.shuffle();
        
        _hand = new Hand(deck.getNextCard(), deck.getNextCard(), deck.getNextCard(), deck.getNextCard(), deck.getNextCard());
        _handView = new HandView(_hand);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // make the entire canvas white
        paint.setColor(Color.rgb(30, 115, 30));
        canvas.drawPaint(paint);
        
        paint.setAntiAlias(true);
        paint.setTextSize(24);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setColor(Color.WHITE);
        
        _handView.render(10, 10, canvas, paint);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
        }
        
        return false;
    }
    
    private final Hand _hand;
    private final HandView _handView;
}