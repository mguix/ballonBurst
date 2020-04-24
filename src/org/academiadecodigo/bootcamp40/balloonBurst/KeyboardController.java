package org.academiadecodigo.bootcamp40.balloonBurst;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardController implements KeyboardHandler {

    private Game game;
    private CollisionDetector collisionDetector;

    public KeyboardController(Game game, CollisionDetector collisionDetector){
        this.game = game;
        this.collisionDetector = collisionDetector;
        keyboardInit();
    }

    private void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spacePressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (!game.isInit()){
                if(game.gameOver()) {
                    collisionDetector.deleteGameOverPicture();
                    game.setGameOverFalse();
                }
                game.gameBackground();
                game.setStartToTrue();

            } else {
                game.isShoot(true);
            }
        }



    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}