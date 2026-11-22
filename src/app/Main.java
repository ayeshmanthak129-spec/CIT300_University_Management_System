
package app;

import studentmanagement.Student;
import studentmanagement.StudentLinkedList;

import trees.StudentBST;
import hashing.StudentHashTable;

import stackqueue.Action;
import stackqueue.ActionStack;
import stackqueue.ServiceRequest;
import stackqueue.ServiceRequestQueue;

import graph.CampusGraph;

import java.util.List;
import java.util.Scanner;

public class Main {

    // Input reader
    private static final Scanner scanner = new Scanner(System.in);

    // Student management structures
    private static final StudentLinkedList studentList =
            new StudentLinkedList();

    private static final StudentBST studentBST =
            new StudentBST();

    private static final StudentHashTable studentHashTable =
            new StudentHashTable();

    // Stack and Queue
    private static final ActionStack actionStack =
            new ActionStack();

    private static final ServiceRequestQueue requestQueue =
            new ServiceRequestQueue();

    // Campus Graph
    private static final CampusGraph campusGraph =
            new CampusGraph();

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println(" UNIVERSITY STUDENT RECORD MANAGEMENT");
        System.out.println(" AND CAMPUS ROUTE MANAGEMENT SYSTEM");
        System.out.println("==========================================");

        boolean running = true;

        while (running) {

            displayMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    studentManagementMenu();
                    break;

                case 2:
                    actionHistoryMenu();
                    break;

                case 3:
                    serviceRequestMenu();
                    break;

                case 4:
                    searchUsingBST();
                    break;

                case 5:
                    searchUsingHashTable();
                    break;

                case 6:
                    campusManagementMenu();
                    break;

                case 7:
                    studentList.displayAllStudents();
                    break;

                case 0:
                    running = false;
                    System.out.println(
                            "Thank you for using the system!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // ==========================================
    // MAIN MENU
    // ==========================================

    private static void displayMainMenu() {

        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Student Management");
        System.out.println("2. Recent Action History (Stack)");
        System.out.println("3. Service Requests (Queue)");
        System.out.println("4. Search Student using BST");
        System.out.println("5. Search Student using Hash Table");
        System.out.println("6. Campus Management (Graph)");
        System.out.println("7. Display All Students");
        System.out.println("0. Exit");
        System.out.println("===============================");
    }

    // ==========================================
    // STUDENT MANAGEMENT
    // ==========================================

    private static void studentManagementMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("0. Back to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    studentList.displayAllStudents();
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent() {

        System.out.println("\n--- ADD STUDENT ---");

        String id = readNonEmpty("Enter Student ID: ");

        // Check duplicate IDs in all structures
        if (studentList.searchStudent(id) != null
                || studentBST.search(id) != null
                || studentHashTable.search(id) != null) {

            System.out.println(
                    "Error: Student ID already exists.");
            return;
        }

        String name = readNonEmpty("Enter Student Name: ");

        String programme =
                readNonEmpty("Enter Programme: ");

        double marks = readMarks();

        Student student =
                new Student(id, name, programme, marks);

        boolean added = studentList.addStudent(student);

        if (added) {

            studentBST.insert(student);
            studentHashTable.insert(student);

            actionStack.push(
                    new Action("Added student: " + id, null));

            System.out.println(
                    "Student added to all three structures successfully!");

        } else {

            System.out.println("Student could not be added.");
        }
    }

    private static void updateStudent() {

        System.out.println("\n--- UPDATE STUDENT ---");

        String id = readNonEmpty("Enter Student ID: ");

        Student existing = studentList.searchStudent(id);

        if (existing == null) {

            System.out.println("Student not found.");
            return;
        }

        System.out.println("Current Student Details:");
        System.out.println(existing);

        String name = readNonEmpty("Enter New Name: ");

        String programme =
                readNonEmpty("Enter New Programme: ");

        double marks = readMarks();

        boolean updated = studentList.updateStudent(
                id, name, programme, marks);

        if (updated) {

            actionStack.push(
                    new Action("Updated student: " + id, null));

            System.out.println(
                    "Student updated successfully.");
            System.out.println(
                    "BST and Hash Table share the updated Student object.");

        } else {

            System.out.println("Student update failed.");
        }
    }

    private static void deleteStudent() {

        System.out.println("\n--- DELETE STUDENT ---");

        String id = readNonEmpty("Enter Student ID: ");

        Student student = studentList.searchStudent(id);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        System.out.println("Student to be deleted:");
        System.out.println(student);

        System.out.print(
                "Are you sure you want to delete? (Y/N): ");

        String confirmation =
                scanner.nextLine().trim();

        if (!confirmation.equalsIgnoreCase("Y")) {

            System.out.println("Deletion cancelled.");
            return;
        }

        boolean deleted = studentList.deleteStudent(id);

        if (deleted) {

            studentBST.delete(id);
            studentHashTable.delete(id);

            actionStack.push(
                    new Action("Deleted student: " + id, student));

            System.out.println(
                    "Student deleted from all structures.");

        } else {

            System.out.println("Student deletion failed.");
        }
    }

    private static void searchStudent() {

        System.out.println("\n--- LINKED LIST SEARCH ---");

        String id = readNonEmpty("Enter Student ID: ");

        Student student = studentList.searchStudent(id);

        if (student != null) {

            System.out.println("Student found:");
            System.out.println(student);

        } else {

            System.out.println("Student not found.");
        }
    }

    // ==========================================
    // BST SEARCH
    // ==========================================

    private static void searchUsingBST() {

        System.out.println("\n--- BST STUDENT SEARCH ---");

        String id = readNonEmpty("Enter Student ID: ");

        Student student = studentBST.search(id);

        if (student != null) {

            System.out.println("Student found using BST:");
            System.out.println(student);

        } else {

            System.out.println("Student not found in BST.");
        }

        System.out.println("\nBST Students (Ascending ID):");
        studentBST.displayInOrder();
    }

    // ==========================================
    // HASH TABLE SEARCH
    // ==========================================

    private static void searchUsingHashTable() {

        System.out.println("\n--- HASH TABLE SEARCH ---");

        String id = readNonEmpty("Enter Student ID: ");

        Student student = studentHashTable.search(id);

        if (student != null) {

            System.out.println(
                    "Student found using Hash Table:");
            System.out.println(student);

        } else {

            System.out.println(
                    "Student not found in Hash Table.");
        }

        System.out.println("\nHash Table Information:");
        studentHashTable.displayTable();
    }

    // ==========================================
    // STACK - ACTION HISTORY
    // ==========================================

    private static void actionHistoryMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== ACTION HISTORY (STACK) =====");
            System.out.println("1. Display Recent Actions");
            System.out.println("2. View Latest Action");
            System.out.println("3. Remove Latest History Entry");
            System.out.println("4. Display Stack Size");
            System.out.println("0. Back to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    actionStack.displayStack();
                    break;

                case 2:

                    if (actionStack.isEmpty()) {

                        System.out.println(
                                "No action history available.");

                    } else {

                        System.out.println(
                                actionStack.peek());
                    }
                    break;

                case 3:

                    if (actionStack.isEmpty()) {

                        System.out.println(
                                "Action history is empty.");

                    } else {

                        Action removed = actionStack.pop();

                        System.out.println(
                                "Removed history entry:");
                        System.out.println(removed);
                    }
                    break;

                case 4:

                    System.out.println(
                            "Stack Size: "
                                    + actionStack.getSize());
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ==========================================
    // QUEUE - SERVICE REQUESTS
    // ==========================================

    private static void serviceRequestMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== SERVICE REQUEST QUEUE =====");
            System.out.println("1. Add Service Request");
            System.out.println("2. Process Next Request");
            System.out.println("3. View Next Request");
            System.out.println("4. Display All Pending Requests");
            System.out.println("5. Display Queue Size");
            System.out.println("0. Back to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addServiceRequest();
                    break;

                case 2:

                    if (requestQueue.isEmpty()) {

                        System.out.println(
                                "No pending requests.");

                    } else {

                        ServiceRequest processed =
                                requestQueue.dequeue();

                        System.out.println(
                                "Processed Service Request:");
                        System.out.println(processed);
                    }
                    break;

                case 3:

                    if (requestQueue.isEmpty()) {

                        System.out.println(
                                "No pending requests.");

                    } else {

                        System.out.println(
                                "Next Request:");
                        System.out.println(
                                requestQueue.peek());
                    }
                    break;

                case 4:
                    requestQueue.displayQueue();
                    break;

                case 5:

                    System.out.println(
                            "Pending Requests: "
                                    + requestQueue.getSize());
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addServiceRequest() {

        System.out.println("\n--- ADD SERVICE REQUEST ---");

        String requestId =
                readNonEmpty("Enter Request ID: ");

        String studentId =
                readNonEmpty("Enter Student ID: ");

        // Check that the student exists
        if (studentList.searchStudent(studentId) == null) {

            System.out.println(
                    "Cannot create request. Student not found.");
            return;
        }

        String description =
                readNonEmpty("Enter Request Description: ");

        try {

            ServiceRequest request =
                    new ServiceRequest(
                            requestId,
                            studentId,
                            description);

            requestQueue.enqueue(request);

            System.out.println(
                    "Service request added successfully.");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Request failed: " + e.getMessage());
        }
    }

    // ==========================================
    // CAMPUS GRAPH MANAGEMENT
    // ==========================================

    private static void campusManagementMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== CAMPUS MANAGEMENT (GRAPH) =====");
            System.out.println("1. Add Campus Location");
            System.out.println("2. Remove Campus Location");
            System.out.println("3. Connect Two Locations");
            System.out.println("4. Remove Road");
            System.out.println("5. Display Campus Network");
            System.out.println("6. Display Location Neighbours");
            System.out.println("7. Find Shortest Route (BFS)");
            System.out.println("8. Display Campus Traversal (DFS)");
            System.out.println("0. Back to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addCampusLocation();
                    break;

                case 2:
                    removeCampusLocation();
                    break;

                case 3:
                    connectCampusLocations();
                    break;

                case 4:
                    removeCampusRoad();
                    break;

                case 5:
                    campusGraph.displayNetwork();
                    break;

                case 6:
                    displayLocationNeighbours();
                    break;

                case 7:
                    findCampusRoute();
                    break;

                case 8:
                    performCampusDFS();
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addCampusLocation() {

        System.out.println("\n--- ADD CAMPUS LOCATION ---");

        String id =
                readNonEmpty("Enter Location ID: ");

        String name =
                readNonEmpty("Enter Location Name: ");

        if (campusGraph.addLocation(id, name)) {

            System.out.println(
                    "Campus location added successfully.");

        } else {

            System.out.println(
                    "Could not add location. Check for duplicate ID.");
        }
    }

    private static void removeCampusLocation() {

        System.out.println("\n--- REMOVE CAMPUS LOCATION ---");

        String id =
                readNonEmpty("Enter Location ID: ");

        if (campusGraph.removeLocation(id)) {

            System.out.println(
                    "Location removed successfully.");

        } else {

            System.out.println(
                    "Location not found.");
        }
    }

    private static void connectCampusLocations() {

        System.out.println("\n--- CONNECT LOCATIONS ---");

        String id1 =
                readNonEmpty("Enter First Location ID: ");

        String id2 =
                readNonEmpty("Enter Second Location ID: ");

        if (campusGraph.connectLocations(id1, id2)) {

            System.out.println(
                    "Locations connected successfully.");

        } else {

            System.out.println(
                    "Could not connect locations.");
        }
    }

    private static void removeCampusRoad() {

        System.out.println("\n--- REMOVE ROAD ---");

        String id1 =
                readNonEmpty("Enter First Location ID: ");

        String id2 =
                readNonEmpty("Enter Second Location ID: ");

        if (campusGraph.removeRoad(id1, id2)) {

            System.out.println(
                    "Road removed successfully.");

        } else {

            System.out.println(
                    "Road not found or invalid locations.");
        }
    }

    private static void displayLocationNeighbours() {

        System.out.println("\n--- LOCATION NEIGHBOURS ---");

        String id =
                readNonEmpty("Enter Location ID: ");

        campusGraph.displayNeighbours(id);
    }

    private static void findCampusRoute() {

        System.out.println("\n--- SHORTEST CAMPUS ROUTE (BFS) ---");

        String startId =
                readNonEmpty("Enter Starting Location ID: ");

        String targetId =
                readNonEmpty("Enter Destination Location ID: ");

        List<String> route =
                campusGraph.bfs(startId, targetId);

        if (route == null || route.isEmpty()) {

            System.out.println(
                    "No route found between these locations.");

        } else {

            System.out.println("Shortest Route:");

            for (int i = 0; i < route.size(); i++) {

                String locationId = route.get(i);

                System.out.print(locationId);

                if (campusGraph.getLocation(locationId) != null) {

                    System.out.print(
                            " (" + campusGraph.getLocation(
                                    locationId).getName() + ")");
                }

                if (i < route.size() - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }
    }

    private static void performCampusDFS() {

        System.out.println("\n--- CAMPUS DFS TRAVERSAL ---");

        String startId =
                readNonEmpty("Enter Starting Location ID: ");

        List<String> traversal =
                campusGraph.dfs(startId);

        if (traversal == null || traversal.isEmpty()) {

            System.out.println(
                    "No locations found for this starting ID.");

        } else {

            System.out.println(
                    "Depth First Search Traversal:");

            System.out.println(traversal);
        }
    }

    // ==========================================
    // INPUT VALIDATION
    // ==========================================

    private static String readNonEmpty(String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Input cannot be empty. Please try again.");
        }
    }

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid whole number.");
            }
        }
    }

    private static double readMarks() {

        while (true) {

            System.out.print("Enter Marks (0-100): ");

            String input = scanner.nextLine().trim();

            try {

                double marks = Double.parseDouble(input);

                if (Double.isFinite(marks)
                        && marks >= 0
                        && marks <= 100) {

                    return marks;
                }

                System.out.println(
                        "Marks must be between 0 and 100.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter valid numeric marks.");
            }
        }
    }
}
