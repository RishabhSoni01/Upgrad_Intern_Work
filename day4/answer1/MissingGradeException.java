package org.example.answer1;

public class MissingGradeException extends Exception {
    private int studentId;

    public MissingGradeException(int studentId) {
        super("Missing grade for student with ID: " + studentId);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
}
