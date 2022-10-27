package fr.ensicaen.elgama.model.sailboat;

public class SailboatPolar {
    private final PolarReader polarReader;

    public SailboatPolar( PolarReader.PolarType polarType) {
        polarReader = new PolarReader( polarType );
    }

    public double getMaxSpeed(double angle, float windStrength ) {
        int strengthRounded;
        if (windStrength > 30) {
            strengthRounded = 30;
        } else if (windStrength < 4) {
            strengthRounded = 4;
        } else {
            strengthRounded = Math.round(windStrength / 2) * 2;
        }
        int strengthIndex = strengthRounded / 2 - 2;
        int angleRounded = (int) Math.round(angle / 10) * 10;
        int angleIndex = angleRounded / 10;
        double[][] data = polarReader.loadData();
        return data[angleIndex][strengthIndex];
    }
}
