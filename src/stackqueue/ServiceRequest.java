package stackqueue;

public class ServiceRequest {

    private String requestId;
    private String studentId;
    private String description;

    public ServiceRequest(String requestId,
                          String studentId,
                          String description) {

        if (requestId == null || requestId.isBlank()) {
            throw new IllegalArgumentException(
                    "Request ID cannot be empty.");
        }

        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Student ID cannot be empty.");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException(
                    "Request description cannot be empty.");
        }

        this.requestId = requestId.trim();
        this.studentId = studentId.trim();
        this.description = description.trim();
    }

    public String getRequestId() {
        return requestId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {

        return "Request ID: " + requestId
                + "\nStudent ID: " + studentId
                + "\nDescription: " + description;
    }
}