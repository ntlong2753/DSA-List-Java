package BaiTapLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("C");
        list.addLast("D");
        list.add(1, "B");
        list.addFirst("A");
        System.out.println("Danh sách có " + list.size() + " phần tử:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Phần tử đầu: " + list.getFirst());
        System.out.println("Phần tử cuối: " + list.getLast());
    }
}
