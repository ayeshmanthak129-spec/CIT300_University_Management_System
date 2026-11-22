package hashing;

import studentmanagement.Student;

import java.util.Locale;

public class StudentHashTable {

    private static final int CAPACITY = 11;

    private HashNode[] table;
    private int size;

    public StudentHashTable() {
        table = new HashNode[CAPACITY];
        size = 0;
    }

    // Calculate the bucket index for a Student ID
    private int hashFunction(String studentId) {
        String normalizedId = studentId.toLowerCase(Locale.ROOT);

        return Math.floorMod(normalizedId.hashCode(), CAPACITY);
    }

    // Insert a student into the Hash Table
    public boolean insert(Student student) {

        if (student == null || student.getStudentId() == null
                || student.getStudentId().isBlank()) {
            return false;
        }

        if (search(student.getStudentId()) != null) {
            return false;
        }

        int index = hashFunction(student.getStudentId());

        HashNode newNode = new HashNode(student);

        // Insert at the beginning of the linked chain
        newNode.setNext(table[index]);
        table[index] = newNode;

        size++;

        return true;
    }

    // Search for a student using Student ID
    public Student search(String studentId) {

        if (studentId == null || studentId.isBlank()) {
            return null;
        }

        int index = hashFunction(studentId);

        HashNode current = table[index];

        while (current != null) {

            if (current.getStudent().getStudentId()
                    .equalsIgnoreCase(studentId)) {
                return current.getStudent();
            }

            current = current.getNext();
        }

        return null;
    }

    // Delete a student using Student ID
    public boolean delete(String studentId) {

        if (studentId == null || studentId.isBlank()) {
            return false;
        }

        int index = hashFunction(studentId);

        HashNode current = table[index];
        HashNode previous = null;

        while (current != null) {

            if (current.getStudent().getStudentId()
                    .equalsIgnoreCase(studentId)) {

                if (previous == null) {
                    table[index] = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }

                size--;

                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    // Display all Hash Table buckets
    public void displayTable() {

        System.out.println("\nStudent Hash Table:");

        for (int i = 0; i < CAPACITY; i++) {

            System.out.print("Bucket " + i + ": ");

            HashNode current = table[i];

            if (current == null) {
                System.out.println("Empty");
                continue;
            }

            while (current != null) {

                Student student = current.getStudent();

                System.out.print(
                        "[" + student.getStudentId()
                        + " - " + student.getName() + "]");

                current = current.getNext();

                if (current != null) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return CAPACITY;
    }

    // Load factor = Number of stored students / Table capacity
    public double getLoadFactor() {
        return (double) size / CAPACITY;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
