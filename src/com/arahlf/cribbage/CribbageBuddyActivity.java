package com.arahlf.cribbage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.arahlf.cribbage.ai.Tracy;
import com.arahlf.cribbage.controller.GameController;
import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.model.Player;

public class CribbageBuddyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bitmap cardImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.cards);
        Images.setCardImage(cardImage);
        
        
        Player player1 = new Player("Alan");
        Player player2 = new Player("Tracy (Computer)");
        Game game = new Game(player1, player2);
        
        GameController controller = new GameController(this, game, new Tracy());
        
//        Game game = new Game();
//        game.changeState(new MenuState(this));
//        
//        setContentView(game.getGameState().getView());
    }
}