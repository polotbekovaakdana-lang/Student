package org.example.kg.studentmanagement;

import java.sql.*;

public class StudentDAO {

    // Добавление студента
    public void addStudent(String name, int age,
                           String email, int groupId) {

        String sql = "INSERT INTO students " +
                "(full_name, age, email, group_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, email);
            statement.setInt(4, groupId);

            statement.executeUpdate();

            System.out.println("Студент успешно добавлен!");

        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Вывод всех студентов
    public void showStudents() {

        String sql = "SELECT * FROM students";

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            System.out.println("\n===== СПИСОК СТУДЕНТОВ =====");

            while (result.next()) {
                System.out.println(
                        "ID: " + result.getInt("id") +
                                " | Имя: " + result.getString("full_name") +
                                " | Возраст: " + result.getInt("age") +
                                " | Email: " + result.getString("email") +
                                " | Группа: " + result.getInt("group_id")
                );
            }

        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}