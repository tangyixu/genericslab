package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArrayListTests {

    @Test
    public void emptyArrayListTest() {
        ArrayList<Integer> lI = new ArrayList(Integer.class);
        ArrayList<String> lS = new ArrayList(String.class);
        assertEquals(0, lI.size());
        assertEquals(0, lS.size());
    }

    @Test
    public void ArraylistAddSize10Nums() {
        ArrayList<Integer> lI = new ArrayList(Integer.class);
        ArrayList<String> lS = new ArrayList(String.class);
        for (int i = 0; i < 10; i++) {
            lS.add(Integer.toString(i));
            lI.add(i);
        }
        assertEquals(10, lS.size());
        assertEquals(10, lI.size());
    }

    @Test
    public void ArraylistGetSeveral() {
        ArrayList<Integer> lI = new ArrayList(Integer.class);
        ArrayList<String> lS = new ArrayList(String.class);
        String[] elements = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        int[] integers = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < elements.length; i++) {
            lS.add(elements[i]);
            lI.add(integers[i]);

        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], lS.get(i));
            assertEquals(elements[i], lI.get(i));
        }
    }

    @Test
    public void ArraylistGetEmpty() {
        ArrayList<String> l = new ArrayList(String.class);
        l.add("");
        assertEquals("", l.get(0));
    }

    @Test
    public void ArraylistGetOOB() {
        ArrayList<Integer> lI = new ArrayList(Integer.class);
        ArrayList<String> lS = new ArrayList(String.class);
        lS.add("hello!");
        lS.add("goodbye!");
        lS.add("huh?");
        lI.add(1);
        lI.add(2);
        lI.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            lS.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lS.get(3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lI.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lI.get(3);
        });

    }

    @Test
    public void ArraylistRemoveSome() {
        ArrayList<Integer> lI = new ArrayList(Integer.class);
        ArrayList<String> lS = new ArrayList(String.class);

        lS.add("!");
        lS.add("@");
        lS.add(".");
        lS.add("#");
        lS.add("&");
        lI.add(5);
        lI.add(8);
        lI.add(7);
        lI.add(1);
        lI.add(9);

        assertEquals(7, lI.remove(2));
        assertEquals(8, lI.get(1));
        assertEquals(1, lI.get(2));

        assertEquals(5, lI.remove(0));
        assertEquals(8, lI.get(0));

        assertEquals(9, lI.remove(2));
        assertEquals(1, lI.get(1));

        assertEquals(".", lS.remove(2));
        assertEquals("@", lS.get(1));
        assertEquals("#", lS.get(2));

        assertEquals("!", lS.remove(0));
        assertEquals("@", lS.get(0));

        assertEquals("&", lS.remove(2));
        assertEquals("#", lS.get(1));
    }

    @Test
    public void ArraylistRemoveOOB() {
        ArrayList<Integer> lI = new ArrayList(Integer.class);
        ArrayList<String> lS = new ArrayList(String.class);
        lS.add("A");
        lS.add("B");
        lS.add("C");
        lI.add(5);
        lI.add(8);
        lI.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lS.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lS.remove(3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lI.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lI.remove(3);
        });
    }
}
