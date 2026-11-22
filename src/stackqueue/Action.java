package stackqueue;

import studentmanagement.Student;

public class Action {

    private String description;
    private Student deletedStudent;

    public Action(String description, Student deletedStudent) {
        this.description = description;
        this.deletedStudent = deletedStudent;
    }

    public String getDescription() {
        return description;
    }

    public Student getDeletedStudent() {
        return deletedStudent;
    }

    @Override
    public String toString() {
        return "Action: " + description;
    }
}