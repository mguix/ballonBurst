package org.academiadecodigo.bootcamp40.balloonBurst.balloon;

import org.academiadecodigo.bootcamp40.balloonBurst.grid.GridPosition;

public class PurpleBalloon extends Balloon {

    public PurpleBalloon(GridPosition gridPosition, int colStartPosition, int rowStartPosition) {
        super(gridPosition, BalloonType.PURPLE, BalloonType.PURPLE.getPicture(), colStartPosition, rowStartPosition);
    }
}
