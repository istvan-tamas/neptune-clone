package database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();
    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db/db-conn.txt")) {
            if (input == null) {
                System.out.println("Unable to find db-conn.txt");
                System.exit(1);
            }

            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }
    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }
    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
}