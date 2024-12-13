package LAB6.src.collections;

import LAB6.src.gemstones.Gemstone;

import java.util.*;

public class CustomList<T extends Gemstone> implements List<T> {
    private static final int INITIAL_CAPACITY = 15; // Initial size of the internal array
    private static final double GROWTH_FACTOR = 1.3; // Array growth factor (30%)

    private T[] elements;
    private int size;

    /**
     * Default constructor that initializes an empty collection.
     */
    @SuppressWarnings("unchecked")
    public CustomList() {
        elements = (T[]) new Gemstone[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Constructor that initializes the collection with a single element.
     *
     * @param element the initial element to add to the collection
     */
    public CustomList(T element) {
        this();
        add(element);
    }

    /**
     * Constructor that initializes the collection with elements from a standard collection.
     *
     * @param collection the initial collection of elements
     */
    public CustomList(Collection<? extends T> collection) {
        this();
        for (T element : collection) {
            add(element);
        }
    }

    /**
     * Ensures the internal array has sufficient capacity.
     *
     * @param minCapacity the minimum required capacity
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = (int) (elements.length * GROWTH_FACTOR);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public boolean add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        ensureCapacity(size + collection.size());
        for (T element : collection) {
            elements[size++] = element;
        }
        return !collection.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        ensureCapacity(size + collection.size());
        System.arraycopy(elements, index, elements, index + collection.size(), size - index);
        for (T element : collection) {
            elements[index++] = element;
        }
        size += collection.size();
        return !collection.isEmpty();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Avoid memory leaks
        return removedElement;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[cursor++];
            }
        };
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("ListIterator is not implemented.");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("ListIterator is not implemented.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("SubList is not implemented.");
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U> U[] toArray(U[] array) {
        if (array.length < size) {
            return (U[]) Arrays.copyOf(elements, size, array.getClass());
        }
        System.arraycopy(elements, 0, array, 0, size);
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Object o : collection) {
            while (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;
        for (int i = size - 1; i >= 0; i--) {
            if (!collection.contains(elements[i])) {
                remove(i);
                modified = true;
            }
        }
        return modified;
    }
}