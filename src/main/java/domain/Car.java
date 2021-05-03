package domain;

public class Car {
    public static final int MOVABLE_NUMBER = 4;
    public static final int MOVE = 1;
    public static final int STOP = 0;

    private final CarName carName;
    private final NumberGenerator numberGenerator;

    private Car(String carName, NumberGenerator generator) {
        this.carName = CarName.of(carName);
        this.numberGenerator = generator;
    }

    public static Car of(String carName, NumberGenerator generator) {
        return new Car(carName, generator);
    }

    public int move() {
        if (numberGenerator.generate() >= MOVABLE_NUMBER) {
            return MOVE;
        }
        return STOP;
    }
}
