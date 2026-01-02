package thucHanh;

import java.util.Arrays;

public class MyList<E> {
    // khởi tạo số lượng phần tử ban đầu
    private int size = 0;
    // khởi tạo hằng số độ dài của mảng ban đầu
    private static final int DEFAULT_CAPACITY = 10;
    // khai báo mảng lưu trữ phần ử trong mảng
    private Object elements[];

    // khởi tạo constructor không có tham số
    public MyList() {
        // khởi tạo mảng rỗng để lưu dữ liệu với kích thước ban đầu
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        // tăng gấp đôi kích thước của mảng chứa các phần tử
        int newSize = elements.length * 2;
        // tạo mảng mới với kích thước đó và copy dữ liệu cũ dang mảng mới
        elements = Arrays.copyOf(elements, newSize);
    }

    // thêm phần tử vào cuối danh sách
    public void add (E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        // thm phần tử vào cuối mảng
        elements[size] = e;
        size++; // tăng biến size lên 1
    }

    // get
    public E get (int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + i);
        }
        return (E) elements[i];
    }

}
