package org.academiadecodigo.bootcamp40.balloonBurst.balloon;

public enum BalloonType {
    PINK(5, 0.2, "resources/PinkBalloon.png"),
    PURPLE(10, 0.3, "resources/PurpleBalloon.png"),
    ORANGE(15, 0.4, "resources/OrangeBalloon.png"),
    BLACK(-1, 0.2, "resources/BlackBalloon.png");

    private int points;
    private double speed;
    private String picture;

    BalloonType(int points, double speed, String picture) {
        this.points = points;
        this.speed = speed;
        this.picture = picture;
    }

    public int getPoints() {
        return points;
    }

    public double getSpeed() {
        return speed;
    }

    public String getPicture() {
        return picture;
    }

    public static BalloonType random () {
        return BalloonType.values()[(int) (Math.random() * BalloonType.values().length)];
    }
}
