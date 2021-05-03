package domain;

public class ValidationUtils {

    public static boolean validDriverName(String driverName) {
        return !driverName.isEmpty() && driverName.length() <= 5;
    }
}
