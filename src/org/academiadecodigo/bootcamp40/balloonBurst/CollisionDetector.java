package org.academiadecodigo.bootcamp40.balloonBurst;

import org.academiadecodigo.bootcamp40.balloonBurst.balloon.Balloon;
import org.academiadecodigo.bootcamp40.balloonBurst.balloon.BalloonType;
import org.academiadecodigo.bootcamp40.balloonBurst.balloon.BlackBalloon;
import org.academiadecodigo.bootcamp40.balloonBurst.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {
    private Balloon[] balloons;
    private Player player;
    private Game game;
    private Picture picture;

    public CollisionDetector(Balloon[] balloons, Player player, Game game) {
        this.balloons = balloons;
        this.player = player;
        this.game = game;
    }

    public void checkHit(Grid grid){

        for(Balloon b : balloons){

            if((player.getArrowPositionX() - b.getPositionX() >= 0
                 && player.getArrowPositionX() - b.getPositionX() <= 20)
                    && player.getArrowPositionY() >= b.getPositionY()[0]
                && player.getArrowPositionY() <= b.getPositionY()[1]){
                b.explode(grid);

                if(b instanceof BlackBalloon){
                    picture = new Picture(10,10, "resources/GameOver.jpeg");
                    picture.draw();
                    game.setGameOverTrue();

                }
            }
        }
    }

    public void deleteGameOverPicture() {
        picture.delete();
    }
}
