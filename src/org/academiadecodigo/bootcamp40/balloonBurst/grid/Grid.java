package org.academiadecodigo.bootcamp40.balloonBurst.grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    private static final int PADDING = 10;
    private static final int CELL_SIZE = 10;

    private int cols;
    private int rows;
    private Picture pictureBackground;

    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;

        pictureBackground = new Picture(PADDING, PADDING, "resources/background.jpeg");
        pictureBackground.draw();
    }

    public Picture getPictureBackground(){
        return pictureBackground;
    }


    public void init() {
        Rectangle rectangleGrid = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        rectangleGrid.setColor(Color.BLACK);
        rectangleGrid.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return cols * CELL_SIZE;
    }

    public int getHeight() {
        return rows * CELL_SIZE;
    }

    public static int getCellSize() {
        return CELL_SIZE;
    }

    public static int getPadding(){
        return PADDING;
    }

    public GridPosition makeGridPosition(int col, int row) {
        return new GridPosition(col, row, this);
    }

}
