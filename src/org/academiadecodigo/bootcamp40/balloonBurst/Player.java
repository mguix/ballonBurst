package org.academiadecodigo.bootcamp40.balloonBurst;

import org.academiadecodigo.bootcamp40.balloonBurst.grid.Grid;
import org.academiadecodigo.bootcamp40.balloonBurst.grid.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private static final int SPEED = 2;
    private static final int INITIAL_COL = 6;

    private Picture picture;
    private GridPosition gridPosition;

    public Player(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
        picture = new Picture(gridPosition.getCol() * Grid.getCellSize(), gridPosition.getRow() * Grid.getCellSize(), "resources/Arrow.png");
    }

    public void shoot() {
        picture.translate(SPEED * Grid.getCellSize(), 0);
        gridPosition.setPos(picture.getX(), picture.getY());
    }

    public void arrowReset() {
        gridPosition.setPos(INITIAL_COL, picture.getY());
        picture.translate(gridPosition.getCol() * Grid.getCellSize() - picture.getX(), 0);
        picture.draw();
    }

    public  int getArrowPositionX(){
        return  picture.getX() + picture.getWidth();
    }

    public int getArrowPositionY(){
        return picture.getY() + (picture.getHeight()/2);
    }

    public Picture getPicture(){
        return picture;
    }

    public int getSpeed(){
        return SPEED;
    }
}