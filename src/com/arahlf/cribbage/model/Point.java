package com.arahlf.cribbage.model;

/**
 * An immutable class representing a point.
 * 
 * @author arahlf
 */
public class Point {
    
    public Point(int x, int y) {
        _x = x;
        _y = y;
    }
    
    public int getX() {
        return _x;
    }
    
    public int getY() {
        return _y;
    }
    
    private final int _x;
    private final int _y;
}
