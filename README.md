# University Student Record and Campus Route Management System

## 1. Project Overview

The **University Student Record and Campus Route Management System** is a Java console-based application developed for the CIT300 Data Structures and Algorithms module.

The project demonstrates the practical implementation of fundamental data structures and algorithms to manage university student records, service requests, action history, and campus locations and routes.

The application combines multiple data structures into one menu-driven system.

## 2. Project Objectives

- Manage university student records efficiently.
- Implement fundamental linear and non-linear data structures.
- Provide efficient student searching mechanisms.
- Manage student service requests using a queue.
- Maintain recent action history using a stack.
- Represent campus locations and connections using a graph.
- Apply graph traversal algorithms to explore campus routes.
- Demonstrate the practical application of data structures and algorithms in Java.

## 3. Technologies Used

- **Programming Language:** Java
- **JDK:** Java 21
- **IDE:** IntelliJ IDEA
- **Version Control:** Git
- **Repository Hosting:** GitHub

## 4. System Features

### 4.1 Student Management – Linked List

The student management module uses a singly linked list to store and manage student records.

Each student record contains:

- Student ID
- Student Name
- Programme
- Marks

Implemented operations:

- Add a student.
- Update student details.
- Delete a student.
- Search for a student.
- Display all student records.
- Prevent duplicate student IDs.
- Validate student marks.

### 4.2 Recent Action History – Stack

The stack module maintains a history of recent student management actions.

Implemented operations:

- Push new actions onto the stack.
- View the most recent action.
- Remove the most recent history entry.
- Display action history.
- Check the number of stored actions.

### 4.3 Service Request Management – Queue

The queue module manages student service requests using the First-In, First-Out (FIFO) principle.

Implemented operations:

- Add a service request.
- Process the next request.
- View the next pending request.
- Display pending requests.
- Check the number of pending requests.

### 4.4 Student Searching – Binary Search Tree (BST)

The BST module stores student records using student IDs as keys.

Implemented operations:

- Insert student records.
- Search for students.
- Delete student records.
- Display student records in sorted order using in-order traversal.
- Prevent duplicate student IDs.

### 4.5 Student Searching – Hash Table

The hash table module provides an efficient student searching mechanism using hashing.

Implemented features:

- Insert student records.
- Search using student IDs.
- Delete student records.
- Handle hash collisions using separate chaining.
- Prevent duplicate student IDs.

### 4.6 Campus Management – Graph

The graph module represents campus locations and the connections between them using an undirected adjacency list.

Implemented operations:

- Add campus locations.
- Remove campus locations.
- Connect two campus locations.
- Disconnect connected locations.
- Display the campus network.
- Display neighbouring locations.
- Find routes using Breadth-First Search (BFS).
- Traverse campus locations using Depth-First Search (DFS).

## 5. Project Structure

```text
UniversityStudentRecordSystem/
│
├── src/
│   ├── app/
│   │   └── Main.java
│   │
│   ├── studentmanagement/
│   │   ├── Student.java
│   │   ├── StudentNode.java
│   │   ├── StudentLinkedList.java
│   │   └── StudentManagementTest.java
│   │
│   ├── stackqueue/
│   │   ├── Action.java
│   │   ├── ActionNode.java
│   │   ├── ActionStack.java
│   │   ├── RequestNode.java
│   │   ├── ServiceRequest.java
│   │   ├── ServiceRequestQueue.java
│   │   └── StackQueueTest.java
│   │
│   ├── trees/
│   │   ├── StudentTreeNode.java
│   │   └── StudentBST.java
│   │
│   ├── hashing/
│   │   ├── HashNode.java
│   │   └── StudentHashTable.java
│   │
│   ├── searching/
│   │   └── SearchStructuresTest.java
│   │
│   └── graph/
│       ├── CampusLocation.java
│       ├── CampusGraph.java
│       └── CampusGraphTest.java
│
└── README.md
```

## 6. Installation and Execution

### Prerequisites

Ensure that Java Development Kit (JDK) 21 or a compatible version is installed.

Verify the Java installation:

```powershell
java -version
javac -version
```

### Clone the Repository

```powershell
git clone https://github.com/ayeshmanthak129-spec/CIT300_University_Management_System.git
```

Navigate into the project directory:

```powershell
cd CIT300_University_Management_System
```

### Compile the Application

Run the following command in Windows PowerShell from the project root directory:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
```

### Run the Application

```powershell
java -cp out app.Main
```

The main menu will appear in the console. Follow the displayed menu options to access the different modules.

## 7. Testing

The project includes individual test classes for the implemented data structures.

| Test Class | Module |
|---|---|
| `StudentManagementTest` | Linked List and Student Management |
| `StackQueueTest` | Stack and Queue |
| `SearchStructuresTest` | BST and Hash Table |
| `CampusGraphTest` | Graph, BFS and DFS |

### Running the Individual Tests

After compiling the application, run each test class using:

```powershell
java -cp out studentmanagement.StudentManagementTest
```

```powershell
java -cp out stackqueue.StackQueueTest
```

```powershell
java -cp out searching.SearchStructuresTest
```

```powershell
java -cp out graph.CampusGraphTest
```

The integrated application was also tested through its main menu, including student management, searching, action history, service requests and campus graph operations.

## 8. Group Members and Responsibilities

This project was developed collaboratively by four group members.

| Member | Student ID | Name | Responsibility |
|---|---|---|---|
| Member 1 | 22UG3-0399 | A.A.P. Kumarasiri | Linked List and Student Record Management; project integration |
| Member 2 | 22UG3-0436 | M R M FAHAD | Stack, Queue and Service Request Management |
| Member 3 | 22UG3-0811 | G.W.W.M.R.P.U.W.C.A.K Polgaspitiya | Binary Search Tree and Hashing |
| Member 4 | 22UG3-0141 | M.A.M AMMAR | Graph, Campus Locations, BFS and DFS |

Each member was responsible for implementing and testing their assigned module. The modules were integrated into the main application through GitHub branches and pull requests.

## 9. Version Control and Collaboration

Git and GitHub were used for collaborative development and source code management.

The group followed a branch-based development workflow:

1. Each member worked on an individual feature branch.
2. Members implemented and tested their assigned modules.
3. Changes were committed and pushed to GitHub.
4. Pull Requests were created for reviewing contributions.
5. Approved Pull Requests were merged into the main branch.
6. The integrated main application was added through a separate Pull Request.

**GitHub Repository:**

https://github.com/ayeshmanthak129-spec/CIT300_University_Management_System

## 10. Current Limitations

- Student records and service requests are stored in memory and are not permanently saved.
- Data is reset when the application terminates.
- The action stack maintains recent action history, but full automatic undo and restoration functionality is not implemented.
- The campus graph uses an unweighted, undirected adjacency list.

## 11. Conclusion

This project demonstrates how different data structures and algorithms can be combined to develop a practical university management application.

Through collaborative development, the group implemented linked lists, stacks, queues, binary search trees, hash tables and graphs, together with searching and graph traversal algorithms.

The project provided practical experience in Java programming, data structure implementation, testing, Git version control and collaborative software development.