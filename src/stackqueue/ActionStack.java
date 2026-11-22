package stackqueue;

public class ActionStack {

    private ActionNode top;
    private int size;

    public ActionStack() {
        top = null;
        size = 0;
    }

    // Check whether the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Return the number of actions
    public int getSize() {
        return size;
    }

    // Add an action to the stack
    public void push(Action action) {

        if (action == null) {
            System.out.println("Invalid action.");
            return;
        }

        ActionNode newNode = new ActionNode(action);

        newNode.setNext(top);
        top = newNode;

        size++;

        System.out.println("Action added to stack.");
    }

    // Remove and return the latest action
    public Action pop() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }

        Action removedAction = top.getAction();

        top = top.getNext();

        size--;

        System.out.println("Latest action removed.");

        return removedAction;
    }

    // View the latest action without removing it
    public Action peek() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }

        return top.getAction();
    }

    // Display all stored actions
    public void displayStack() {

        if (isEmpty()) {
            System.out.println("No actions available.");
            return;
        }

        ActionNode current = top;

        System.out.println("\n===== ACTION HISTORY =====");

        while (current != null) {

            System.out.println(current.getAction());

            current = current.getNext();
        }

        System.out.println("Total actions: " + size);
    }
}