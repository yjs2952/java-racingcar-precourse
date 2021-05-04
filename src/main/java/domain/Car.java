package domain;

public class Car {
    private final CarName carName;
    private final Position position;

    private Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car of(String carName, int position) {
        return new Car(CarName.of(carName), Position.of(position));
    }

    public Trace move(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            position.move();
        }
        return Trace.of(carName, Position.of(position.getPosition()));
    }
}
