package graph;

import java.util.List;

public class CampusGraphTest {

    public static void main(String[] args) {

        CampusGraph graph = new CampusGraph();

        System.out.println("=== CAMPUS GRAPH TEST ===");

        // Test 1: Add locations
        System.out.println("\n1. Adding Locations:");

        System.out.println(graph.addLocation("L001", "Library"));
        System.out.println(graph.addLocation("L002", "Cafeteria"));
        System.out.println(graph.addLocation("L003", "Main Gate"));
        System.out.println(graph.addLocation("L004", "Laboratory"));
        System.out.println(graph.addLocation("L005", "Lecture Hall"));

        // Test duplicate location
        System.out.println("\n2. Duplicate Location Test:");
        System.out.println(graph.addLocation("L001", "Library"));

        // Test 2: Connect roads
        System.out.println("\n3. Connecting Roads:");

        System.out.println(graph.connectLocations("L001", "L002"));
        System.out.println(graph.connectLocations("L001", "L003"));
        System.out.println(graph.connectLocations("L002", "L004"));
        System.out.println(graph.connectLocations("L003", "L005"));
        System.out.println(graph.connectLocations("L004", "L005"));

        // Test invalid connection
        System.out.println("\n4. Invalid Connection Test:");
        System.out.println(graph.connectLocations("L001", "L999"));

        // Display network
        System.out.println("\n5. Complete Campus Network:");
        graph.displayNetwork();

        // Display neighbours
        System.out.println("\n6. Neighbours of Library:");
        graph.displayNeighbours("L001");

        // BFS route
        System.out.println("\n7. BFS Route from Library to Lecture Hall:");
        List<String> bfsPath = graph.bfs("L001", "L005");
        System.out.println(bfsPath);

        // DFS traversal
        System.out.println("\n8. DFS Traversal from Library:");
        List<String> dfsResult = graph.dfs("L001");
        System.out.println(dfsResult);

        // Remove road
        System.out.println("\n9. Remove Road:");
        System.out.println(graph.removeRoad("L001", "L002"));
        graph.displayNetwork();

        // Remove location
        System.out.println("\n10. Remove Location:");
        System.out.println(graph.removeLocation("L004"));
        graph.displayNetwork();

        System.out.println("\n=== TEST COMPLETED ===");
    }
}