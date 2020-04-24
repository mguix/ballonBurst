package org.academiadecodigo.bootcamp40.balloonBurst.balloon;

import org.academiadecodigo.bootcamp40.balloonBurst.grid.Grid;
import org.academiadecodigo.bootcamp40.balloonBurst.grid.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Balloon {

    private int rowStartPosition;
    private int colStartPosition;
    private GridPosition gridPosition;
    private BalloonType balloonType;
    private Picture picture;
    private boolean bursted;

    Balloon(GridPosition gridPosition, BalloonType balloonType, String balloonPicture, int colStartPosition, int rowStartPosition) {
        this.gridPosition = gridPosition;
        this.balloonType = balloonType;
        this.rowStartPosition = rowStartPosition;
        this.colStartPosition = colStartPosition;

        picture = new Picture(colStartPosition, rowStartPosition, balloonPicture);
    }

    public void checkBurst(){

        bursted = false;
        picture.translate(0, rowStartPosition);
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void explode(Grid grid) {
        bursted = true;
        picture.translate(0, grid.getRows() + (15 * Grid.getCellSize()));
    }

    public void move() {

        picture.translate(0, Grid.getCellSize() * balloonType.getSpeed() * -1);
        getGridPosition().setPos(picture.getX(), picture.getY());

        if (picture.getY() + picture.getHeight() <= 0) {
            bursted = true;
            checkBurst();
        }
    }

    public void draw() {
        picture.draw();
    }

    public int[] getPositionY(){
        return new int[]{picture.getY(), picture.getY() + picture.getHeight()};
    }

    public int getPositionX(){
        return  picture.getX();
    }
}
