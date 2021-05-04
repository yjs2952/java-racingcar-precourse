package domain;

public class Car {
    public static final int DEFAULT_POSITION = 0;
    private final CarName carName;
    private final Position position;

    private Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car of(String carName, int position) {
        return new Car(CarName.of(carName), Position.of(position));
    }

    public static Car of(String carName) {
        return new Car(CarName.of(carName), Position.of(DEFAULT_POSITION));
    }

    public Trace move(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            position.move();
        }
        return Trace.of(carName, Position.of(position.getPosition()));
    }
}
