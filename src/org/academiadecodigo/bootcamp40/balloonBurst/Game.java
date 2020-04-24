package org.academiadecodigo.bootcamp40.balloonBurst;

import org.academiadecodigo.bootcamp40.balloonBurst.balloon.Balloon;
import org.academiadecodigo.bootcamp40.balloonBurst.balloon.BalloonFactory;
import org.academiadecodigo.bootcamp40.balloonBurst.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private static final int BALLOON_QTD = 20;

    private int delay;
    private boolean init;
    private boolean start;
    private boolean shoot;
    private Grid grid;
    private Player player;
    private Balloon[] balloons;
    private Picture gameBackground;
    private Picture startMenu;
    private CollisionDetector collisionDetector;
    private boolean gameOver;

    public Game(int cols, int rows) {

        this.startMenu = new Picture (10, 10, "resources/StartMenu.jpeg");
        this.gameBackground = new Picture(10, 10, "resources/background.jpeg");
        this.delay = 30;
        this.init = false;
        this.start = false;
        this.shoot = false;

        grid = new Grid(cols, rows);


    }

    public void gameBackground() {
        gameBackground.draw();
    }

    public void init() {
        startMenu.draw();

        player = new Player(grid.makeGridPosition(9, 45));
        balloons = new Balloon[BALLOON_QTD];
        collisionDetector = new CollisionDetector(balloons, player, this);

        KeyboardController keyboardController = new KeyboardController(this, collisionDetector);


        for (int i = 0; i < balloons.length; i++) {
            balloons[i] = BalloonFactory.getNewBalloon(grid);
        }

        grid.init();
    }

    public void start() throws InterruptedException {

        while (true) {
            Thread.sleep(delay);
            if (!start) {
                continue;
            }

            startMenu.delete();

            for (Balloon balloon : balloons) {
                balloon.move();
                balloon.draw();
                collisionDetector.checkHit(grid);
            }

            player.getPicture().draw();

            if (shoot) {
                checkLimit();
                if (shoot) {
                    player.shoot();
                }
            }
        }
    }

    private void checkLimit() {
        if (player.getPicture().getX() + player.getPicture().getWidth() + player.getSpeed() * Grid.getCellSize() > grid.getPictureBackground().getWidth() - 10) {
            shoot = false;
            player.arrowReset();
        }
    }

    public void isShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public void setStartToTrue() {
        this.start = true;
    }

    public boolean gameOver () {
        return this.gameOver;
    }

    public void setGameOverFalse () {

        gameOver = false;
    }

    public void setGameOverTrue(){
        this.gameOver = true;
    }


    public void setStartToFalse(){
        this.start = false;
    }

    public boolean isInit() {
        return this.start;
    }
}