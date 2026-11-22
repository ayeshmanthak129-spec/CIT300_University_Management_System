package stackqueue;

public class StackQueueTest {

    public static void main(String[] args) {

        System.out.println("===== STACK TESTING =====");

        ActionStack stack = new ActionStack();

        stack.push(new Action("Student added", null));
        stack.push(new Action("Student updated", null));
        stack.push(new Action("Student deleted", null));

        stack.displayStack();

        System.out.println("\nLatest action:");

        System.out.println(stack.peek());

        System.out.println("\nRemoving latest action:");

        System.out.println(stack.pop());

        stack.displayStack();

        System.out.println("\n===== QUEUE TESTING =====");

        ServiceRequestQueue queue =
                new ServiceRequestQueue();

        queue.enqueue(new ServiceRequest(
                "R001",
                "22UG3-0399",
                "Request for student ID card"));

        queue.enqueue(new ServiceRequest(
                "R002",
                "22UG3-0436",
                "Request for academic transcript"));

        queue.enqueue(new ServiceRequest(
                "R003",
                "22UG3-0811",
                "Request for confirmation letter"));

        queue.displayQueue();

        System.out.println("\nFirst request:");

        System.out.println(queue.peek());

        System.out.println("\nProcessing first request:");

        System.out.println(queue.dequeue());

        queue.displayQueue();

        System.out.println("\n===== FINAL RESULTS =====");

        System.out.println("Stack size: " + stack.getSize());

        System.out.println("Queue size: " + queue.getSize());

        System.out.println("Stack empty: " + stack.isEmpty());

        System.out.println("Queue empty: " + queue.isEmpty());

        System.out.println("\n===== TEST COMPLETED =====");
    }
}