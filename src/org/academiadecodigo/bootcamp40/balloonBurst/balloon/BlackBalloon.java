package org.academiadecodigo.bootcamp40.balloonBurst.balloon;

import org.academiadecodigo.bootcamp40.balloonBurst.grid.GridPosition;


public class BlackBalloon extends Balloon {

    BlackBalloon(GridPosition gridPosition, int colStartPosition, int rowStartPosition) {
        super(gridPosition, BalloonType.BLACK, BalloonType.BLACK.getPicture(), colStartPosition, rowStartPosition);
    }
}
