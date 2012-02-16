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

import com.arahlf.cribbage.controller.GameController;
import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.model.Player;

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
        
        Player user = new Player("User");
        Player computer = new Player("Computer");
        Game game = new Game(user, computer);
        
        _gameController = new GameController(game);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        
        paint.setColor(Color.rgb(30, 115, 30));
        canvas.drawPaint(paint);
        
        paint.setAntiAlias(true);
        paint.setTextSize(24);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setColor(Color.WHITE);
        
        _gameController.renderViews(canvas, paint);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
           boolean handled = _gameController.handleTapEvent((int) event.getX(), (int) event.getY());
           
           if (handled) {
               invalidate();
           }
        }
        
        return false;
    }
    
    private final GameController _gameController;
}