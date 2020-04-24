package org.academiadecodigo.bootcamp40.balloonBurst.balloon;

import org.academiadecodigo.bootcamp40.balloonBurst.grid.GridPosition;


public class PinkBalloon extends Balloon {

    PinkBalloon(GridPosition gridPosition, int colStartPosition, int rowStartPosition) {
        super(gridPosition, BalloonType.PINK, BalloonType.PINK.getPicture(), colStartPosition, rowStartPosition);
    }
}
