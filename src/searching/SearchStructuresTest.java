package searching;

import studentmanagement.Student;
import trees.StudentBST;
import hashing.StudentHashTable;

public class SearchStructuresTest {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" MEMBER 3 - BST AND HASH TABLE TEST");
        System.out.println("======================================");

        // Create test students
        Student student1 = new Student(
                "22UG3-0399",
                "A A P Kumarasiri",
                "Computer Science",
                85.5
        );

        Student student2 = new Student(
                "22UG3-0436",
                "M R M Fahad",
                "Computer Science",
                78.0
        );

        Student student3 = new Student(
                "22UG3-0811",
                "G W W M R P U W C A K Polgaspitiya",
                "Information Technology",
                90.0
        );

        // Create BST and Hash Table
        StudentBST bst = new StudentBST();
        StudentHashTable hashTable = new StudentHashTable();

        // ==================================
        // TEST 1: BST INSERTION
        // ==================================

        System.out.println("\n--- BST INSERTION TEST ---");

        System.out.println("Insert student 1: "
                + bst.insert(student1));

        System.out.println("Insert student 2: "
                + bst.insert(student2));

        System.out.println("Insert student 3: "
                + bst.insert(student3));

        System.out.println("Insert duplicate student: "
                + bst.insert(student1));

        System.out.println("BST size: " + bst.getSize());

        // ==================================
        // TEST 2: BST SEARCH
        // ==================================

        System.out.println("\n--- BST SEARCH TEST ---");

        Student bstResult = bst.search("22UG3-0436");

        if (bstResult != null) {
            System.out.println("Student found: "
                    + bstResult.getName());
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("Search missing student: "
                + bst.search("22UG3-9999"));

        // ==================================
        // TEST 3: BST DISPLAY
        // ==================================

        System.out.println("\n--- BST DISPLAY TEST ---");

        bst.displayInOrder();

        // ==================================
        // TEST 4: BST DELETION
        // ==================================

        System.out.println("\n--- BST DELETION TEST ---");

        System.out.println("Delete student 2: "
                + bst.delete("22UG3-0436"));

        System.out.println("Delete missing student: "
                + bst.delete("22UG3-9999"));

        System.out.println("BST size after deletion: "
                + bst.getSize());

        // ==================================
        // TEST 5: HASH TABLE INSERTION
        // ==================================

        System.out.println("\n--- HASH TABLE INSERTION TEST ---");

        System.out.println("Insert student 1: "
                + hashTable.insert(student1));

        System.out.println("Insert student 2: "
                + hashTable.insert(student2));

        System.out.println("Insert student 3: "
                + hashTable.insert(student3));

        System.out.println("Insert duplicate student: "
                + hashTable.insert(student1));

        System.out.println("Hash Table size: "
                + hashTable.getSize());

        // ==================================
        // TEST 6: HASH TABLE SEARCH
        // ==================================

        System.out.println("\n--- HASH TABLE SEARCH TEST ---");

        Student hashResult = hashTable.search("22UG3-0811");

        if (hashResult != null) {
            System.out.println("Student found: "
                    + hashResult.getName());
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("Search missing student: "
                + hashTable.search("22UG3-9999"));

        // ==================================
        // TEST 7: HASH TABLE DISPLAY
        // ==================================

        System.out.println("\n--- HASH TABLE DISPLAY TEST ---");

        hashTable.displayTable();

        System.out.println("Hash Table load factor: "
                + hashTable.getLoadFactor());

        // ==================================
        // TEST 8: HASH TABLE DELETION
        // ==================================

        System.out.println("\n--- HASH TABLE DELETION TEST ---");

        System.out.println("Delete student 2: "
                + hashTable.delete("22UG3-0436"));

        System.out.println("Delete missing student: "
                + hashTable.delete("22UG3-9999"));

        System.out.println("Hash Table size after deletion: "
                + hashTable.getSize());

        // ==================================
        // FINAL RESULTS
        // ==================================

        System.out.println("\n======================================");
        System.out.println(" FINAL TEST RESULTS");
        System.out.println("======================================");

        System.out.println("Expected BST size: 2");
        System.out.println("Actual BST size: " + bst.getSize());

        System.out.println("Expected Hash Table size: 2");
        System.out.println("Actual Hash Table size: "
                + hashTable.getSize());

        if (bst.getSize() == 2 && hashTable.getSize() == 2) {
            System.out.println("\nBasic tests completed successfully.");
        } else {
            System.out.println("\nCheck the implementation for errors.");
        }

        System.out.println("\n======================================");
    }
}
