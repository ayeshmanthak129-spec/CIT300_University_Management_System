
package studentmanagement;

public class StudentManagementTest {

    public static void main(String[] args) {

        // Create a linked list
        StudentLinkedList students = new StudentLinkedList();

        System.out.println("===== STUDENT MANAGEMENT TEST =====");

        // 1. Add students
        System.out.println("\n1. ADD STUDENTS");

        students.addStudent(new Student(
                "22UG3-0399",
                "A.A.P. Kumarasiri",
                "Information Technology",
                85
        ));

        students.addStudent(new Student(
                "22UG3-0436",
                "M R M FAHAD",
                "Computer Science",
                78
        ));

        students.addStudent(new Student(
                "22UG3-0811",
                "G.W.W.M.R.P.U.W.C.A.K Polgaspitiya",
                "Information Technology",
                90
        ));

        // 2. Display all students
        System.out.println("\n2. DISPLAY ALL STUDENTS");
        students.displayAllStudents();

        // 3. Search student
        System.out.println("\n3. SEARCH STUDENT");

        Student found = students.searchStudent("22UG3-0436");

        if (found != null) {
            System.out.println("Student found:");
            System.out.println(found);
        } else {
            System.out.println("Student not found.");
        }

        // 4. Update student
        System.out.println("\n4. UPDATE STUDENT");

        students.updateStudent(
                "22UG3-0399",
                "A.A.P. Kumarasiri",
                "Software Engineering",
                95
        );

        // 5. Delete student
        System.out.println("\n5. DELETE STUDENT");

        students.deleteStudent("22UG3-0811");

        // 6. Display final records
        System.out.println("\n6. FINAL STUDENT RECORDS");

        students.displayAllStudents();

        // 7. Display total count
        System.out.println("\nTotal student count: "
                + students.getSize());


        // 8. Test duplicate student ID
        System.out.println("\n7. TEST DUPLICATE STUDENT ID");

        boolean duplicateResult = students.addStudent(
                new Student(
                        "22UG3-0399",
                        "Duplicate Student",
                        "Information Technology",
                        70
                )
        );

        System.out.println("Duplicate accepted: " + duplicateResult);

        // 9. Test invalid marks during update
        System.out.println("\n8. TEST INVALID MARKS");

        boolean invalidMarksResult = students.updateStudent(
                "22UG3-0399",
                "A.A.P. Kumarasiri",
                "Information Technology",
                150
        );

        System.out.println("Invalid update accepted: " + invalidMarksResult);

        // 10. Test searching for a missing student
        System.out.println("\n9. TEST MISSING STUDENT");

        Student missing = students.searchStudent("22UG3-9999");

        if (missing == null) {
            System.out.println("Correct: Student not found.");
        }

        // 11. Test deleting a missing student
        System.out.println("\n10. TEST DELETING MISSING STUDENT");

        students.deleteStudent("22UG3-9999");

        // 12. Check final student count
        System.out.println("\nFinal student count: " + students.getSize());

        System.out.println("\n===== TEST COMPLETED =====");
    }
}
