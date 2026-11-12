package org.example.kg.studentmanagement;

import java.sql.*;
import java.util.Scanner;

public class MainD {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Добавить студента");
            System.out.println("2. Показать всех студентов");
            System.out.println("3. Удалить студента");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> showStudents();
                case 3 -> deleteStudent();
                case 4 -> {
                    System.out.println("Программа завершена!");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    // Добавление студента
    public static void addStudent() {
        try (Connection connection = Database.getConnection()) {

            System.out.print("Введите имя: ");
            String name = scanner.nextLine();

            System.out.print("Введите возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите email: ");
            String email = scanner.nextLine();

            System.out.print("Введите ID группы: ");
            int groupId = scanner.nextInt();
            scanner.nextLine();

            String sql = "INSERT INTO students (full_name, age, email, group_id) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

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

    // Показать студентов
    public static void showStudents() {
        try (Connection connection = Database.getConnection()) {

            String sql = "SELECT * FROM students";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            System.out.println("\n===== СПИСОК СТУДЕНТОВ =====");

            while (result.next()) {
                System.out.println(
                        "ID: " + result.getInt("id") +
                                " | Имя: " + result.getString("full_name") +
                                " | Возраст: " + result.getInt("age") +
                                " | Email: " + result.getString("email") +
                                " | ID группы: " + result.getInt("group_id")
                );
            }

        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Удалить студента
    public static void deleteStudent() {
        try (Connection connection = Database.getConnection()) {

            System.out.print("Введите ID студента: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            String sql = "DELETE FROM students WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Студент удалён!");
            } else {
                System.out.println("Студент не найден!");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}