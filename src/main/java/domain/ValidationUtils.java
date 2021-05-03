package domain;

public class ValidationUtils {

    public static final int MAX_LENGTH = 5;
    public static final String BLANK = " ";

    public static boolean validCarName(String carName) {
        return isValidString(carName) && isValidLength(carName) ;
    }

    private static boolean isValidString(String carName) {
        return carName != null && !carName.contains(BLANK);
    }

    private static boolean isValidLength(String carName) {
        return !carName.isEmpty() && carName.length() <= MAX_LENGTH;
    }
}
