package org.academiadecodigo.bootcamp40.balloonBurst.balloon;

import org.academiadecodigo.bootcamp40.balloonBurst.grid.Grid;

public class BalloonFactory {

    public static Balloon getNewBalloon (Grid grid) {
        final int MAX_COL_VALUE = grid.getCols() - 5;
        final int MIN_COL_VALUE = grid.getCols() - 50;
        final int MAX_ROW_VALUE = grid.getRows() - 20;
        final int MIN_ROW_VALUE = grid.getRows() - 5;

        int colStartPosition = (int) (Math.random() * (MAX_COL_VALUE - MIN_COL_VALUE + 1) + MIN_COL_VALUE) * Grid.getCellSize();
        int rowStartPosition = (int) (Math.random() * (MAX_ROW_VALUE - MIN_ROW_VALUE + 1) + MIN_ROW_VALUE) * Grid.getCellSize();

        switch (BalloonType.random()){
            case PINK:
                return new PinkBalloon(grid.makeGridPosition(colStartPosition, rowStartPosition), colStartPosition, rowStartPosition);
            case PURPLE:
                return new PurpleBalloon(grid.makeGridPosition(colStartPosition, rowStartPosition), colStartPosition, rowStartPosition);
            case ORANGE:
                return new OrangeBalloon(grid.makeGridPosition(colStartPosition, rowStartPosition), colStartPosition, rowStartPosition);
            case BLACK:
                return new BlackBalloon(grid.makeGridPosition(colStartPosition, rowStartPosition), colStartPosition, rowStartPosition);
        }

        return null;
    }
}
