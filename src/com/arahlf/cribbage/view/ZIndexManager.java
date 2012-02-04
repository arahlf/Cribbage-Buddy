package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

public class ZIndexManager {
    
    public void addTappable(Tappable tappable) {
        _tappables.add(tappable);
    }
    
    public boolean notifyTapEvent(int x, int y) {
        for (int i = _tappables.size() - 1; i >= 0; i--) {
            if (_tappables.get(i).handleTap(x, y)) {
                return true;
            }
        }
        return false;
    }
    
    private final List<Tappable> _tappables = new ArrayList<Tappable>();
}
