
package studentmanagement;

public class Student {

    // Student information
    private String studentId;
    private String name;
    private String programme;
    private double marks;

    // Constructor
    public Student(String studentId, String name,
                   String programme, double marks) {

        setStudentId(studentId);
        setName(name);
        setProgramme(programme);
        setMarks(marks);
    }

    // Get student ID
    public String getStudentId() {
        return studentId;
    }

    // Set student ID
    public void setStudentId(String studentId) {
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Student ID cannot be empty."
            );
        }

        this.studentId = studentId.trim();
    }

    // Get name
    public String getName() {
        return name;
    }

    // Set name
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Student name cannot be empty."
            );
        }

        this.name = name.trim();
    }

    // Get programme
    public String getProgramme() {
        return programme;
    }

    // Set programme
    public void setProgramme(String programme) {
        if (programme == null || programme.isBlank()) {
            throw new IllegalArgumentException(
                    "Programme cannot be empty."
            );
        }

        this.programme = programme.trim();
    }

    // Get marks
    public double getMarks() {
        return marks;
    }

    // Set marks
    public void setMarks(double marks) {
        if (!Double.isFinite(marks) || marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                    "Marks must be between 0 and 100."
            );
        }

        this.marks = marks;
    }

    // Display student information
    @Override
    public String toString() {
        return "Student ID: " + studentId +
                "\nName: " + name +
                "\nProgramme: " + programme +
                "\nMarks: " + marks;
    }
}
