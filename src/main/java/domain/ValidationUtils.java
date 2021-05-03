package domain;

public class ValidationUtils {

    public static boolean validDriverName(String driverName) {
        return isValidString(driverName) && isValidLength(driverName) ;
    }

    private static boolean isValidString(String driverName) {
        return driverName != null && !driverName.contains(" ");
    }

    private static boolean isValidLength(String driverName) {
        return !driverName.isEmpty() && driverName.length() <= 5;
    }
}
