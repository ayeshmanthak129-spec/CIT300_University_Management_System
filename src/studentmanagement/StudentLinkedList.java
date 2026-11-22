
package studentmanagement;

public class StudentLinkedList {

    // Reference to the first node
    private StudentNode head;

    // Number of students in the list
    private int size;

    // Constructor
    public StudentLinkedList() {
        head = null;
        size = 0;
    }

    // Check whether the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Return the number of students
    public int getSize() {
        return size;
    }

    // Search for a student using Student ID
    public Student searchStudent(String studentId) {

        if (studentId == null || studentId.isBlank()) {
            return null;
        }

        StudentNode current = head;

        while (current != null) {

            if (current.getStudent().getStudentId()
                    .equalsIgnoreCase(studentId.trim())) {

                return current.getStudent();
            }

            current = current.getNext();
        }

        return null;
    }

    // Add a new student
    public boolean addStudent(Student student) {

        if (student == null) {
            return false;
        }

        // Prevent duplicate student IDs
        if (searchStudent(student.getStudentId()) != null) {
            System.out.println("Error: Student ID already exists.");
            return false;
        }

        StudentNode newNode = new StudentNode(student);

        // If the list is empty
        if (head == null) {
            head = newNode;
        } else {

            // Find the last node
            StudentNode current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            // Connect the new node
            current.setNext(newNode);
        }

        size++;

        System.out.println("Student added successfully!");
        return true;
    }

    // Display all student records
    public void displayAllStudents() {

        if (isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        StudentNode current = head;
        int count = 1;

        System.out.println("\n===== ALL STUDENT RECORDS =====");

        while (current != null) {

            System.out.println("\nStudent " + count);
            System.out.println("-------------------------");
            System.out.println(current.getStudent());

            current = current.getNext();
            count++;
        }

        System.out.println("\nTotal Students: " + size);
    }

    // Update an existing student
    public boolean updateStudent(String studentId,
                                 String newName,
                                 String newProgramme,
                                 double newMarks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        // Validate all new details before changing anything
        if (newName == null || newName.isBlank()) {
            System.out.println("Update failed: Name cannot be empty.");
            return false;
        }

        if (newProgramme == null || newProgramme.isBlank()) {
            System.out.println("Update failed: Programme cannot be empty.");
            return false;
        }

        if (newMarks < 0 || newMarks > 100) {
            System.out.println("Update failed: Marks must be between 0 and 100.");
            return false;
        }

        student.setName(newName);
        student.setProgramme(newProgramme);
        student.setMarks(newMarks);

        System.out.println("Student updated successfully!");
        return true;
    }

    // Delete a student using Student ID
    public boolean deleteStudent(String studentId) {

        if (studentId == null || studentId.isBlank()) {
            System.out.println("Invalid Student ID.");
            return false;
        }

        if (isEmpty()) {
            System.out.println("No student records to delete.");
            return false;
        }

        // If the first node contains the student
        if (head.getStudent().getStudentId()
                .equalsIgnoreCase(studentId.trim())) {

            head = head.getNext();
            size--;

            System.out.println("Student deleted successfully!");
            return true;
        }

        // Search for the student in the remaining nodes
        StudentNode current = head;

        while (current.getNext() != null) {

            if (current.getNext().getStudent()
                    .getStudentId().equalsIgnoreCase(studentId.trim())) {

                // Skip the node being deleted
                current.setNext(current.getNext().getNext());

                size--;

                System.out.println("Student deleted successfully!");
                return true;
            }

            current = current.getNext();
        }

        System.out.println("Student not found.");
        return false;
    }
}
