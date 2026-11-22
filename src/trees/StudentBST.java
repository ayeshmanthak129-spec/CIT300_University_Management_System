package trees;

import studentmanagement.Student;

public class StudentBST {

    private StudentTreeNode root;
    private int size;

    public StudentBST() {
        root = null;
        size = 0;
    }

    // Insert a student into the BST
    public boolean insert(Student student) {
        if (student == null || student.getStudentId() == null) {
            return false;
        }

        if (search(student.getStudentId()) != null) {
            return false;
        }

        root = insertRecursive(root, student);
        size++;
        return true;
    }

    private StudentTreeNode insertRecursive(
            StudentTreeNode current, Student student) {

        if (current == null) {
            return new StudentTreeNode(student);
        }

        int comparison = student.getStudentId().compareToIgnoreCase(
                current.getStudent().getStudentId());

        if (comparison < 0) {
            current.setLeft(insertRecursive(current.getLeft(), student));
        } else if (comparison > 0) {
            current.setRight(insertRecursive(current.getRight(), student));
        }

        return current;
    }

    // Search for a student using Student ID
    public Student search(String studentId) {
        if (studentId == null || studentId.isBlank()) {
            return null;
        }

        StudentTreeNode current = root;

        while (current != null) {
            int comparison = studentId.compareToIgnoreCase(
                    current.getStudent().getStudentId());

            if (comparison == 0) {
                return current.getStudent();
            } else if (comparison < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return null;
    }

    // Delete a student using Student ID
    public boolean delete(String studentId) {
        if (search(studentId) == null) {
            return false;
        }

        root = deleteRecursive(root, studentId);
        size--;
        return true;
    }

    private StudentTreeNode deleteRecursive(
            StudentTreeNode current, String studentId) {

        if (current == null) {
            return null;
        }

        int comparison = studentId.compareToIgnoreCase(
                current.getStudent().getStudentId());

        if (comparison < 0) {
            current.setLeft(deleteRecursive(current.getLeft(), studentId));
        } else if (comparison > 0) {
            current.setRight(deleteRecursive(current.getRight(), studentId));
        } else {

            // Case 1: No child
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            // Case 2: One child
            if (current.getLeft() == null) {
                return current.getRight();
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            // Case 3: Two children
            StudentTreeNode successor = findMinimum(current.getRight());

            current.setStudent(successor.getStudent());

            current.setRight(deleteRecursive(
                    current.getRight(),
                    successor.getStudent().getStudentId()));
        }

        return current;
    }

    // Find the smallest node in a subtree
    private StudentTreeNode findMinimum(StudentTreeNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    // Display students in ascending Student ID order
    public void displayInOrder() {
        if (root == null) {
            System.out.println("The Student BST is empty.");
            return;
        }

        System.out.println("\nStudents in BST (Ascending Student ID):");
        displayInOrderRecursive(root);
    }

    private void displayInOrderRecursive(StudentTreeNode node) {
        if (node != null) {
            displayInOrderRecursive(node.getLeft());

            Student student = node.getStudent();

            System.out.println(
                    student.getStudentId() + " | "
                    + student.getName() + " | "
                    + student.getProgramme() + " | "
                    + student.getMarks());

            displayInOrderRecursive(node.getRight());
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }
}
