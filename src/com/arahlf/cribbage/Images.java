package com.arahlf.cribbage;

import android.graphics.Bitmap;

public class Images {
    
    public static synchronized Bitmap getCardImage() {
        return _cardImage;
    }
    
    public static synchronized void setCardImage(Bitmap cardImage) {
        _cardImage = cardImage;
    }
    
    private static Bitmap _cardImage;
}
