package graph;

import java.util.*;

public class CampusGraph {

    private final Map<String, CampusLocation> locations;

    public CampusGraph() {
        locations = new LinkedHashMap<>();
    }

    // Add a new campus location
    public boolean addLocation(String locationId, String name) {

        if (locationId == null || locationId.isBlank()
                || name == null || name.isBlank()) {
            return false;
        }

        String id = locationId.trim();

        if (locations.containsKey(id)) {
            return false;
        }

        CampusLocation location = new CampusLocation(id, name);
        locations.put(id, location);

        return true;
    }

    // Remove a campus location
    public boolean removeLocation(String locationId) {

        if (locationId == null || !locations.containsKey(locationId)) {
            return false;
        }

        CampusLocation location = locations.get(locationId);

        for (String neighbourId : location.getNeighbours()) {
            CampusLocation neighbour = locations.get(neighbourId);

            if (neighbour != null) {
                neighbour.removeNeighbour(locationId);
            }
        }

        locations.remove(locationId);

        return true;
    }

    // Connect two campus locations
    public boolean connectLocations(String id1, String id2) {

        if (id1 == null || id2 == null || id1.equals(id2)) {
            return false;
        }

        CampusLocation location1 = locations.get(id1);
        CampusLocation location2 = locations.get(id2);

        if (location1 == null || location2 == null) {
            return false;
        }

        if (location1.getNeighbours().contains(id2)) {
            return false;
        }

        location1.addNeighbour(id2);
        location2.addNeighbour(id1);

        return true;
    }

    // Remove road between two locations
    public boolean removeRoad(String id1, String id2) {

        if (id1 == null || id2 == null) {
            return false;
        }

        CampusLocation location1 = locations.get(id1);
        CampusLocation location2 = locations.get(id2);

        if (location1 == null || location2 == null) {
            return false;
        }

        if (!location1.getNeighbours().contains(id2)) {
            return false;
        }

        location1.removeNeighbour(id2);
        location2.removeNeighbour(id1);

        return true;
    }

    // Display the complete campus network
    public void displayNetwork() {

        System.out.println("\n--- Campus Network ---");

        if (locations.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        for (CampusLocation location : locations.values()) {

            System.out.println(
                    location.getLocationId() + " - "
                            + location.getName()
                            + " -> " + location.getNeighbours()
            );
        }
    }

    // Display neighbours of a location
    public void displayNeighbours(String locationId) {

        CampusLocation location = locations.get(locationId);

        if (location == null) {
            System.out.println("Location not found.");
            return;
        }

        System.out.println(
                "Neighbours of " + location.getName()
                        + ": " + location.getNeighbours()
        );
    }

    // Breadth-First Search to find a route
    public List<String> bfs(String startId, String targetId) {

        if (!locations.containsKey(startId)
                || !locations.containsKey(targetId)) {
            return new ArrayList<>();
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(startId);
        visited.add(startId);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (current.equals(targetId)) {
                break;
            }

            CampusLocation location = locations.get(current);

            for (String neighbour : location.getNeighbours()) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    parent.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }

        if (!visited.contains(targetId)) {
            return new ArrayList<>();
        }

        List<String> path = new ArrayList<>();
        String current = targetId;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        return path;
    }

    // Depth-First Search traversal
    public List<String> dfs(String startId) {

        List<String> traversal = new ArrayList<>();

        if (!locations.containsKey(startId)) {
            return traversal;
        }

        Set<String> visited = new LinkedHashSet<>();

        dfsHelper(startId, visited, traversal);

        return traversal;
    }

    // Recursive DFS helper
    private void dfsHelper(
            String current,
            Set<String> visited,
            List<String> traversal) {

        visited.add(current);
        traversal.add(current);

        CampusLocation location = locations.get(current);

        for (String neighbour : location.getNeighbours()) {

            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited, traversal);
            }
        }
    }

    // Get a campus location
    public CampusLocation getLocation(String locationId) {
        return locations.get(locationId);
    }

    // Get all campus locations
    public Collection<CampusLocation> getAllLocations() {
        return Collections.unmodifiableCollection(locations.values());
    }
}