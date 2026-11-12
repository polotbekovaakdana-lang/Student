package org.example;

import java.util.ArrayList;

public class Group {
    private String groupName;
    private ArrayList<Student> students;

    public Group(String groupName) {
        if (groupName == null || groupName.trim().isEmpty()) {
            throw new IllegalArgumentException("Group name cannot be empty!");
        }

        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null!");
        }

        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                System.out.println("Student with this ID already exists!");
                return;
            }
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in this group.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void searchStudent(String name) {
        boolean found = false;

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }
}

