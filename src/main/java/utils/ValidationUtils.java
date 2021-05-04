package utils;

import java.util.Arrays;
import java.util.HashSet;

public class ValidationUtils {

    public static final int MAX_LENGTH = 5;
    public static final int MIN_LENGTH = 1;
    public static final String BLANK = " ";

    public static boolean isValidSize(String[] splits) {
        return splits.length > MIN_LENGTH;
    }

    public static boolean hasNotDuplicateNames(String[] carNames) {
        return carNames.length == new HashSet<>(Arrays.asList(carNames)).size();
    }

    public static boolean isValidString(String carName) {
        return carName != null && !carName.contains(BLANK);
    }

    public static boolean isValidLength(String carName) {
        return !carName.isEmpty() && carName.length() <= MAX_LENGTH;
    }

    public static boolean isValidTryCount(int tryCount) {
        return tryCount > 0;
    }
}
