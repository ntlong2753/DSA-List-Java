package ThucHanhArrayList;

import java.util.Arrays;

// Khai báo lớp generic MyList với kiểu dữ liệu E (có thể là Integer, String, v.v.)
public class MyList <E> {
    // Số lượng phần tử hiện có trong danh sách
    private int size = 0;

    // Dung lượng mặc định ban đầu
    private static final int DEFAULT_CAPACITY = 10;

    // Mảng lưu trữ các phần tử (dùng kiểu Object để lưu mọi loại dữ liệu)
    private Object[] elements;

    // Constructor khởi tạo danh sách với dung lượng mặc định
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Hàm tăng dung lượng mảng khi đầy
    private void ensureCapacity() {
        // Nhân đôi dung lượng hiện tại
        int newSize = elements.length * 2;
        // Tạo mảng mới với dung lượng lớn hơn và sao chép dữ liệu cũ vào
        elements = Arrays.copyOf(elements, newSize);

    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elements[index];
    }
}
