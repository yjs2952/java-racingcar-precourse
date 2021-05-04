package domain;

import utils.ValidationUtils;

public class RacingGame {
    public static final String INPUT_NUMBER_BOUND_ERROR_MESSAGE = "횟수는 1보다 작을 수 없습니다.";

    private final Cars cars;
    private final MovingStrategy strategy;
    private final Result result;

    public RacingGame(Cars cars, MovingStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
        this.result = new Result();
    }

    public void start(int tryCount) {
        validateTryCount(tryCount);
        for (int i = 0; i < tryCount; i++) {
            Traces traces = cars.tryMove(strategy);
            result.add(traces);
        }
    }

    private void validateTryCount(int tryCount) {
        if (!ValidationUtils.isValidTryCount(tryCount)) {
            throw new IllegalArgumentException(INPUT_NUMBER_BOUND_ERROR_MESSAGE);
        }
    }

    public String result() {
        return result.resultMessage();
    }
}
