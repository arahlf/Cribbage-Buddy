package com.arahlf.cribbage.view;

import static com.arahlf.cribbage.CribbageUtils.getSuitOrder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.arahlf.cribbage.Images;
import com.arahlf.cribbage.model.Card;

public class CardView implements Renderable {
    
    public CardView(Card card) {
        _card = card;
        _bitmap = Images.getCardImage();
    }
    
    @Override
    public void render(int x, int y, Canvas canvas, Paint paint) {
        int spriteX = _card.getFace().getOrdinal() * WIDTH - WIDTH;
        int spriteY = getSuitOrder(_card.getSuit()) * HEIGHT - HEIGHT;
        
        Rect src = new Rect(spriteX, spriteY, spriteX + WIDTH, spriteY + HEIGHT);
        Rect dst = new Rect(x, y, x + WIDTH, y + HEIGHT);
        
        canvas.drawBitmap(_bitmap, src, dst, paint);
    }
    
    public static final int WIDTH = 79;
    public static final int HEIGHT =  123;
    
    private final Bitmap _bitmap;
    private final Card _card;
}
