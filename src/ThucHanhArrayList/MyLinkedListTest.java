package ThucHanhArrayList;



public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(10);
        ll.addFirst(11);
        ll.addFirst(12);

        ll.add(2,6);
        ll.add(3,8);
        ll.printList();
    }
}
