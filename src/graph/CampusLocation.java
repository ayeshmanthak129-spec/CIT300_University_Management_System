package graph;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Represents one location on the university campus.
 * Each location stores its ID, name and neighbouring locations.
 */
public class CampusLocation {

    private final String locationId;
    private final String name;

    // Stores IDs of locations directly connected to this location.
    private final Set<String> neighbours;

    /**
     * Creates a campus location.
     *
     * @param locationId unique ID of the location
     * @param name name of the campus location
     */
    public CampusLocation(String locationId, String name) {

        if (locationId == null || locationId.isBlank()) {
            throw new IllegalArgumentException(
                    "Location ID cannot be empty."
            );
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Location name cannot be empty."
            );
        }

        this.locationId = locationId.trim();
        this.name = name.trim();

        this.neighbours = new LinkedHashSet<>();
    }

    public String getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns an unmodifiable view of neighbouring location IDs.
     */
    public Set<String> getNeighbours() {
        return Collections.unmodifiableSet(neighbours);
    }

    /**
     * Adds a neighbouring location.
     */
    void addNeighbour(String locationId) {
        neighbours.add(locationId);
    }

    /**
     * Removes a neighbouring location.
     */
    void removeNeighbour(String locationId) {
        neighbours.remove(locationId);
    }

    @Override
    public String toString() {
        return "CampusLocation{" +
                "locationId='" + locationId + '\'' +
                ", name='" + name + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }
}