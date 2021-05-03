package domain;

public class ValidationUtils {

    public static final int MAX_LENGTH = 5;
    public static final String BLANK = " ";

    public static boolean validDriverName(String driverName) {
        return isValidString(driverName) && isValidLength(driverName) ;
    }

    private static boolean isValidString(String driverName) {
        return driverName != null && !driverName.contains(BLANK);
    }

    private static boolean isValidLength(String driverName) {
        return !driverName.isEmpty() && driverName.length() <= MAX_LENGTH;
    }
}
