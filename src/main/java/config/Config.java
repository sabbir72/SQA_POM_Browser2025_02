package config;

public class Config {
    // Base URL of the application under test
    public static final String BASE_URL = "https://www.saucedemo.com/";

    // Test user credentials
    public static final String STANDARD_USER = "standard_user";
    public static final String LOCKED_USER = "locked_out_user";
    public static final String PROBLEM_USER = "problem_user";
    public static final String PERFORMANCE_USER = "performance_glitch_user";
    public static final String PASSWORD = "secret_sauce";

    // Timeout configurations
    public static final int EXPLICIT_WAIT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 20;

    // Path configurations
    public static final String SCREENSHOT_PATH = "target/screenshots/";
}