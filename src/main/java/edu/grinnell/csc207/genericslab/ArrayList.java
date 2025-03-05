package edu.grinnell.csc207.genericslab;

import java.util.Arrays;
import java.lang.reflect.Array;

/**
 * An array-based implementation of a list.
 *
 * @param <T>
 */
public class ArrayList<T extends Comparable <? super T>> {

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
        for(int n = 0; n < this.data.length - 2; n+=2) {
            T hold = this.data[n + 1];
            this.data[n + 1] = sep;
            this.data[n + 2] = hold;
        }
    }

    /**
     * Returns the maximum element found in the list.
     *
     * @return
     */
    public T maximum() {
        T max = this.data[0];
        for (int n = 1; n < this.data.length; n++) {
            if(this.data[n].compareTo(max) > 0) {
                max = this.data[n];
            }
        }
        return max;
    }

    /**
     * Returns a String representation of the list in the form: [x1, x2, ...,
     * xk]. where x1, x2, ..., xk are the elements of the list.
     *
     * @return
     */
    public String toString() {
        String result = "";
        for (int n = 1; n < this.data.length - 1; n++) {
            result += "[";
            result += this.data[n] + ",";
        }
        return result + this.data[this.data.length - 1] + "]";
    }

    /**
     * Sorts this list using the insertion sort algorithm. 
     */
    public void insertionSort() {
        for (int n = 0; n < this.data.length; n++) {
            for (int m = n; m >= 0; m--) {
                if (this.data[n].compareTo(this.data[m]) < 0) {
                    T hold = this.data[n];
                    this.data[n] = this.data[m];
                    this.data[m] =  hold;
                }
            }
        }
    }  
}
