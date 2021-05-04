package domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static final String COMMA = ",";
    public static final int INITIAL_POSITION = 0;

    public static List<Car> createCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(COMMA)) {
            cars.add(Car.of(carName, INITIAL_POSITION));
        }
        return cars;
    }
}
