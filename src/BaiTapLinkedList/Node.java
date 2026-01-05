package BaiTapLinkedList;

public class Node {
    Node next;
    Object data;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return this.data;
    }
}
