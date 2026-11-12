package org.example;


public class Student extends Person {
    private int studentId;
    private String groupName;

    public Student(String name, int age, int studentId, String groupName) {
        super(name, age);
        setStudentId(studentId);
        setGroupName(groupName);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("ID must be positive!");
        }
        this.studentId = studentId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        if (groupName == null || groupName.trim().isEmpty()) {
            throw new IllegalArgumentException("Group cannot be empty!");
        }
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Student ID: " + studentId
                + ", Group: " + groupName;
    }
}

