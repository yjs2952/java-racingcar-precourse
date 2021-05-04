package domain;

import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final String COMMA = ",";
    public static final String INPUT_NULL_OR_EMPTY_ERROR_MESSAGE = "입력값에 null 또는 공백이 포함될 수 없습니다.";
    public static final String INPUT_NAMES_COUNT_ERROR_MESSAGE = "자동차 이름은 2개 이상이어야 합니다.";
    public static final String INPUT_DUPLICATE_ERROR_MESSAGE = "자동차 이름은 중복 될 수 없습니다.";

    private final List<Car> cars;

    public static Cars of(String carNames) {
        return new Cars(carNames);
    }

    public Traces tryMove(MovingStrategy strategy) {
        List<Trace> traces = new ArrayList<>();
        for (Car car : cars) {
            traces.add(car.move(strategy));
        }
        return Traces.of(traces);
    }

    private Cars(String carNames) {
        validateCarNames(carNames);
        this.cars = CarFactory.createCars(carNames);
    }

    private void validateCarNames(String carNames) {
        validateNullOrEmpty(carNames);
        String[] splits = carNames.split(COMMA);
        validateNamesCount(splits);
        validateDuplicates(splits);
    }

    private void validateDuplicates(String[] splits) {
        if (!ValidationUtils.hasNotDuplicateNames(splits)) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateNamesCount(String[] splits) {
        if (!ValidationUtils.isValidSize(splits)) {
            throw new IllegalArgumentException(INPUT_NAMES_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateNullOrEmpty(String carNames) {
        if (!ValidationUtils.isValidString(carNames)) {
            throw new IllegalArgumentException(INPUT_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }
}
