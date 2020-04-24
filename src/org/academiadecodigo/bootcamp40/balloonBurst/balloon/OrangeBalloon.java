package org.academiadecodigo.bootcamp40.balloonBurst.balloon;

import org.academiadecodigo.bootcamp40.balloonBurst.grid.GridPosition;

public class OrangeBalloon extends Balloon {

    public OrangeBalloon(GridPosition gridPosition, int colStartPosition, int rowStartPosition) {
        super(gridPosition, BalloonType.ORANGE, BalloonType.ORANGE.getPicture(), colStartPosition, rowStartPosition);
    }
}
