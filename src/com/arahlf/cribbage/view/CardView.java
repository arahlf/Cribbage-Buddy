package com.arahlf.cribbage.view;

import static com.arahlf.cribbage.CribbageUtils.getSuitOrder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.arahlf.cribbage.Images;
import com.arahlf.cribbage.model.Card;

public class CardView extends View {
    
    public CardView(Context context, Card card) {
        super(context);
        
        _card = card;
    }
    
    public Card getCard() {
        return _card;
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        
        int spriteX, spriteY;
        
        if (_faceUp) {
            spriteX = _card.getRank().getOrdinal() * WIDTH - WIDTH;
            spriteY = getSuitOrder(_card.getSuit()) * HEIGHT - HEIGHT;
        }
        else {
            spriteX = 2 * WIDTH;
            spriteY = 4 * HEIGHT;
        }
        
        Rect src = new Rect(spriteX, spriteY, spriteX + WIDTH, spriteY + HEIGHT);
        Rect dst = new Rect(0, 0, WIDTH, HEIGHT);
        
        canvas.drawBitmap(Images.getCardImage(), src, dst, paint);
    }
    
    public void setFaceUp(boolean faceUp) {
        _faceUp = faceUp;
        invalidate();
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(WIDTH, HEIGHT);
    }
    
    public static final int WIDTH = 79;
    public static final int HEIGHT =  123;
    
    private boolean _faceUp = true;
    private final Card _card;
}
