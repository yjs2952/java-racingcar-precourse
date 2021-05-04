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

    public boolean isSamePosition(int position) {
        return this.position.isSame(position);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return this.carName.getName();
    }

    public String drawPosition() {
        return position.draw();
    }
}
