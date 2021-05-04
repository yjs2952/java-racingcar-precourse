package domain;

import utils.ValidationUtils;

public class CarName {
    public static final String INPUT_LENGTH_ERROR_MESSAGE = "입력값은 최소 1자 이상 5자 이하여야 합니다.";
    public static final String INPUT_NULL_OR_EMPTY_ERROR_MESSAGE = "입력값에 null 또는 공백이 포함될 수 없습니다.";

    private final String name;

    private CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (!ValidationUtils.isValidLength(name)) {
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);
        }

        if (!ValidationUtils.isValidString(name)) {
            throw new IllegalArgumentException(INPUT_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }
}
