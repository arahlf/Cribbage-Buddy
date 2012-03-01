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
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.arahlf.cribbage.controller.GameController;
import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.model.Player;
import com.arahlf.cribbage.view.CribbageButton;

public class CribbageBuddyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        RelativeLayout layout = new RelativeLayout(this);
        
        Bitmap cardImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.cards);
        Images.setCardImage(cardImage);
        
        setContentView(layout);
        
        Button button = new CribbageButton(this);
        button.setText("OK");
        
        layout.addView(new CribbageView(this));
        layout.addView(button);
        
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.setMargins(0, 165, 15, 0);
        
        button.setLayoutParams(params);
    }
}

class CribbageView extends View {
    public CribbageView(Context context) {
        super(context);
        
        setBackgroundDrawable(this.getResources().getDrawable(R.drawable.felt_bg));
        
        Player user = new Player("Alan");
        Player computer = new Player("Computer");
        Game game = new Game(user, computer);
        
        _gameController = new GameController(context, game);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        
        paint.setAntiAlias(true);
        paint.setTextSize(24);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setColor(Color.WHITE);
        
        _gameController.render(this, canvas, paint);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
           boolean handled = _gameController.handleTapEvent((int) event.getX(), (int) event.getY());
           
           if (handled) {
               invalidate();
           }
           
           return handled;
        }
        
        return false;
    }
    
    private final GameController _gameController;
}