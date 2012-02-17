package com.arahlf.cribbage.view;

import static com.arahlf.cribbage.CribbageUtils.getSuitOrder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.arahlf.cribbage.Images;
import com.arahlf.cribbage.model.Card;

public class CardView implements Tappable, Renderable {
    
    public CardView(int x, int y, Card card) {
        _x = x;
        _y = y;
        
        if (card != null) {
            _spriteX = card.getRank().getOrdinal() * WIDTH - WIDTH;
            _spriteY = getSuitOrder(card.getSuit()) * HEIGHT - HEIGHT;
        }
        else {
            _spriteX = 2 * WIDTH;
            _spriteY = 4 * HEIGHT;
        }
        
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
    public void render(Canvas canvas, Paint paint) {
        
        
        Rect src = new Rect(_spriteX, _spriteY, _spriteX + WIDTH, _spriteY + HEIGHT);
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
    
    public static final int WIDTH = 79;
    public static final int HEIGHT =  123;
    
    private int _x;
    private int _y;
    private final int _spriteX;
    private final int _spriteY;
    private final Card _card;
    private CardTapListener _tapListener;
}
