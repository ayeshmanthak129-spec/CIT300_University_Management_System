
package studentmanagement;

public class StudentNode {

    // Store one student record
    private Student student;

    // Reference to the next node
    private StudentNode next;

    // Constructor
    public StudentNode(Student student) {
        this.student = student;
        this.next = null;
    }

    // Get student information
    public Student getStudent() {
        return student;
    }

    // Set student information
    public void setStudent(Student student) {
        this.student = student;
    }

    // Get the next node
    public StudentNode getNext() {
        return next;
    }

    // Set the next node
    public void setNext(StudentNode next) {
        this.next = next;
    }
}
