package BaiTapLinkedList;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    // khởi tạp constructor không tham số
    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    // thêm pần tử vào vị trí chỉ định
    public void add(int index, E element) {
        if(index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Chỉ số không hợp lệ");
        }
        // Nếu thêm vào vị trí đầu
        if(index == 0) {
            addFirst(element);
        }
        else { // Nếu thêm vào vị trí giữa hoặc cuối
            Node temp = head;
            for(int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
        }
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }
    // thêm phần tử vào đầu danh sách
    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }
    // thêm phần tử vào cuối danh sách
    public void addLast(E e) {
        Node newNode = new Node(e);
        if(head == null) {
            head = newNode;
        }
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        numNodes++;
    }

    // xóa phần tử tại vị trí index
    public E remove(int index) {
        if(index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        if(index == 0) {
            E data = (E) head.data;
            head = head.next;
            temp.next = null;
            numNodes--;
            return data;
        }
        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        E data = (E) temp.next.data;
        temp.next = temp.next.next;
        numNodes--;
        return data;
    }

    // xóa phần tử đầu tiên có gì trị e
    public boolean remove (Object e) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(e)) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node temp = head;
        while(temp.next != null) {
            if (temp.next.data.equals(e)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // trả về số lượng phần tử
    public int size() {
        return numNodes;
    }

    // tạo bản sao
    public MyLinkedList<E> clone() {
        MyLinkedList<E> clonedList = new MyLinkedList<E>();
        Node temp = head;
        while(temp != null) {
            clonedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return clonedList;
    }

    public boolean contains(E o) {
        Node temp = head;
        while(temp != null) {
            if(temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf (E o) {
        Node temp = head;
        int index = 0;
        while(temp != null) {
            if(temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        //Node newNode = new Node(minCapacity);
    }

    public E get(int i) {
        if(i < 0 || i > numNodes) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for(int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    // trả về phần tử đầu tiên
    public E getFirst() {
        if(head == null) {
            return null;
        }
        return (E) head.data;
    }

    // trả về phần tử cuối cùng
    public E getLast() {
        if(head == null) {
            return null;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
    // xóa toa bộ danh sách
    public void clear() {
        head = null;
        numNodes = 0;
    }
}
