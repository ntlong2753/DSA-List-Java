package ArrayList;

import static com.sun.tools.javac.util.ArrayUtils.ensureCapacity;

public class MyList <E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    public void add (int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
            ensureCapacity(size + 1);
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        }
    }



}
