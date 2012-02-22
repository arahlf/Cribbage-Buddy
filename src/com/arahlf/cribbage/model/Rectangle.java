package com.arahlf.cribbage.model;

import android.graphics.Rect;

/**
 * An immutable representation of a Rectangle.  Android provides a similar class,
 * the constructor does not accept width/height and it is also not immutable.
 * 
 * @author arahlf
 */
public class Rectangle {
    
    public Rectangle(int x, int y, int width, int height) {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }
    
    public int getX() {
        return _x;
    }
    
    public int getY() {
        return _y;
    }
    
    public int getWidth() {
        return _width;
    }
    
    public int getHeight() {
        return _height;
    }
    
    public Rect asRect() {
        return new Rect(_x, _y, _x + _width, _y + _height);
    }
    
    private final int _x;
    private final int _y;
    private final int _width;
    private final int _height;
}
