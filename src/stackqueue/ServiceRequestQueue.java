package stackqueue;

public class ServiceRequestQueue {

    private RequestNode front;
    private RequestNode rear;
    private int size;

    public ServiceRequestQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return the number of requests
    public int getSize() {
        return size;
    }

    // Add a request to the end of the queue
    public void enqueue(ServiceRequest request) {

        if (request == null) {
            System.out.println("Invalid service request.");
            return;
        }

        RequestNode newNode = new RequestNode(request);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }

        size++;

        System.out.println("Service request added successfully.");
    }

    // Remove the first request
    public ServiceRequest dequeue() {

        if (isEmpty()) {
            System.out.println("No service requests available.");
            return null;
        }

        ServiceRequest removedRequest = front.getRequest();

        front = front.getNext();

        if (front == null) {
            rear = null;
        }

        size--;

        System.out.println("Service request processed successfully.");

        return removedRequest;
    }

    // View the first request without removing it
    public ServiceRequest peek() {

        if (isEmpty()) {
            System.out.println("No service requests available.");
            return null;
        }

        return front.getRequest();
    }

    // Display all pending requests
    public void displayQueue() {

        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }

        RequestNode current = front;

        System.out.println("\n===== PENDING SERVICE REQUESTS =====");

        while (current != null) {

            System.out.println("\n" + current.getRequest());

            System.out.println("--------------------------");

            current = current.getNext();
        }

        System.out.println("Total pending requests: " + size);
    }
}