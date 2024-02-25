package Models;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class ArrList<E> extends AbstractList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public ArrList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrList(int capacity) {
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Error");
        }
        return (E) elements[index];
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Error");
        }
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Error");
        }
        Object item = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (E) item;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0 ; i < size; ++i)
            s += elements[i] + "\n";
        return s;
    }
}
