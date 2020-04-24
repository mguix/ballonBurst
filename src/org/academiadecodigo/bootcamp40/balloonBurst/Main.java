package org.academiadecodigo.bootcamp40.balloonBurst;

public class Main {

    public static void main (String[]args) throws InterruptedException {

        Game game = new Game(120, 80);

        game.init();
        game.start();
    }
}
