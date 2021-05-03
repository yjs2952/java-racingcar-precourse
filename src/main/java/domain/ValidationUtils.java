package domain;

import java.util.Arrays;
import java.util.HashSet;

public class ValidationUtils {

    public static final int MAX_LENGTH = 5;
    public static final int MIN_LENGTH = 1;
    public static final String BLANK = " ";

    public static boolean validCarName(String carName) {
        return isValidString(carName) && isValidLength(carName) ;
    }

    public static boolean validCarNames(String carNames) {
        String[] splits = carNames.split(",");
        return hasNotDuplicateNames(splits) && isValidString(carNames) && splits.length > MIN_LENGTH;
    }

    private static boolean hasNotDuplicateNames(String[] carNames) {
        return carNames.length == new HashSet<>(Arrays.asList(carNames)).size();
    }

    private static boolean isValidString(String carName) {
        return carName != null && !carName.contains(BLANK);
    }

    private static boolean isValidLength(String carName) {
        return !carName.isEmpty() && carName.length() <= MAX_LENGTH;
    }
}
