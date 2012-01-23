package com.arahlf.cribbage;

import static com.arahlf.cribbage.CribbageUtils.getSuitOrder;

import java.util.List;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.arahlf.Card;
import com.arahlf.R;

public class CardRenderer {
    
    public CardRenderer(Resources resources) {
        _bitmap = BitmapFactory.decodeResource(resources, R.drawable.cards);
    }
    
    public void renderCards(List<Card> cards, Canvas canvas, Paint paint) {
        int offset = (canvas.getWidth() - (WIDTH * 5)) / 2;
        
        for (int i = 0; i < cards.size(); i++) {
            int x = cards.get(i).getFace().getOrdinal() * WIDTH - WIDTH;
            int y = getSuitOrder(cards.get(i).getSuit()) * HEIGHT - HEIGHT;
            
            Rect src = _createRect(x, y, WIDTH, HEIGHT);
            Rect dst = _createRect(i * WIDTH + offset, offset, WIDTH, HEIGHT);
            
            canvas.drawBitmap(_bitmap, src, dst, paint);
        }
    }
    
    private Rect _createRect(int x, int y, int width, int height) {
        return new Rect(x, y, x + width, y + height);
    }
    
    private final Bitmap _bitmap;
    
    private static final int WIDTH = 79;
    private static final int HEIGHT =  123;
}
