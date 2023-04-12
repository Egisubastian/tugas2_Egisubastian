package egisubastian.data.karyawan.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    
    // Datasource
    private static HikariDataSource hikariDataSource;

    static {
        // Configuration
        HikariConfig config = new HikariConfig();

        // Set Config
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Set Username
        config.setUsername("root");
        config.setPassword("");
        // jdbc:mysql://{ip/hostname}:{port}/{database}?{option}
        config.setJdbcUrl("jdbc:mysql://localhost:3306/db_karyawan?serverTimezone=Asia/Jakarta");

        // Pool
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(60 * 60 * 1000);

        // Set Datasource
        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }
}