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
import com.arahlf.cribbage.hands.Hand;
import com.arahlf.cribbagebuddy.R;

public class CardRenderer {
    
    public CardRenderer(Resources resources) {
        _bitmap = BitmapFactory.decodeResource(resources, R.drawable.cards);
    }
    
    public void renderCards(Hand hand, Canvas canvas, Paint paint) {
        List<Card> cards = hand.getCardsWithoutCut();
        cards.add(hand.getCut());
        
        int offset = (canvas.getWidth() - CUT_OFFSET - (WIDTH * 5)) / 2;
        
        for (int i = 0; i < cards.size(); i++) {
            int x = cards.get(i).getFace().getOrdinal() * WIDTH - WIDTH;
            int y = getSuitOrder(cards.get(i).getSuit()) * HEIGHT - HEIGHT;
            
            Rect src = _createRect(x, y, WIDTH, HEIGHT);
            
            int dstX = i * WIDTH + offset;
            
            if (i == 4) {
                dstX += CUT_OFFSET;
            }
            
            Rect dst = _createRect(dstX, offset, WIDTH, HEIGHT);
            
            canvas.drawBitmap(_bitmap, src, dst, paint);
        }
    }
    
    private Rect _createRect(int x, int y, int width, int height) {
        return new Rect(x, y, x + width, y + height);
    }
    
    private final Bitmap _bitmap;
    
    private static final int CUT_OFFSET = 50;
    private static final int WIDTH = 79;
    private static final int HEIGHT =  123;
}
