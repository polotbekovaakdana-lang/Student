package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Group group = new Group("Java Group");

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Search student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter student age: ");
                        int age = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter student ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        Student student = new Student(
                                name, age, id, group.getGroupName()
                        );

                        group.addStudent(student);

                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    group.showStudents();
                    break;

                case 3:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    group.searchStudent(searchName);
                    break;

                case 4:
                    System.out.println("Program finished. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}



