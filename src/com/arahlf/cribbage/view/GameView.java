package com.arahlf.cribbage.view;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.arahlf.cribbage.R;
import com.arahlf.cribbage.model.Game;

public class GameView extends LinearLayout {
    
    public GameView(Context context, Game game, CardSelectionListener listener) {
        super(context);
        
        _game = game;
        _button = new CribbageButton(context);
        _commonArea = new CommonAreaView(context, _game.getCommonArea());
        _player1Area = new PlayAreaView(context, _game.getPlayArea1(), listener);
        _player2Area = new PlayAreaView(context, _game.getPlayArea2(), listener);
        
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.felt_bg));
        
        _button.setText("Play");
        
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        
        _button.setLayoutParams(params);
        _player1Area.addView(_button);
        
        addView(_player2Area);
        addView(_commonArea);
        addView(_player1Area);
    }
    
    public void setButtonListener(OnClickListener listener) {
        _button.setOnClickListener(listener);
    }
    
    public PlayAreaView getPlayAreaView1() {
        return _player1Area;
    }
    
    public PlayAreaView getPlayAreaView2() {
        return _player2Area;
    }
    
    public CommonAreaView getCommonAreaView() {
        return _commonArea;
    }
    
    private final Game _game;
    private final Button _button;
    private final CommonAreaView _commonArea;
    private final PlayAreaView _player1Area;
    private final PlayAreaView _player2Area;
}
