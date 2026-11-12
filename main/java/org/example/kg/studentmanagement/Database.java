package org.example.kg.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    // Вместо YOUR_PASSWORD введи свой пароль MySQL
    private static final String PASSWORD = "ssh root@103.228.168.134";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
