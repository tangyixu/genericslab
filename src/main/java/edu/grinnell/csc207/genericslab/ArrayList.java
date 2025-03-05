package edu.grinnell.csc207.genericslab;

import java.util.Arrays;
import java.lang.reflect.Array;

/**
 * An array-based implementation of a list.
 *
 * @param <T>
 */
public class ArrayList<T> {

    private static final int INITIAL_SIZE = 8;
    private T[] data;
    private int sz;

    /**
     * Constructs a new, empty array list.
     *
     * @param classT
     */
    @SuppressWarnings("unchecked")
    public ArrayList(Class<T> classT) {
        this.data = (T[]) Array.newInstance(classT, 10);
    }

    private void ensureCapacity() {
        if (sz == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    /**
     * Adds <code>value</code> to the end of the list
     *
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        ensureCapacity();
        data[sz++] = value;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     *
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        } else {
            T ret = data[index];
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            sz -= 1;
            return ret;
        }
    }

    /**
     * Inserts sep in between each element of this list.
     *
     * @param sep
     */
    public void intersperse(T sep) {
        ;
    }

    /**
     * Returns the maximum element found in the list.
     *
     * @return
     */
    public T maximum() {
        ;
    }

    /**
     * returns a string representation of the list in the form: [x1, x2, ...,
     * xk]. where x1, x2, ..., xk are the elements of the list.
     *
     * @return
     */
    public String toString() {

    }

    void insertionSort()

: sorts this list using the insertion sort algorithm. Insertion sort proceeds by looping over the elements of the array, maintaining the following invariant:
}
