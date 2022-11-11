package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;

public abstract class Wind {
    public static double windDirectionAngle(Point2D windDir) {
        javafx.geometry.Point2D imageDirection = new javafx.geometry.Point2D(1, 0);
        javafx.geometry.Point2D newWindDirection = new javafx.geometry.Point2D(windDir.getX(), windDir.getY());
        double sign = Math.signum(newWindDirection.crossProduct(imageDirection).getZ());
        return -Math.copySign(imageDirection.angle(newWindDirection), sign);
    }

    public abstract float getWindStrength();

    public abstract double getWindDirectionDouble();

    public abstract Point2D getWindDirectionPoint2D();
}
