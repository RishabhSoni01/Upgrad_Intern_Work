package org.example.Question1;

public class MissingGradeException extends Exception {
    private int studentId;

    public MissingGradeException(int studentId) {
        super("Grade missing for student with ID: " + studentId);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
}
