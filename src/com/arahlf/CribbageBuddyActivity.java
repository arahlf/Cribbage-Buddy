package com.arahlf;

import static com.arahlf.cribbage.CribbageUtils.getTotalPoints;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.arahlf.cribbage.CardRenderer;
import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.hands.Hand;
import com.arahlf.cribbage.rules.hand.CribbagHandScoreRules;

public class CribbageBuddyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Create a LinearLayout in which to add the ImageView
        LinearLayout mLinearLayout = new LinearLayout(this);


        // Add the ImageView to the layout and set the layout as the content view
        mLinearLayout.addView(new CribbageView(this));
        setContentView(mLinearLayout);

    }
}

class CribbageView extends View {
    public CribbageView(Context context) {
        super(context);
        
        _buildHand();
        
        _cardRenderer = new CardRenderer(this.getResources());
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // make the entire canvas white
        paint.setColor(Color.rgb(30, 115, 30));
        canvas.drawPaint(paint);
        
        _cardRenderer.renderCards(_hand.getCards(), canvas, paint);
        
        paint.setAntiAlias(true);
        paint.setTextSize(24);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setColor(Color.WHITE);
        
        int offset = 72, start = 225;
        
        List<Score> scores = new CribbagHandScoreRules().scoreHand(_hand);
        
        for (int i = 0; i < scores.size(); i++) {
            start += 28;
            canvas.drawText(scores.get(i).toString(), offset, start, paint);
        }
        
        canvas.drawText("Total: " + getTotalPoints(scores), offset, start + 56, paint);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            _buildHand();
            invalidate();
            return true;
        }
        
        return false;
    }
    
    private void _buildHand() {
        Deck deck = new Deck();
        deck.shuffle();
        
        _hand = new Hand(deck.getNextCard(), deck.getNextCard(), deck.getNextCard(), deck.getNextCard(), deck.getNextCard());
    }
    
    private Hand _hand;
    private final CardRenderer _cardRenderer;
}