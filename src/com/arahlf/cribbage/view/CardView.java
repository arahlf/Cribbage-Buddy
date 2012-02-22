package com.arahlf.cribbage.view;

import static com.arahlf.cribbage.CribbageUtils.getSuitOrder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.arahlf.cribbage.Images;
import com.arahlf.cribbage.model.Card;

public class CardView implements Tappable, Renderable {
    
    public CardView(int x, int y, Card card) {
        _x = x;
        _y = y;
        _card = card;
    }
    
    @Override
    public boolean handleTap(int x, int y) {
        if (new Rect(_x, _y, _x + WIDTH, _y + HEIGHT).contains(x, y)) {
            if (_tapListener != null) {
                _tapListener.onCardTapped(this);
            }
            
            return true;
        }
        return false;
    }
    
    @Override
    public void render(View view, Canvas canvas, Paint paint) {
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
        Rect dst = new Rect(_x, _y, _x + WIDTH, _y + HEIGHT);
        
        canvas.drawBitmap(Images.getCardImage(), src, dst, paint);
    }
    
    public void setTapListener(CardTapListener tapListener) {
        _tapListener = tapListener;
    }
    
    public int getX() {
        return _x;
    }
    
    public void setX(int x) {
        _x = x;
    }
    
    public int getY() {
        return _y;
    }
    
    public void setY(int y) {
        _y = y;
    }
    
    public Card getCard() {
        return _card;
    }
    
    public void setFaceUp(boolean faceUp) {
        _faceUp = faceUp;
    }
    
    public static final int WIDTH = 79;
    public static final int HEIGHT =  123;
    
    private int _x;
    private int _y;
    private boolean _faceUp = true;
    private final Card _card;
    private CardTapListener _tapListener;
}
