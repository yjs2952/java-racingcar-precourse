package domain;

public class Trace {
    private final CarName carName;
    private final Position position;

    private Trace(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public static Trace of(CarName carName, Position position) {
        return new Trace(carName, position);
    }

    public int getPosition() {
        return position.getPosition();
    }
}
