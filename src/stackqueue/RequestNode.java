package stackqueue;

public class RequestNode {

    private ServiceRequest request;
    private RequestNode next;

    public RequestNode(ServiceRequest request) {
        this.request = request;
        this.next = null;
    }

    public ServiceRequest getRequest() {
        return request;
    }

    public RequestNode getNext() {
        return next;
    }

    public void setNext(RequestNode next) {
        this.next = next;
    }
}