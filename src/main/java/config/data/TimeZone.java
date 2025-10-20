package config.data;

public enum TimeZone {
    America_Denver;

    public static String getDefaultDenverTimeZone() {
        return America_Denver.toString().replace('_', '/');
    }
}
